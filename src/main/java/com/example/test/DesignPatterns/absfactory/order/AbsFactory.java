package com.example.test.DesignPatterns.absfactory.order;


import com.example.test.DesignPatterns.absfactory.pizza.Pizza2;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 11:37
 * @Desc: 一个抽象的工厂模式的抽象层（接口）
 */
public interface AbsFactory {

    Pizza2 createPizza(String orderType);
}
