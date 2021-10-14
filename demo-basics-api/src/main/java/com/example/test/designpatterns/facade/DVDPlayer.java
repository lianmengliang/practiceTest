package com.example.test.designpatterns.facade;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 15:06
 * @Desc:
 */
public class DVDPlayer extends TimeSleep{
    //使用单例模式
    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance(){
        return instance;
    }

    public void on(){
        super.timeSheep();
        System.out.println("DVD打开了");
    }

    public void off(){
        super.timeSheep();
        System.out.println("DVD关闭了");
    }

    public void pause(){
        super.timeSheep();
        System.out.println("DVD暂停了");
    }

    public void play(){
        super.timeSheep();
        System.out.println("DVD正在播放中");
    }
}
