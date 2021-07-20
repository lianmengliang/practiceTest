package com.test.service;


import com.test.common.Message;
import com.test.common.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Author ： Leo
 * @Date : 2021/7/16 12:05
 * @Desc: 该类的对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;

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
                if (ms.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    // 客户端在线用户列表
                    System.out.println(ms.getSender()+"想要在线的用户列表");
                    String onlineUsers = ManagerServerConnectClientThread.getOnlineUser();
                    // 返回一个message
                    Message message = new Message();
                    message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
                    message.setContent(onlineUsers);
                    message.setGetter(ms.getSender());

                    // 写入到数据通道，返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);

                } else if(ms.getMessageType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(ms.getSender()+"要退出系统了...");
                    //移除userID对应的线程
                    ManagerServerConnectClientThread.removeClientConnectServerThread(ms.getSender());
                   // 关闭socket
                    socket.close();
                    // 退出线程
                    break;
                }else{
                    System.out.println("其他类型的业务，暂时不处理...");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
