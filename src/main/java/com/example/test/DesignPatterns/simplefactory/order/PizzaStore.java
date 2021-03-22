package com.example.test.DesignPatterns.simplefactory.order;

/**
 * @Author ： Leo
 * @Date : 2021/3/18 17:14
 * @Desc: 相当于一个客户端
 */
public class PizzaStore {

    public static void main(String[] args) {
//            new OrderPizza();

        /*new OrderPizza(new SimplePizzaFactory());
        System.out.println("退出程序。。。over");*/
        new OrderPizza2();

    }
}
