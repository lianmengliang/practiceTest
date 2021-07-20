package com.test.common;

/**
 * @Author ： Leo
 * @Date : 2021/7/12 18:23
 * @Desc:
 */
public interface MessageType {
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
     *  返回在线用户列表
     */
    String MESSAGE_RET_ONLINE_FRIEND = "5";
    /**
     * 客户端请求退出
     */
    String MESSAGE_CLIENT_EXIT = "6";

    /**
     * 群发消息
     */
    String MESSAGE_MASS_MESSAGE = "7";


}
