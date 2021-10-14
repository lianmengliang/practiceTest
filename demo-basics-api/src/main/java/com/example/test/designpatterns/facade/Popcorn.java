package com.example.test.designpatterns.facade;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 15:09
 * @Desc:
 */
public class Popcorn extends TimeSleep{
    private static Popcorn ourInstance = new Popcorn();

    public static Popcorn getInstance() {
        return ourInstance;
    }

    public void on(){
        super.timeSheep();
        System.out.println("爆米花机打开了");
    }

    public void off(){
        super.timeSheep();
        System.out.println("爆米花机关闭了");
    }

    public void pop(){
        super.timeSheep();
        System.out.println("正在出爆米花");
    }

}
