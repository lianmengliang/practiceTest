package com.example.test.DesignPatterns.visitor;

/**
 * @Author ： Leo
 * @Date : 2021/4/7 17:53
 * @Desc:
 */
public class Man extends Person{
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
