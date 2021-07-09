package com.example.test.javaBasis.network_programming.socket.homework;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**作业1：
 * 1.编写一个接收端A,和一个发送端B
 * 2.接收端A在8888端口等待接收数据(receive)
 * 3.发送端B向接收端A发送数据“四大名著是哪些"
 * 4.接收端A接收到发送端B发送的数据，回复“四大名著是《红楼梦》，《水浒传》《西游记》《三国演义》".否则返回 what ?
 * 5.发送端接收回复的数据，再退出
 * @Author ： Leo
 * @Date : 2021/7/7 11:59
 * @Desc:
 */
public class HomeworkSendB {
    public static void main(String[] args) throws IOException {
        // 构建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(8886);

        //获取回复消息
        System.out.println("请输入要发送的问题：");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        // 构建包DatagramPacket对象
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getByName("192.168.10.104"), 8888);

        // 给A端发送消息
        socket.send(packet);


        //接收A端的回复消息
        byte[] bytes = new byte[1024];
        packet = new DatagramPacket(bytes,bytes.length);

        //接收
        socket.receive(packet);

        byte[] data = packet.getData();
        int length = packet.getLength();

        System.out.println("接收到A端的回复消息：" + new String(data,0,length));


        //关闭资源
        socket.close();
        System.out.println("B端退出...");
    }
}









/*//1.创建对象
        DatagramSocket socket = new DatagramSocket(9998);

        //2.需要发送的数据，封装到DatagramPacket对象中
        byte[] data = "hello，明天吃火锅".getBytes();
        DatagramPacket packet = new DatagramPacket(data,data.length, InetAddress.getByName("192.168.10.104"),9999);
        socket.send(packet);

        //========接收回信
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf,buf.length);

        socket.receive(packet);
        data = packet.getData();
        int length = packet.getLength();
        String s = new String(data,0,length);
        System.out.println("来自A端的回复信息：‘"+s+"’");


        //关闭资源
        socket.close();
        System.out.println("B端退出...");*/