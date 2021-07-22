package com.test.qqclient.service;

import com.example.utils.DateUtil;
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
     * 私聊发送消息的方法
     *
     * @param senderId 发送者
     * @param content  发送内容
     * @param getterId 接受者
     */
    public void sendMessageToOne(String senderId, String content, String getterId) {
        Message ms = new Message();
        ms.setSender(senderId);
        ms.setGetter(getterId);
        ms.setContent(content);
        // 普通的聊天消息
        ms.setMessageType(MessageType.MESSAGE_COMM_MES);
        // 发送时间
        ms.setSendTime(DateUtil.getCurrentTime(DateUtil.DATE_TIME_FORMAT));
        System.out.println(senderId + "对" + getterId + "说：“" + content + "”。");

        this.sendMessage(senderId,ms);
    }

    /**
     * 群发消息
     *
     * @param senderId 发送者
     * @param content  群发内容
     */
    public void sendMessageToAll(String senderId, String content) {
        // 构建发送消息
        Message ms = new Message();
        ms.setSender(senderId);
        ms.setContent(content);
        ms.setMessageType(MessageType.MESSAGE_MASS_MESSAGE);
        ms.setSendTime(DateUtil.getCurrentTime(DateUtil.DATE_TIME_FORMAT));
        System.out.println(senderId + "的群发消息：" + content);

        this.sendMessage(senderId,ms);

    }

    /**
     * 获取 离线消息
     * @param userId
     */
    public void getOfflineMessage(String userId){
        Message ms = new Message();
        ms.setSender(userId);
        ms.setMessageType(MessageType.GET_OFFLINE_MESSAGE);
        ms.setSendTime(DateUtil.getCurrentTime(DateUtil.DATE_TIME_FORMAT));
        //主动获取离线消息
        System.out.println(userId+"请求获取离线消息...");
        this.sendMessage(userId,ms);
    }

    /**
     * 离线发送消息的方法
     *
     * @param senderId 发送者
     * @param content  离线留言
     * @param getterId 接受者
     */
    public void sendOfflineMessageToOne(String senderId, String content, String getterId) {
        Message ms = new Message();
        ms.setSender(senderId);
        ms.setContent(content);
        ms.setGetter(getterId);
        ms.setMessageType(MessageType.MESSAGE_OFFLINE_MSG);
        ms.setSendTime(DateUtil.getCurrentTime(DateUtil.DATE_TIME_FORMAT));
        System.out.println(senderId + "对" + getterId + "离线留言消息：" + content);
        this.sendMessage(senderId,ms);
    }


    /**
     * 发送消息
     */
    public void sendMessage(String userId,Message ms){
        try {
            // 向服务端发送消息
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectServerThread.getClientConnectServerThreadByUserId(userId).getSocket().getOutputStream());
            oos.writeObject(ms);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
