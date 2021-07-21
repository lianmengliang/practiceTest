package com.test.qqclient.service;


import com.test.common.Message;
import com.test.common.MessageType;
import com.test.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author ： Leo
 * @Date : 2021/7/15 17:31
 * @Desc: 完成用户的验证和注册等功能
 */
public class UserClientService {
    /**
     * 属性：
     * 因为我们可能在其他地方使用到user信息，因此作为作为成员属性
     */
    private User user = new User();

    /**
     *
     */
    private Socket socket;

    /**
     * 验证用户是否合法
     *
     * @param userId
     * @param pwd
     * @param num    1:登录，2，注册
     * @return
     */
    public boolean signInOrResgister(String userId, String pwd, Integer num) {
        boolean variable = false;

        //创建User对象
        user.setUserId(userId);
        user.setPassword(pwd);
        user.setSignInOrRegister(num);

        // 连接服务器，发送user对象
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            // 得到Object的 OutputStream的对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            oos.writeObject(user);

            //读取从服务器回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            // 判断是否登录成功
            if (ms.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {

                // 创建一个服务器端保持通信的线程 -> 创建一个类 ClientConnectServerThread
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                // 启动客户端的线程
                ccst.start();
                // 为了后面客户端的扩展，我们将线程放入集合管理
                ManagerClientConnectServerThread.addClientConnectServerThreadToMap(userId, ccst);
                variable = true;
            } else if (ms.getMessageType().equals(MessageType.MESSAGE_REGISTER_SUCCEED)) {
                System.out.println("用户" + userId + "注册成功");
                socket.close();
            } else if (ms.getMessageType().equals(MessageType.MESSAGE_REGISTER_FAIL)) {
                System.out.println(userId + "注册失败，原因：" + ms.getContent());
                socket.close();
            } else {
                // 如果登录失败，不能启动和服务器通信的线程，关闭Socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return variable;
    }

    /**
     * 获取 用户的在线列表
     */
    public void onlineFriendList() throws IOException {

        // 发送一个Message，类类型MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(user.getUserId());
        // 根据用户id获取 相对应的线程，然后再根据线程获取到Socket
        ClientConnectServerThread thread = ManagerClientConnectServerThread.getClientConnectServerThreadByUserId(user.getUserId());

//获取Socket对象 的输出流，便于向服务端发送消息
        ObjectOutputStream oos = new ObjectOutputStream(thread.getSocket().getOutputStream());
        // 发送消息
        oos.writeObject(message);

    }

    /**
     * 退出客户端，并给服务端发送一个退出系统的message的对象
     */
    public void logout() {

        Message message = new Message();
        message.setSender(user.getUserId());
        message.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);

        //发送message
        try {
            // 可以使用下面这种方式获取socket，然后再发送信息
            // 下面这种方式也适合  多个socket
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectServerThread.getClientConnectServerThreadByUserId(user.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(user.getUserId() + "退出系统");
            // 结束进程
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
