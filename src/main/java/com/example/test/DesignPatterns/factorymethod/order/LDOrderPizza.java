package com.example.test.DesignPatterns.factorymethod.order;

import com.example.test.DesignPatterns.factorymethod.pizza.LDCheesePizza;

import com.example.test.DesignPatterns.factorymethod.pizza.LDPepperPizza;
import com.example.test.DesignPatterns.factorymethod.pizza.Pizza2;

/**
 * @Author ： Leo
 * @Date : 2021/3/19 11:24
 * @Desc:
 */
public class LDOrderPizza extends OrderPizzaDevice {
    @Override
    Pizza2 createPizza(String orderType) {
        Pizza2 pizza2 =null ;
        if (orderType.equals("cheese")) {
            pizza2 = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza2 = new LDPepperPizza();
        }

        return pizza2;
    }
}
