package com.example.test.designpatterns.strategy.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/15 16:38
 * @Desc:
 */
public class ToyDuck extends Duck {

    public ToyDuck() {
        flyBehavior = new NoFlyBehavior();
        quackBehavior = new NoQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("这是玩具鸭");
    }
}
