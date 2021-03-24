package com.example.test.DesignPatterns.bridge;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 15:46
 * @Desc:
 */
public class XiaoMi implements Brand {
    @Override
    public void open() {
        System.out.println(" 小米 手机开机");
    }

    @Override
    public void close() {
        System.out.println(" 小米 手机关机");
    }

    @Override
    public void call() {
        System.out.println(" 小米 手机打电话");
    }
}
