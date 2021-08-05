package com.example.tcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author ： leo
 * @Date :2020/5/19 15:59
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("F:\\1.pdf");

        //1.创建一个客户端对象 Socket,构造方法绑定服务器的 IP 地址和 端口号
        Socket socket = new Socket("127.0.0.1", 8888);

        //2.使用Socket对象中的方法getOutputStream()获取网络字节 输出流 OutputStream 对象
        OutputStream os = socket.getOutputStream();

        int len = 0 ;
        byte[] bytes = new byte[1024];
        while((len = fis.read(bytes))!=1){
            os.write(bytes,0,len);
        }

        InputStream is = socket.getInputStream();

        while((len = is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        //6.释放资源(Socket)
        fis.close();
        socket.close();

    }
}
