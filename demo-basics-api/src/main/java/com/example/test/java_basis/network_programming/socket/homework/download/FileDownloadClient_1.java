package com.example.test.java_basis.network_programming.socket.homework.download;

import com.example.utils.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author ： Leo
 * @Date : 2021/7/8 15:53
 * @Desc:
 * 使用BufferedWriter 和 BufferedReader
 */
@SuppressWarnings({"all"})
public class FileDownloadClient_1 {
    public static void main(String[] args) throws Exception {

        // 构建Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),8086);

        // 获取发送信息
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("请输入要下载的文件名：");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        // 向服务端发送内容
        // 这里使用newLine()和 socket.shutdownOutput()，效果都是一样，都是结束的标志
        outputStream.write(message.getBytes());
        socket.shutdownOutput();//设置写入结束标记

        // 获取服务端回复的内容
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        String filePath = "E:\\" + message ;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));

        bos.write(bytes);
        bos.flush();

        //关闭资源
        bos.close();

        bis.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端下载完毕，退出...");


    }
}
