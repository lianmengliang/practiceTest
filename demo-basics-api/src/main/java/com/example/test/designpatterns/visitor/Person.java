package com.example.test.designpatterns.visitor;

/**
 * @Author ： Leo
 * @Date : 2021/4/7 17:56
 * @Desc:
 */
public abstract class Person {

    // 提供一个方法，让访问者可以访问
    public abstract void accept(Action action);
}
