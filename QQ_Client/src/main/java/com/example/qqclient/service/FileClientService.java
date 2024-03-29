package com.example.qqclient.service;

import com.example.common.Message;
import com.example.common.MessageType;
import com.example.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author ： Leo
 * @Date : 2021/7/21 14:25
 * @Desc: 该类/对象完成 文件传送服务
 */
@SuppressWarnings("all")
public class FileClientService {

    /**
     * 离线发送文件的方法
     *
     * @param senderId 发送者
     * @param src      在线（离线）文件的路径
     * @param dest      接收（离线）文件的路径
     * @param getterId 接受者
     * @param type 是否离线  0-离线，1-在线
     */
    public void sendOnlineOrOfflineFileToOne(String senderId, String src, String dest, String getterId,Integer type) {
        //构建message
        Message message = new Message();
        message.setSender(senderId);
        message.setGetter(getterId);
        if (!StringUtils.isEmpty(dest)){
            message.setDest(dest);
        }
        message.setSrc(src);
        if (type == 0) {
            message.setDesc("离线文件");
            message.setMessageType(MessageType.MESSAGE_OFFLINE_FILE);
        }else{
            message.setDesc("在线文件");
            message.setMessageType(MessageType.MESSAGE_FILE);
        }
        //设置发送时间
        message.setSendTime(DateUtil.getCurrentTime(DateUtil.DATE_TIME_FORMAT));
        //读取文件
        File file = new File(src);
        if (!file.isFile()){
            System.out.println("该文件不存在...");
            return;
        }
        byte[] fileBytes = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(fileBytes);
            message.setFileBytes(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("\n" + senderId + "给" + getterId + "发送了"+message.getDesc()+"：'" + src + "'到对方的电脑目录" + dest);
        // 发送文件
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectServerThread.getClientConnectServerThreadByUserId(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
