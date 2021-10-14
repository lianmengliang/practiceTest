package com.example.test.java_basis.network_programming;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author ： Leo
 * @Date : 2021/7/5 17:49
 * @Desc:
 *
 * 1.编写一个服务器端,和一个客户端
 * 2.服务器端在9999端口监听
 * 3.客户端连接到服务器端，发送"hello, server"，然后退出
 * 4.服务器端接收到客户端发送的信息，输出,并退出
 */
public class inter_demo {
    public static void main(String[] args) throws UnknownHostException {


        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
    }
}
