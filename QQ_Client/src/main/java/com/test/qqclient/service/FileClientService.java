package com.test.qqclient.service;

import com.example.utils.DateUtil;
import com.test.common.Message;
import com.test.common.MessageType;

import java.io.*;

/**
 * @Author ： Leo
 * @Date : 2021/7/21 14:25
 * @Desc: 该类/对象完成 文件传送服务
 */
public class FileClientService {

    /**
     * 读取src文件 --> message
     *
     * @param src   原路径文件
     * @param dest  源文件输出到哪个目录
     * @param senderId  发送者
     * @param getterId  接收者
     */
    public void sendFileToOne(String src, String dest, String senderId, String getterId) {

        //构建message
        Message message = new Message();
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setDest(dest);
        message.setSrc(src);
        message.setMessageType(MessageType.MESSAGE_FILE);
        //设置发送时间
        message.setSendTime(DateUtil.getCurrentTime(DateUtil.DATE_TIME_FORMAT));
        //读取文件
        File file = new File(src);

        byte[] fileBytes = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(fileBytes);
            message.setFileBytes(fileBytes);
//            message.setFileLen((int) file.length());
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
        System.out.println("\n" + senderId + "给" + getterId + "发送了文件" + src + "到对方的电脑目录" + dest);
        // 发送文件
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManagerClientConnectServerThread.getClientConnectServerThreadByUserId(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
