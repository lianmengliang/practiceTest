package com.example.test.designpatterns.strategy.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:45
 * @Desc: 用于主方法测试
 */
public class Client {
    public static void main(String[] args) {

        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();
        wildDuck.quack();


        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.fly();
        pekingDuck.quack();

        pekingDuck.setFlyBehavior(new GoodFlyBehavior());

        pekingDuck.fly();
    }
}
