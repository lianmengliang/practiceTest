package com.example.test.javaBasis.network_programming.api;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author ： Leo
 * @Date : 2021/7/5 18:27
 * @Desc:
 */
public class API_Demo {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress localHost = InetAddress.getLocalHost();
        // DESKTOP-UQOUO2U/192.168.10.97
        System.out.println("本机ip：" + localHost);
        System.out.println("本机ip地址：" + localHost.getHostAddress());

        InetAddress host1 = InetAddress.getByName("DESKTOP-UQOUO2U");
        System.out.println("主机名：" + host1.getHostName());

        //根据域名返回InetAddress对象
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        // www.baidu.com/36.152.44.96
        System.out.println("根据域名获取的IP地址：host2=" + host2);


        //通过InetAddress对象 获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println("host2 =" + hostAddress);

        // 通过InetAddress对象，获取对应的主机名/域名
        String hostName = host2.getHostName();
        System.out.println("获取的主机名/域名: " + hostName);


        testFile();
    }

    /**
     *
     */
    public static void testFile(){
        //判断 客户端发送的内容(判断的前提是得知道自己都有哪些文件)
        File file = new File("g:\\8.jpg");
        if (file.isFile()){
            System.out.println("文件存在");
        }else{
            System.out.println("文件不存在");

        }
       /* String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }*/
    }
}
