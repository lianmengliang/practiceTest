package com.example.test.javaBasis.network_programming.socket.tcp;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author ： Leo
 * @Date : 2021/7/6 11:50
 * @Desc: 客户端：向服务端发送hello，server的消息
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {

        //思路
        // 1.连接服务端（ip，端口）
        // 细节： 链接本机的9999端口，如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客端Socket= " +socket.getClass());

        // 2.连接上后，生成Socket，通过socket.getOutStream()
        // 得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();

        // 3.通过输出流，写入数据到 数据通道 （发送消息）
        outputStream.write("hello,Server".getBytes());

        // 4.关闭资源
        outputStream.close();
        socket.close();

    }
}
