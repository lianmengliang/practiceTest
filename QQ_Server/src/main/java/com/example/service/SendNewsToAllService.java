package com.example.service;

import com.example.common.Message;
import com.example.common.MessageType;

import com.example.utils.DateUtil;
import com.example.utils.InputControlUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author ： Leo
 * @Date : 2021/7/21 18:04
 * @Desc:
 */
public class SendNewsToAllService implements Runnable {


    @Override
    public void run() {
        // 为了多次推送消息
        while (true) {
            System.out.println("请输入要推送的新闻/消息[输入exit标识退出推送服务]：");
            String news = InputControlUtil.readString(100);
            if ("exit".equals(news)) {
                break;
            }
            //构建一个消息，群发消息
            Message ms = new Message();
            ms.setSendTime(DateUtil.getCurrentTime(DateUtil.DATE_TIME_FORMAT));
            ms.setContent(news);
            ms.setSender("服务器");
            ms.setMessageType(MessageType.MESSAGE_MASS_MESSAGE);
            System.out.println("推送的消息：" + news);

            String[] userIds = ManagerServerConnectClientThread.getOnlineUser().split(",");

            for (String userId : userIds) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(ManagerServerConnectClientThread.getServerConnectClientThread(userId).getSocket().getOutputStream());
                    if (!StringUtils.isEmpty(userId)) {
                        ms.setGetter(userId);
                    }
                    oos.writeObject(ms);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
