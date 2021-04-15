package com.example.test.designpatterns.facade;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 15:11
 * @Desc:
 */
public class Projector {
    private static Projector ourInstance = new Projector();

    public static Projector getInstance() {
        return ourInstance;
    }

    public void on(){
        System.out.println("投影仪打开了");
    }

    public void off(){
        System.out.println("投影仪关闭了");
    }

    public void focus(){
        System.out.println("投影仪正在聚焦");
    }
}
