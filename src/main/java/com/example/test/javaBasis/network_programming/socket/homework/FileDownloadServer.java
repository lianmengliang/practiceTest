package com.example.test.javaBasis.network_programming.socket.homework;

import com.example.utils.StreamUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 作业3：使用字节流）
 * * * 1.编写一个服务器端,和一个客户端
 * * * 2.客户端可以输入一个音乐文件名，比如 高山流水，服务端 收到音乐名后，可以给客户端返回这个音乐文件，如果服务器没有这个文件，返回一个默认的音乐即可。
 * * * 3.客户端收到文件后，保存到本地 ： E:\\
 * * * 4.该程序可以使用StreamUtils.java
 *
 * @Author ： Leo
 * @Date : 2021/7/8 15:53
 * @Desc: 服务端
 */
@SuppressWarnings({"all"})
public class FileDownloadServer {

    private static String path = "src/";

    public static void main(String[] args) throws Exception {

        // 创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8088);
        System.out.println("服务端已启动，等待被连接...");

        // 获取连接的客户端
        Socket socket = serverSocket.accept();
        // 获取客户端的发送的信息
        InputStream inputStream = socket.getInputStream();
//        String message = StreamUtils.streamToString(inputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String message = reader.readLine();
        System.out.println("获取客户端发送的消息：" + message);



        //判断 客户端发送的内容(判断的前提是得知道自己都有哪些文件)
        File file = new File("src/");
        boolean flag = false;
        String[] list = file.list();
        for (String s : list) {
            if (s.equals(message)) {
                flag = true;
            }
        }

        if (flag) {
            path += message;
        } else {
            path = "src/a.png";
        }

        // 构建发送文件
        FileInputStream fis = new FileInputStream(path);
        byte[] bytes = StreamUtils.streamToByteArray(fis);

        OutputStream outputStream = socket.getOutputStream();

        // 发送文件
        outputStream.write(bytes);
        outputStream.flush();
        socket.shutdownOutput(); // 设置写入数据的结束标志
         System.out.println("已向客户端发送文件：" + path);

        //关闭资源
        outputStream.close();
        fis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();


    }
}
