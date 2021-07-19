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
