package com.example.test.DesignPatterns.absfactory.order;


import com.example.test.DesignPatterns.absfactory.pizza.BJCheesePizza;
import com.example.test.DesignPatterns.absfactory.pizza.LDCheesePizza;
import com.example.test.DesignPatterns.absfactory.pizza.LDPepperPizza;
import com.example.test.DesignPatterns.absfactory.pizza.Pizza2;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 11:38
 * @Desc: 北京工厂
 */
public class BJFactory implements AbsFactory {
    @Override
    public Pizza2 createPizza(String orderType) {
        Pizza2 pizza2 =null ;
        if (orderType.equals("cheese")) {
            pizza2 = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza2 = new BJCheesePizza();
        }
        return pizza2;
    }
}
