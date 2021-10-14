package com.example.test.java_basis.network_programming.socket.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 作业2：
 * 1.使用字符流的方式，编写一个客户端程序和服务器程序
 * 2.客户端发送 "name",服务端接收后，返回，“我是XXX”
 * 3.客户端发送“hobby”，服务器端接收到后，返回“编写java”程序
 * 4.不是这两个回复，回复“你说的啥”
 *
 * @Author ： Leo
 * @Date : 2021/7/8 14:35
 * @Desc:
 */
public class Homework01Client {
    public static void main(String[] args) throws IOException {
        // 创建监听器
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //发送信息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        System.out.println("请输出要回复的消息:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        writer.write(s);
        writer.newLine();
        writer.flush();


        //接收回复的消息
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String message = reader.readLine();

        System.out.println("接收到服务端的回信：" + message);

        //关闭资源
        writer.close();
        reader.close();
        socket.close();


    }
}
