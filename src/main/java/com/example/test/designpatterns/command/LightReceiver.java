package com.example.test.designpatterns.command;

/**
 * @Author ： Leo
 * @Date : 2021/4/6 17:29
 * @Desc:
 */
public class LightReceiver {
    public void on() {
        System.out.println("电灯打开了...");
    }

    public void off() {
        System.out.println("电灯关闭了...");
    }
}
