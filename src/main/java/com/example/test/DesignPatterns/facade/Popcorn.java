package com.example.test.DesignPatterns.facade;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 15:09
 * @Desc:
 */
public class Popcorn {
    private static Popcorn ourInstance = new Popcorn();

    public static Popcorn getInstance() {
        return ourInstance;
    }

    public void on(){
        System.out.println("爆米花机打开了");
    }

    public void off(){
        System.out.println("爆米花机关闭了");
    }

    public void pop(){
        System.out.println("正在出爆米花");
    }
}
