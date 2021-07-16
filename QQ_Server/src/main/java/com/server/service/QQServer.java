package com.server.service;

import com.server.common.Message;
import com.server.common.MessageType;
import com.server.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author ： Leo
 * @Date : 2021/7/16 11:50
 * @Desc: 这是服务器，监听9999，等待客户端的连接
 */
public class QQServer {

    private ServerSocket ss = null;


    public QQServer() {
        // 端口可以写到配置文件中，方便改动端口
        try {
            System.out.println("服务器在9999端口监听...");
            ss = new ServerSocket(9999);

            // 党和某个客户端连接后，会继续监听，因此需要用到while循环
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
                // 验证用户合法性
                if (userId.equals("100") && user.getPasswoed().equals("123456")) {
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
                    System.out.println("用户" + userId + "登录失败");
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
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
}
