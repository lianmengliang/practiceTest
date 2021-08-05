package com.example.test.designpatterns.facade;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 15:14
 * @Desc:
 */
public class Stereo {
    private static Stereo ourInstance = new Stereo();

    public static Stereo getInstance() {
        return ourInstance;
    }

    public void on(){
        System.out.println("打开立体声");
    }

    public void off(){
        System.out.println("关闭立体声");
    }

    public void up(){
        System.out.println("调大立体声");
    }

    public void down(){
        System.out.println("调小立体声");
    }
}
