package com.example.test.designpatterns.strategy;

/**
 * @Author ： Leo
 * @Date : 2021/4/15 12:09
 * @Desc:
 */
public class ToyDuck extends Duck {
    @Override
    public void display() {
// TODO Auto-generated method stub
        System.out.println("玩具鸭");

    }

    //需要重写父类的所有方法
    @Override
    public void quack() {
        System.out.println("玩具鸭不能叫~~");
    }

    @Override
    public void swim() {
        System.out.println("玩具鸭不会游泳~~");
    }

    @Override
    public void fly() {
        System.out.println("玩具鸭不会飞翔~~~");
    }
}
