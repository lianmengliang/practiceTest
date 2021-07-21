package com.test.common;


import java.io.Serializable;

/**
 * @Author ： Leo
 * @Date : 2021/7/12 18:15
 * @Desc: 表示一個用戶/客户 信息
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String password;
    /**
     * 1： 登录
     * 2： 注册
     */
    private Integer signInOrRegister;

    public Integer getSignInOrRegister() {
        return signInOrRegister;
    }

    public void setSignInOrRegister(Integer signInOrRegister) {
        this.signInOrRegister = signInOrRegister;
    }

    public User(String userId, String password, Integer signInOrRegister) {
        this.userId = userId;
        this.password = password;
        this.signInOrRegister = signInOrRegister;
    }
    public User() {
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
