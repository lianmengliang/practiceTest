package com.example.common;

/**
 * @Author ： Leo
 * @Date : 2021/7/12 18:23
 * @Desc:
 */
public interface MessageType {
    /*定义一些常量：不同的常量的值，表示不同的消息类型 */
    /**
     * 登录成功
     */
    String MESSAGE_LOGIN_SUCCEED = "1";

    /**
     * 登录失败
     */
    String MESSAGE_LOGIN_FAIL = "2";

    /**
     * 普通的信息包
     */
    String MESSAGE_COMM_MES = "3";
    /**
     * 要求返回在线用户列表
     */
    String MESSAGE_GET_ONLINE_FRIEND = "4";
    /**
     * // 返回在线用户列表
     */
    String MESSAGE_RET_ONLINE_FRIEND = "5";
    /**
     * // 客户端请求退出
     */
    String MESSAGE_CLIENT_EXIT = "6";

    /**
     * 群发消息
     */
    String MESSAGE_MASS_MESSAGE = "7";

    /**
     * 注册成功
     */
    String MESSAGE_REGISTER_SUCCEED = "8";
    /**
     * 注册失败
     */
    String MESSAGE_REGISTER_FAIL = "9";

    /**
     * 发送文件
     */
    String MESSAGE_FILE = "10";
    /**
     * 服务器推送新闻/消息
     */
    String MESSAGE_NEWS_MSG = "11";
    /**
     * 离线留言消息
     */
    String MESSAGE_OFFLINE_MSG = "12";

    /**
     * 离线发送文件
     */
    String MESSAGE_OFFLINE_FILE = "13";
    /**
     * 获取离线消息/文件
     */
    String GET_OFFLINE_MESSAGE = "14";
    /**
     * 统一返回失败的信息
     */
    String MESSAGE_WRONG_MSG = "15";
    /**
     * 向客户端获取文件下载的地址
     */
    String MESSAGE_GET_PATH = "16";
}
