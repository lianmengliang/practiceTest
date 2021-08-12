package com.example.common;

import java.io.Serializable;
import java.util.Arrays;

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
     * 接收者
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

    /**
     *     //扩展 和 文件相关的成员变量
     */
    private byte[] fileBytes;

    private int fileLen = 0;

    private String dest;

    private String src;
    /**
     * 消息描述
     */
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

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

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", getter='" + getter + '\'' +
                ", content='" + content + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", messageType='" + messageType + '\'' +
                ", fileBytes=" + Arrays.toString(fileBytes) +
                ", fileLen=" + fileLen +
                ", dest='" + dest + '\'' +
                ", src='" + src + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
