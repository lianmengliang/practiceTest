package com.test.qqclient.service;


import com.test.common.Message;
import com.test.common.MessageType;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Author ： Leo
 * @Date : 2021/7/15 17:46
 * @Desc:
 */
public class ClientConnectServerThread extends Thread {

    /**
     * 该线程需要持有Socket
     */
    private Socket socket;

    /**
     * 构造器
     *
     * @param socket
     */
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    /**
     * @return
     */
    public Socket getSocket() {
        return this.socket;
    }

    @Override
    public void run() {
        // 因为Thread需要在后台和服务器通信，因此我们需要while循环
        while (true) {
            try {
                System.out.println("客户端线程，等待从读取从服务器端发送的消息...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 如果服务器没有发送Message对象，线程会阻塞在这里
                Message ms = (Message) ois.readObject();
                // 判断这个Message类型，然后做相对应的业务处理
                // 如果读取到的是服务端返回的在线的用户列表
                if (ms.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //取出在线列表信息，并显示
                    // 规定用户id，以英文逗号隔开
                    String content = ms.getContent();
                    String[] userIdArray = content.split(",");
                    System.out.println("=========当前的在线用户列表=========");
                    for (String useId : userIdArray) {
                        System.out.println("用户：" + useId);
                    }
                } else {
                    System.out.println("其他类型message，暂时不处理");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
