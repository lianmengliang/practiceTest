package com.example.test.designpatterns.strategy.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/15 15:33
 * @Desc:
 */
public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞翔技术非常好。。");
    }
}
