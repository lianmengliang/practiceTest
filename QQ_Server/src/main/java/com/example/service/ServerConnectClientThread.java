package com.example.service;


import com.example.common.Message;
import com.example.common.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author ： Leo
 * @Date : 2021/7/16 12:05
 * @Desc: 该类的对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    /**
     * 连接服务端的用户id
     */
    private String userId;

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }


    @Override
    public void run() {
        // 这里的线程处于run状态，可以发送/接收消息
        while (true) {
            try {
                System.out.println("服务端和客户端-" + userId + "-保持通信...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 读取消息
                Message ms = (Message) ois.readObject();
                //后面根据message的类型，做相对应的业务处理
                if (ms.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    // 客户端在线用户列表
                    System.out.println(ms.getSender() + "想要在线的用户列表");
                    String onlineUsers = ManagerServerConnectClientThread.getOnlineUser();
                    // 返回一个message
                    Message message = new Message();
                    message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
                    message.setContent(onlineUsers);
                    message.setGetter(ms.getSender());

                    // 写入到数据通道，返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);

                } else if (ms.getMessageType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(ms.getSender() + "要退出系统了...");
                    //移除userID对应的线程
                    ManagerServerConnectClientThread.removeClientConnectServerThread(ms.getSender());
                    // 关闭socket
                    socket.close();
                    // 退出线程
                    break;
                } else if (ms.getMessageType().equals(MessageType.MESSAGE_COMM_MES)) {
                    // 接收客户端某用户私发给其他在线用户的 消息对象
                    //根据消息对象获取要发送的用户
                    String getter = ms.getGetter();
                    // 根据getter获取相对应的线程 以及 socket
                    ServerConnectClientThread thread = ManagerServerConnectClientThread.getServerConnectClientThread(getter);
                    //获取转发用户的输出流
                    ObjectOutputStream oosForward = new ObjectOutputStream(thread.getSocket().getOutputStream());
                    // 转发，提示如果客户不在线，可以先把消息存到数据库，实现离线发送功能
                    oosForward.writeObject(ms);

                } else if (ms.getMessageType().equals(MessageType.MESSAGE_MASS_MESSAGE)) {
                    //获取在线用户
                    String onlineUsers = ManagerServerConnectClientThread.getOnlineUser();
                    String[] userIds = onlineUsers.split(",");
                    for (String userId : userIds) {
                        // 排除发送者
                        if (userId.equals(ms.getSender())) {
                            ObjectOutputStream oos = new ObjectOutputStream(ManagerServerConnectClientThread.getServerConnectClientThread(userId).getSocket().getOutputStream());
                            oos.writeObject(ms);
                        }
                    }
                } else if (ms.getMessageType().equals(MessageType.MESSAGE_FILE)) {
                    //根据getter获取相对应的线程
                    ServerConnectClientThread thread = ManagerServerConnectClientThread.getServerConnectClientThread(ms.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream(thread.getSocket().getOutputStream());
                    System.out.println("\n" + ms.getSender() + "给" + ms.getGetter() + "发送了文件" + ms.getSrc() + "到对方的电脑目录" + ms.getDest());
                    // 转发
                    oos.writeObject(ms);
                } else if (ms.getMessageType().equals(MessageType.MESSAGE_OFFLINE_MSG) || ms.getMessageType().equals(MessageType.MESSAGE_OFFLINE_FILE)) {
                    // 服务端接收到离线消息或文件
                    System.out.println("服务端接收到" + ms.getSender() + "对" + ms.getGetter() + "的离线消息或文件");
                    if (ms.getMessageType().equals(MessageType.MESSAGE_OFFLINE_MSG)){
                        ms.setMessageType(MessageType.GET_OFFLINE_MESSAGE);
                    }
                    QQServer.addOfflineMessage(ms.getGetter(), ms);
                } else if (ms.getMessageType().equals(MessageType.GET_OFFLINE_MESSAGE)) {
                    ConcurrentHashMap<String, ArrayList<Message>> offlineMessages = QQServer.getOfflineMessage();
                    // 获取离线消息
                    List<Message> messages = offlineMessages.get(ms.getSender());
                    // 判断用户 是否有离线消息
                    if (messages != null && !messages.isEmpty()) {
                        for (Message message : messages) {
                            ObjectOutputStream oos = new ObjectOutputStream(ManagerServerConnectClientThread.getServerConnectClientThread(ms.getSender()).getSocket().getOutputStream());
                            // 向用户发送别人的离线消息
                            oos.writeObject(message);
                            System.out.println(ms.getSender() + "获取" + message.getDesc());
                        }
                        //移除 该用户的离线消息/文件
                        offlineMessages.remove(userId);
                    } else {
                        System.out.println(ms.getSender() + "没有离线消息");
                    }

                } else {
                    System.out.println("其他类型的业务，暂时不处理...");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
