package com.example.test.DesignPatterns.facade;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 15:12
 * @Desc:
 */
public class Screen {
    private static Screen ourInstance = new Screen();

    public static Screen getInstance() {
        return ourInstance;
    }



    public void up(){
        System.out.println("屏幕上升中");
    }

    public void down(){
        System.out.println("屏幕下降中");
    }

    public void pause(){
        System.out.println("屏幕暂停了");
    }

}
