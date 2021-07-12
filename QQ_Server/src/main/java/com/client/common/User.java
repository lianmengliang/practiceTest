package com.client.common;


import java.io.Serializable;

/**
 * @Author ： Leo
 * @Date : 2021/7/12 18:15
 * @Desc: 表示一個用戶/客户 信息
 */
public class User implements Serializable {

    private String userId;

    private String passwoed;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswoed() {
        return passwoed;
    }

    public void setPasswoed(String passwoed) {
        this.passwoed = passwoed;
    }
}
