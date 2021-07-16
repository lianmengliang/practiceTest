package com.server.service;

import com.server.common.Message;

import java.io.ObjectInputStream;
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
                System.out.println("服务端和客户端" + userId + "保持通信...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 读取消息
                Message ms = (Message) ois.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
