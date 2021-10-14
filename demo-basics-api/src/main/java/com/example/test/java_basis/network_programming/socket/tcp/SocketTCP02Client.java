package com.example.test.java_basis.network_programming.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author ： Leo
 * @Date : 2021/7/6 11:50
 * @Desc: 客户端：向服务端发送hello，server的消息
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {

        //思路
        // 1.连接服务端（ip，端口）
        // 细节： 链接本机的9999端口，如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客端Socket= " + socket.getClass());

        // 2.连接上后，生成Socket，通过socket.getOutStream()
        // 得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();

        // 3.通过输出流，写入数据到 数据通道 （发送消息）
        outputStream.write("hello,Server".getBytes());
        // 设置一个结束标志
        socket.shutdownOutput();

        // 4.接收服务端发送过来的信息
        InputStream inputStream = socket.getInputStream();
        int readLen = 0;
        byte[] bytes = new byte[1024];
        System.out.print("接收到服务端发来的消息：");
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,readLen));
        }

        // 5.关闭资源
        outputStream.close();
        inputStream.close();
        socket.close();

    }
}
