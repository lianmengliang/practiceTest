package com.test.qqclient.service;

import java.util.HashMap;

/**
 * @Author ： Leo
 * @Date : 2021/7/15 18:14
 * @Desc: 该类管理客户端连接到服务器端的线程的类
 */
public class ManagerClientConnectServerThread {

    /**
     * 我们把多个线程放入一个HashMap集合中
     * key就是用户id，value就是线程
     */
    private static HashMap<String, ClientConnectServerThread> threadManager = new HashMap<>();


    /**
     * UserId和Thread一块放进Map集合中
     * @param userId
     * @param thread
     */
    public static void addClientConnectServerThreadToMap(String userId, ClientConnectServerThread thread) {
        // 把Userid和线程 放入到集合中
        threadManager.put(userId, thread);
    }


    /**
     * 根据 UserId 取出相对应的线程
     * @param userId
     * @return
     */
    public static ClientConnectServerThread getClientConnectServerThreadByUserId(String userId) {
        // 把Userid和线程 放入到集合中
        ClientConnectServerThread thread = threadManager.get(userId);
        return thread;
    }



}
