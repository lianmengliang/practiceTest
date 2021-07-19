package com.test.service;

import java.util.HashMap;

/**
 * @Author ： Leo
 * @Date : 2021/7/16 14:18
 * @Desc:
 */
public class ManagerServerConnectClientThread {

    private static HashMap<String,ServerConnectClientThread> threadManager = new HashMap<>();


    /**
     * 根据用户id和线程，加入到Map中
     * @param userId
     * @param thread
     */
    public static void addServerConnectClientThreadToMap(String userId, ServerConnectClientThread thread){

        threadManager.put(userId, thread);

    }

    /**
     * 根据用户id获取服务端连接客户端的 线程
     * @param userId
     * @return
     */
    public static ServerConnectClientThread getServerConnectClientThread(String userId){

        ServerConnectClientThread thread = threadManager.get(userId);

        return thread;
    }
}
