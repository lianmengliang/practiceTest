package com.example.test.designpatterns.strategy;

/**
 * @Author ： Leo
 * @Date : 2021/4/15 12:08
 * @Desc:
 */
public abstract class Duck {

    public Duck() {

    }

    public abstract void display();//显示鸭子信息

    public void quack() {
        System.out.println("鸭子嘎嘎叫~~");
    }

    ;

    public void swim() {
        System.out.println("鸭子会游泳~~");
    }

    public void fly() {
        System.out.println("鸭子会飞翔~~~");
    }

}
