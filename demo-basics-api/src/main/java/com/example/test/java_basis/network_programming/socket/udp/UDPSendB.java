package com.example.test.java_basis.network_programming.socket.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**作业1：
 * 1.编写一个接收端A,和一个发送端B
 * 2.接收端A在9999端口等待接收数据(receive)
 * 3.发送端B向接收端A发送数据“hello,明天吃火锅~"
 * 4.接收端A接收到发送端B发送的数据，回复“好的,明天见".再退出5.发送端接收回复的数据，再退出
 * @Author ： Leo
 * @Date : 2021/7/7 11:59
 * @Desc:
 */
public class UDPSendB {
    public static void main(String[] args) throws IOException {
        //1.创建对象
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
        System.out.println("B端退出...");
    }
}
