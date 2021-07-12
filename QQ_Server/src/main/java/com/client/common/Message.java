package com.client.common;

import java.io.Serializable;

/**
 * @Author ： Leo
 * @Date : 2021/7/12 18:19
 * @Desc: 表示客户端和服务端通信时的信息对象
 */
public class Message implements Serializable {

    /**
     * 发送方
     */
    private String sender;

    /**
     * 接受者
     */
    private String getter;

    /**
     * 发送内容
     */
    private String content;
    /**
     * 发送时间
     */
    private String sendTime;

    /**
     * 消息类型： 可以在接口中定义消息类型
     */
    private String messageType;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
