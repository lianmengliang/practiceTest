package com.example.test.javaBasis.network_programming.socket.tcp.upload;

import com.example.utils.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author ： Leo
 * @Date : 2021/7/6 15:34
 * @Desc: 文件上传 1.0
 * 服务端：
 */
@SuppressWarnings({"all"})
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在监听8888端口...");

        //等待客户端的连接
        Socket socket = serverSocket.accept();

        // 读取客户端发送的数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        // 把文件转到byte[]数组中
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        String path = "src/abc.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        // 把文件写入到指定路径下
        bos.write(bytes);
        System.out.println("收到客户端上传的文件，并且把文件存储到指定的路径下...");
        bos.close();

        /*  使用下面方式 ：读取 客户端传来的文件，并写入指定路径   也是可行的
        String path = "src/a.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        int readLen  =0 ;
        byte[] bytes1 = new byte[1024];
        while ((readLen = bis.read(bytes1))!=-1){
            bos.write(bytes1,0,readLen);
        }
        bos.close();*/

        // 向客户端回复：“收到图片”
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("收到图片");
        // 这里使用newLine()和 socket.shutdownOutput()，效果都是一样，都是结束的标志
        writer.newLine();
        writer.flush();
//        socket.shutdownOutput();//设置写入结束标记


        // 关闭资源
        bis.close();
        socket.close();
        serverSocket.close();
        System.out.println("退出服务端...");


    }
}
