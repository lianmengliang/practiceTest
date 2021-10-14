package com.example.test.java_basis.network_programming.socket.tcp.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Author ： Leo
 * @Date : 2021/7/6 11:50
 * @Desc: 客户端：向服务端发送hello，server的消息
 */
@SuppressWarnings({"all"})
public class SocketTCP04Client {
    public static void main(String[] args) throws IOException {

        //思路
        // 1.连接服务端（ip，端口）
        // 细节： 连接本机的9999端口，如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客端Socket= " + socket.getClass());

        // 2.连接上后，生成Socket，通过socket.getOutStream()
        // 得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();

        // 拷贝图片
        String srcFilePath = "G:\\testIO\\6.jpg";
        outputStream = new FileOutputStream(srcFilePath);
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);



        // 3.通过输出流，写入数据到 数据通道 （发送消息）

        // 设置一个结束标志
        // 插入一个换行符，表示写入的内容结束，注意，要求对方使用readLine()读取
        // 使用字符流，需要手动刷新，否则数据不会写入数据通道


        // 4.接收服务端发送过来的信息
        InputStream inputStream = socket.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String readLen = null;

        System.out.print("收到服务端发来的消息：");
        while ((readLen = reader.readLine()) != null) {
            System.out.println(readLen);
        }


        // 5.关闭资源
        reader.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
