package com.test.qqclient.service;

import com.test.common.Message;
import com.test.common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @Author ： Leo
 * @Date : 2021/7/20 16:43
 * @Desc: 用于提供和消息相关的服务
 */
public class MessageClientService {

    /**
     *  私聊发送消息的方法
     * @param senderId    发送者
     * @param content   发送内容
     * @param getterId  接受者
     */
    public void sendMessageToOne(String senderId,String content,String getterId){
        Message ms = new Message();
        ms.setSender(senderId);
        ms.setGetter(getterId);
        ms.setContent(content);
        // 普通的聊天消息
        ms.setMessageType(MessageType.MESSAGE_COMM_MES);
        // 发送时间
        ms.setSendTime(new Date().toString());
        System.out.println(senderId+"对"+getterId+"说：“"+content+"”。");

        // 发送消息
        try {
            // 构建对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectServerThread.getClientConnectServerThreadByUserId(senderId).getSocket().getOutputStream());
            oos.writeObject(ms);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     * @param senderId 发送者
     * @param content   群发内容
     */
    public void sendMessageToAll(String senderId,String content){
        // 构建发送消息
        Message ms = new Message();
        ms.setSender(senderId);
        ms.setContent(content);
        ms.setMessageType(MessageType.MESSAGE_MASS_MESSAGE);
        ms.setSendTime(new Date().toString());
        System.out.println(senderId+"的群发消息："+content);

        try {
            // 向服务端发送消息
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectServerThread.getClientConnectServerThreadByUserId(senderId).getSocket().getOutputStream());
            oos.writeObject(ms);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
