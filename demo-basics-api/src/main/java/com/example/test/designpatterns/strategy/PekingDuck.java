package com.example.test.designpatterns.strategy;

/**
 * @Author ： Leo
 * @Date : 2021/4/15 12:09
 * @Desc:
 */
public class PekingDuck extends Duck {
    @Override
    public void display() {
// TODO Auto-generated method stub
        System.out.println("~~北京鸭~~~");
    }

    //因为北京鸭不能飞翔，因此需要重写 fly @Override
    @Override
    public void fly() {
// TODO Auto-generated method stub
        System.out.println("北京鸭不能飞翔");
    }
}
