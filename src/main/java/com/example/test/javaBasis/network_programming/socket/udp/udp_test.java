package com.example.test.javaBasis.network_programming.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author ： Leo
 * @Date : 2021/7/8 11:28
 * @Desc:
 */
public class udp_test {
    public static void main(String[] args) throws IOException {

        // 监听9996端口
        DatagramSocket socket = new DatagramSocket(9996);

        //准备发送数据

        byte[] bytes = "大家好，我们一起吃火锅呀！".getBytes();

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.10.104"), 9999);

        // 发送消息
        socket.send(packet);


        //接收消息
        bytes = new byte[1024];
        packet = new DatagramPacket(bytes,bytes.length);
        socket.receive(packet);

        byte[] data = packet.getData();
        int length = packet.getLength();

        System.out.println(new String(data,0,length));



           // 关闭资源
        socket.close();
        System.out.println("练习端退出...");


    }
}
