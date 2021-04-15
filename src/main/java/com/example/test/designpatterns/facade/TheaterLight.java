package com.example.test.designpatterns.facade;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 15:17
 * @Desc:
 */
public class TheaterLight {
    private static TheaterLight ourInstance = new TheaterLight();

    public static TheaterLight getInstance() {
        return ourInstance;
    }

    public void on() {
        System.out.println("打开灯光");
    }

    public void off() {
        System.out.println("关闭灯光");
    }

    public void bright() {
        System.out.println("灯光调亮了");
    }

    public void dim() {
        System.out.println("灯光调暗了");
    }
}
