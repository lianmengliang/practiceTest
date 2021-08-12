package com.example.test.designpatterns.strategy.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/15 16:37
 * @Desc:
 */
public class PekingDuck extends Duck {

    /**
     * 构造器
     */
    public PekingDuck() {
        flyBehavior = new BadFlyBehavior();
        quackBehavior = new GeGeQuackBehavior();
    }

    @Override
    public void display() {
// TODO Auto-generated method stub
        System.out.println("~~北京鸭~~~");
    }
}
