package com.example.test.javaBasis.network_programming.socket.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 作业2：
 * * 1.使用字符流的方式，编写一个客户端程序和服务器程序
 * * 2.客户端发送 "name",服务端接收后，返回，“我是XXX”
 * * 3.客户端发送“hobby”，服务器端接收到后，返回“编写java”程序
 * * 4.不是这两个回复，回复“你说的啥”
 *
 * @Author ： Leo
 * @Date : 2021/7/8 14:36
 * @Desc:
 */
public class Homework01Server {
    public static void main(String[] args) throws IOException {

        // 创建socket对象，并监听 8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端等待被连接...");

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String s = reader.readLine();
        System.out.println("来自客户端的消息：" + s);

        String answer = "";
        if (s.equals("name")) {
            answer = "我是Leo";
        } else if (s.equals("hobby")) {
            answer = "我热爱编程";
        } else {
            answer = "你说的啥";
        }

        // 回复消息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write(answer);
        writer.newLine();
        writer.flush();


        // 关闭资源
        writer.close();
        reader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");


    }
}
