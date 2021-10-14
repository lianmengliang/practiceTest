package com.example.test.java_basis.network_programming.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 作业 2  （使用字节流）
 * * 1.编写一个服务器端,和一个客户端
 * * 2.服务器端在9999端口监听
 * * 3.客户端连接到服务器端，发送"hello, server"，并接收服务端回发的信息后，再退出
 * * 4.服务器端接收到客户端发送的信息，输出,并向客户端发送“hello，Client”消息，再退出
 *
 * @Author ： Leo
 * @Date : 2021/7/6 11:47
 * @Desc: 服务端: 接收客户端发送的消息，并且回复一条消息
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        // 思路
        // 1.在本机的9999端口监听，等待连接
        //  细节：要求在本机没有其他服务在监听9999端口，否则会报错，该端口被占用
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接...");

        // 2.当没有客户端连接9999端口时，程序会阻塞，等待连接
        // 如果有客户端连接，则会返回Socket对象，程序继续
        //细节：serverSocket.accept()方法可以返回多个Socket[多个客服端连接服务器的并发]
        Socket socket = serverSocket.accept();
        System.out.println("收到" + socket.getClass() + "服务端的连接...");

        //3.通过socket.getInputStream读取客户端写入到数据通道的数据，并显示
        InputStream inputStream = socket.getInputStream();

        //4.IO读取客户端发来的消息
        int readLen = 0;
        byte[] bytes = new byte[1024];
        System.out.print("客户端发来的消息：");
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,readLen));
        }


        //5.向客户端发送消息 (发送完消息，设置一个结束标记)
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,Client".getBytes());
        // 设置一个结束标志
        socket.shutdownOutput();


        //6..关闭资源 (流socket)
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");

    }
}
