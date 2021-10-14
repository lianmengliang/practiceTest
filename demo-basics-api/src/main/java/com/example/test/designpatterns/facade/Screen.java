package com.example.test.designpatterns.facade;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 15:12
 * @Desc:
 */
public class Screen extends TimeSleep{
    private static Screen ourInstance = new Screen();

    public static Screen getInstance() {
        return ourInstance;
    }



    public void up(){
        super.timeSheep();
        System.out.println("屏幕上升中");
    }

    public void down(){
        super.timeSheep();
        System.out.println("屏幕下降中");
    }

    public void pause(){
        super.timeSheep();
        System.out.println("屏幕暂停了");
    }

}
