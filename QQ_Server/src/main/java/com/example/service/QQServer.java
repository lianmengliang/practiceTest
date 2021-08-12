package com.example.service;

import com.example.common.Message;
import com.example.common.MessageType;
import com.example.common.User;
import com.example.utils.DateUtil;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author ： Leo
 * @Date : 2021/7/16 11:50
 * @Desc: 这是服务器，监听9999，等待客户端的连接
 */
public class QQServer {

    private ServerSocket ss = null;

    /**
     * 该集合用于存放多个用户，如果是这些用户登录，就是合法，反之不合法
     * 这里我们也可以使用 ConcurrentHashMap，可以处理并发的集合
     * HashMap 没有处理线程安全，因此多线程情况下是不安全的
     * ConcurrentHashMap处理的线程安全，即线程同步处理，在多线程情况下是安全的
     */
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();

    /**
     * 用于存放用户之间的离线消息/文件
     * K - String：接收消息的用户id（getterId）
     * V - List<Message>: 存放多条离线的消息/文件
     */
    private static ConcurrentHashMap<String, ArrayList<Message>> offlineMessage = new ConcurrentHashMap<>();


    /**
     * 静态代码块，初始化 validUsers对象
     */
    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("Alice", new User("Alice", "686"));
        validUsers.put("Leo", new User("leo", "888"));
        validUsers.put("Kevin", new User("kevin", "666"));

        Message message = new Message();
        message.setGetter("100");
        message.setSender("Leo");
        message.setContent("我们都是好孩子");
        message.setMessageType(MessageType.GET_OFFLINE_MESSAGE);
        message.setSendTime(DateUtil.getCurrentTime(DateUtil.DATE_TIME_FORMAT));
        message.setDesc("离线消息");
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(message);
        offlineMessage.put(message.getGetter(), messages);

    }

    /**
     * 用于校验用户是否合法
     *
     * @param userId
     * @param pwd
     */
    public static boolean checkUser(String userId, String pwd) {

        User user = validUsers.get(userId);
        /*if (user != null) {
            if (user.getPassword().equals(pwd)) {
                result = true;
            }
        }*/

        //也可采用过关方法验证用户，这样方便判断是用户id还是用户密码出错
        if (user == null) {
            System.out.println("用户id有误");
            return false;
        }
        if (!user.getPassword().equals(pwd)) {
            System.out.println("用户密码有误");
            return false;
        }

        return true;
    }

    /**
     * 添加用户---> 注册新用户
     *
     * @param userId
     * @param pwd
     * @return
     */
    public static boolean addUser(String userId, String pwd) {
        // 注意该用户已存在的情况
        if (validUsers.get(userId) != null) {
            System.out.println(userId + "该用户已存在");
            return false;
        }
        // 添加用户
        validUsers.put(userId, new User(userId, pwd));
        return true;
    }

    /**
     * 添加离线留言 信息/文件
     *
     * @param getterId
     * @param ms
     */
    public static void addOfflineMessage(String getterId, Message ms) {
        ArrayList<Message> messageArrayList = offlineMessage.get(getterId);
        if (messageArrayList == null && messageArrayList.isEmpty()) {
            ArrayList<Message> messages = new ArrayList<>();
            messages.add(ms);
            offlineMessage.put(getterId, messages);
            return;
        }
        messageArrayList.add(ms);
        offlineMessage.put(getterId, messageArrayList);
    }

    public QQServer() {
        // 端口可以写到配置文件中，方便改动端口
        try {
            System.out.println("服务器在9999端口监听...");
            // 启动推送新闻的线程
            new Thread(new SendNewsToAllService()).start();
            ss = new ServerSocket(9999);

            // 当和某个客户端连接后，会继续监听，因此需要用到while循环
            while (true) {
                Socket socket = ss.accept();
                // 获取对象的输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject();
                String userId = user.getUserId();

                // 得到socket关联对象的输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                // 准备回复一个客户端
                Message message = new Message();
                if (user.getSignInOrRegister() == 1) {
                    // 用户登录
                    // 验证用户合法性
                    if (QQServer.checkUser(userId, user.getPassword())) {
                        // 验证通过，登录成功
                        message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                        oos.writeObject(message);
                        // 创建一个线程，和客户端保持通信，该线程应该持有socket对象
                        ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, userId);
                        // 启动该线程
                        serverConnectClientThread.start();
                        // 把该线程对象放入到集合中进行管理
                        ManagerServerConnectClientThread.addServerConnectClientThreadToMap(userId, serverConnectClientThread);

                    } else {
                        // 验证失败，登录失败
                        System.out.println("用户" + userId + "登录失败---(验证失败)");
                        message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                        oos.writeObject(message);
                        // 关闭socket
                        socket.close();
                    }
                } else {
                    // 用户注册
                    if (QQServer.addUser(userId, user.getPassword())) {
                        // 注册成功
                        System.out.println("用户" + userId + "注册成功");
                        message.setMessageType(MessageType.MESSAGE_REGISTER_SUCCEED);
                        oos.writeObject(message);

                    } else {
                        // 注册失败
                        System.out.println("用户" + userId + "注册失败");
                        message.setMessageType(MessageType.MESSAGE_REGISTER_FAIL);
                        message.setContent("该用户id已存在");
                        oos.writeObject(message);
                    }
                    // 关闭socket
                    socket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 如果服务器退出了while，说明服务器不再监听了，因此需要关闭ServerSocket
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ConcurrentHashMap<String, User> getValidUsers() {
        return validUsers;
    }

    public static ConcurrentHashMap<String, ArrayList<Message>> getOfflineMessage() {
        return offlineMessage;
    }
}
