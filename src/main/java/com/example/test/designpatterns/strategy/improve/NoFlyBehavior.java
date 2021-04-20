package com.example.test.designpatterns.strategy.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/15 15:32
 * @Desc:
 */
public class 1NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞。。。");
    }
}
