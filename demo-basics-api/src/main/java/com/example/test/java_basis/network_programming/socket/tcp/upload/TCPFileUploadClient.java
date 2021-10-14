package com.example.test.java_basis.network_programming.socket.tcp.upload;

import com.example.utils.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author ： Leo
 * @Date : 2021/7/6 15:34
 * @Desc: 客户端
 */
@SuppressWarnings({"all"})
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客端Socket：" + socket.getClass());

        // 本地文件路径
        String sourcePath = "G:\\testIO\\6.jpg";

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
        // 把文件转到byte[]数组中
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //通过 socket 获取到输出流, 将 bytes 数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        // 将文件对应的字节数组的内容，写入到数据通道
        bos.write(bytes);
        bis.close();
        socket.shutdownOutput(); // 设置写入数据的结束标志

       /* 使用下面方法，会报错 Exception in thread "main" java.net.SocketException: Socket is closed
       BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        int readLen = 0;
        byte[] bytes = new byte[1024];
        while ((readLen = bis.read(bytes)) != -1) {
            bos.write(bytes,0,readLen);
        }
        bis.close();
        socket.shutdownOutput();*/

        // 接收服务端回复的信息
        InputStream inputStream = socket.getInputStream();
        String stream = StreamUtils.streamToString(inputStream);
        System.out.println("接收到服务端回复的信息：" + stream);

        // 关闭资源
        inputStream.close();
        bos.close();
        socket.close();
        System.out.println("退出客户端...");


    }
}
