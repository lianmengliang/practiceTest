package com.example.service;

import java.util.HashMap;

/**
 * @Author ： Leo
 * @Date : 2021/7/16 14:18
 * @Desc:
 */
public class ManagerServerConnectClientThread {

    private static HashMap<String, ServerConnectClientThread> threadManager = new HashMap<>();


    /**
     * 根据用户id和线程，加入到Map中
     *
     * @param userId
     * @param thread
     */
    public static void addServerConnectClientThreadToMap(String userId, ServerConnectClientThread thread) {
        threadManager.put(userId, thread);
    }

    /**
     * 根据用户id获取服务端连接客户端的 线程
     *
     * @param userId
     * @return
     */
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        ServerConnectClientThread thread = threadManager.get(userId);
        return thread;
    }


    /**
     * 获取在线的用户列表
     *
     * @return
     */
    public static String getOnlineUser() {
        StringBuilder builder = new StringBuilder("");
        /*//采用iterator遍历Map*/
      /*  Iterator<String> iterator = threadManager.keySet().iterator();
        while(iterator.hasNext()){
            builder.append(iterator.next()).append(",");
        }*/
        // 这种方法，造成多拼接一个 ,但是分割的时候后面的就消除了,所以对结果无影响
        for (String userId : threadManager.keySet()) {
            builder.append(userId).append(",");
        }
        return builder.toString();
    }

    /**
     * 从集合中移除某个线程对象
     *
     * @param userId
     */
    public static void removeClientConnectServerThread(String userId) {
        threadManager.remove(userId);
    }
}
