package com.test.qqclient.service;


import com.test.common.Message;
import com.test.common.MessageType;
import lombok.Data;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Author ： Leo
 * @Date : 2021/7/15 17:46
 * @Desc:
 */
@Data
public class ClientConnectServerThread extends Thread {

    /**
     * 该线程需要持有Socket
     */
    private Socket socket;

    /**
     * 构造器
     *
     * @param socket
     */
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    /**
     * @return
     */
    public Socket getSocket() {
        return this.socket;
    }

    @Override
    public void run() {
        // 因为Thread需要在后台和服务器通信，因此我们需要while循环
        while (true) {
            try {
                System.out.println("客户端线程，等待从读取从服务器端发送的消息...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 如果服务器没有发送Message对象，线程会阻塞在这里
                Message ms = (Message) ois.readObject();
                // 判断这个Message类型，然后做相对应的业务处理
                // 如果读取到的是服务端返回的在线的用户列表
                if (ms.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //取出在线列表信息，并显示
                    // 规定用户id，以英文逗号隔开
                    String content = ms.getContent();
                    String[] userIdArray = content.split(",");
                    System.out.println("=========当前的在线用户列表=========");
                    for (String useId : userIdArray) {
                        System.out.println("用户：" + useId);
                    }
                } else if (ms.getMessageType().equals(MessageType.MESSAGE_COMM_MES)) {
                    System.out.println("\n" + ms.getSender() + "对" + ms.getGetter() + "说" + ms.getContent() + "  " + ms.getSendTime());
                    System.out.println("请输入接收文件的路径(格式:d:\\xx.jpg)");
                } else if (ms.getMessageType().equals(MessageType.MESSAGE_MASS_MESSAGE)) {
                    System.out.println("\n" + ms.getSender() + "的群发消息：" + ms.getContent() + "  " + ms.getSendTime());
                } else if (ms.getMessageType().equals(MessageType.MESSAGE_FILE)) {
                    System.out.println("\n" + ms.getSender() + "给" + ms.getGetter() + "发送了文件" + ms.getSrc() + "到对方的电脑目录" + ms.getDest());
                    //取出ms中文件字节数组，通过字节输出流写到磁盘中
                    FileOutputStream fos = new FileOutputStream(ms.getDest());
                    fos.write(ms.getFileBytes());
                    fos.close();
                    System.out.println("文件保存成功...");
                } else if(ms.getMessageType().equals(MessageType.GET_OFFLINE_MESSAGE)){
                    System.out.println("\n" + ms.getGetter() + "收到："+ms.getSender()+"留言消息：" + ms.getContent() + "  " + ms.getSendTime());
                } else if(ms.getMessageType().equals(MessageType.MESSAGE_OFFLINE_FILE)){
                    System.out.println("\n" + ms.getSender() + "给" + ms.getGetter() + "发送了离线文件" + ms.getSrc() + "到对方的电脑目录" + ms.getDest());
                    //取出ms中文件字节数组，通过字节输出流写到磁盘中
                    FileOutputStream fos = new FileOutputStream(ms.getDest());
                    fos.write(ms.getFileBytes());
                    fos.close();
                    System.out.println("离线文件保存成功...");
                }else {
                    System.out.println("其他类型message，暂时不处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
