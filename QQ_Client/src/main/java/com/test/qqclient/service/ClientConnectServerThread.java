package com.test.qqclient.service;





import com.test.common.Message;

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


            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

}
