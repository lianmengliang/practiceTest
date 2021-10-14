package com.example.test.designpatterns.facade;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 15:11
 * @Desc:
 */
public class Projector extends TimeSleep{
    private static Projector ourInstance = new Projector();

    public static Projector getInstance() {
        return ourInstance;
    }

    public void on(){
        super.timeSheep();
        System.out.println("投影仪打开了");
    }

    public void off(){
        super.timeSheep();
        System.out.println("投影仪关闭了");
    }

    public void focus(){
        super.timeSheep();
        System.out.println("投影仪正在聚焦");
    }
}
