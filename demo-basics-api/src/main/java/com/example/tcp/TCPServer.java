package com.example.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author ： leo
 * @Date :2020/5/19 16:08
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {



        ServerSocket server = new ServerSocket(8888);

        Socket socket = server.accept();

        InputStream is = socket.getInputStream();

        File file = new File("F:\\upload");

        if (!file.exists()){
            file.mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(file + "\\1.pdf");

        int len = 0 ;

        byte[] bytes = new byte[1024];

        while ((len = is.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }

        socket.getOutputStream().write("上传成功".getBytes());
        socket.shutdownOutput();

        fos.close();

        socket.close();

        server.close();
    }
}
