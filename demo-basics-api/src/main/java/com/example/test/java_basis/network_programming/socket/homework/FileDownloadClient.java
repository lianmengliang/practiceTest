package com.example.test.java_basis.network_programming.socket.homework;

import com.example.utils.StreamUtils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author ： Leo
 * @Date : 2021/7/8 15:53
 * @Desc:
 */
@SuppressWarnings({"all"})
public class FileDownloadClient {
    public static void main(String[] args) throws Exception {

        // 构建Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),8088);

        // 获取发送信息
        OutputStream outputStream = socket.getOutputStream();

        System.out.println("请输入要下载的文件名：");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        // 向服务端发送内容
        outputStream.write(message.getBytes());
        outputStream.flush();
        socket.shutdownOutput();//设置写入结束标记


        // 获取服务端回复的内容
        InputStream inputStream = socket.getInputStream();

        byte[] bytes = StreamUtils.streamToByteArray(inputStream);

        String filePath = "E:\\" + message ;
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(bytes);
        fos.flush();

        //关闭资源
        fos.close();
        inputStream.close();

        outputStream.close();
        socket.close();


    }
}
