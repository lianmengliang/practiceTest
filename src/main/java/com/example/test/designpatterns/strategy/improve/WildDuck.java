package com.example.test.designpatterns.strategy.improve;

import com.example.test.designpatterns.strategy.improve.Duck;

/**
 * @Author ： Leo
 * @Date : 2021/4/15 12:10
 * @Desc:
 */
public class WildDuck extends Duck {


    /**
     * 构造器
     */
    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
        quackBehavior = new GaGaQuackBehavior();
    }


    @Override
    public void display() {
// TODO Auto-generated method stub
        System.out.println(" 这是野鸭 ");
    }
}
