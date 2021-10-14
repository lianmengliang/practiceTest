package com.example.test.java_basis.network_programming.socket.homework;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author ： Leo
 * @Date : 2021/7/7 11:58
 * @Desc:
 */
public class HomeworkReceiverA {
    public static void main(String[] args) throws IOException {
        // 构建一个DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(8888);

        //构建一个包
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        //接收到B端的消息
        socket.receive(packet);

        byte[] data = packet.getData();
        int length = packet.getLength();
        String message = new String(data, 0, length);
        System.out.println("接收到B端发送的消息：" + message);

        //回复的信息
        String answer = "";
        if (message.equals("四大名著是哪些")){
            answer = "四大名著是《红楼梦》,《水浒传》,《西游记》,《三国演义》";
        }else{
            answer = "What ?";
        }

        //发送消息
        //构建包packet

        packet = new DatagramPacket(answer.getBytes(),answer.getBytes().length,InetAddress.getByName("192.168.10.104"),8886);
        socket.send(packet);


        // 关闭资源
        socket.close();
        System.out.println("A端退出...");


    }
}

















/*//1.创建一个DatagramSocket对象，准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        // 2.构建一个DatagramPacket对象，准备接收数据
        // 细节：UDP协议中，一个数据包最大64K
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        // 3.调用 接收方法 ，将通过网络传输的DatagramPacket对象
        // 填充packet对象
        // 当有数据包发送到 本机的9999端口时，就会接收数据
        // 如果没有数据包 发送到本机的9999端口，就会阻塞等待
        System.out.println("接收端A等待接收数据...");
        socket.receive(packet);

        //4.可以把packet进行拆包，取出数据，并显示
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println("来自B端的信息：‘" + s + "’");


        // 回复给B端========
//        socket.send(packet);

        data = "好的，明天见".getBytes();
        packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.10.104"), 9998);
        socket.send(packet);


        // 关闭资源
        socket.close();
        System.out.println("A端退出...");*/