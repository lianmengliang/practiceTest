package com.example.test.javaBasis.network_programming.socket.tcp.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 作业 1  （使用字符流）
 * * 1.编写一个服务器端,和一个客户端
 * * 2.服务器端在9999端口监听
 * * 3.客户端连接到服务器端，发送"hello, server"，并接收服务端回发的信息后，再退出
 * * 4.服务器端接收到客户端发送的信息，输出,并向客户端发送“hello，Client”消息，再退出
 *
 * @Author ： Leo
 * @Date : 2021/7/6 11:47
 * @Desc: 服务端: 接收客户端发送的消息，并且回复一条消息
 */
@SuppressWarnings({"all"})
public class SocketTCP04Server {
    public static void main(String[] args) throws IOException {
        // 思路
        // 1.在本机的9999端口监听，等待连接
        //  细节：要求在本机没有其他服务在监听9999端口，否则会报错，该端口被占用
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端，在9999端口监听，等待连接...");

        // 2.当没有客户端连接9999端口时，程序会阻塞，等待连接
        // 如果有客户端连接，则会返回Socket对象，程序继续
        //细节：serverSocket.accept()方法可以返回多个Socket[多个客服端连接服务器的并发]
        Socket socket = serverSocket.accept();
        System.out.println("收到" + socket.getClass() + "服务端的连接...");

        //3.通过socket.getInputStream读取客户端写入到数据通道的数据，并显示
        InputStream inputStream = socket.getInputStream();

        //4.使用转换流，把字节流转换为字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));



        //4.IO读取客户端发来的消息
      /*  String readLen = null;
        System.out.print("收到客户端发来的消息：");
        while ((readLen = reader.readLine())!=null){
            System.out.println(readLen);
        }*/
        String s = reader.readLine();
        System.out.println(s);//输出

        //5.向客户端发送消息 (发送完消息，设置一个结束标记)
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        writer.write("hello,Client - 字符流");
        // 设置一个结束标志
        // 插入一个换行符，表示写入的内容结束，注意，要求对方使用readLine()读取
        writer.newLine();
        // 使用字符流，需要手动刷新，否则数据不会写入数据通道
        writer.flush();


        //6..关闭资源 (流和socket)
        writer.close();
        reader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");

    }
}
