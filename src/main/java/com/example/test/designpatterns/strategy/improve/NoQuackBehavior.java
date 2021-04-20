package com.example.test.designpatterns.strategy.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/15 17:32
 * @Desc:
 */
public class NoQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫、、、");
    }
}
