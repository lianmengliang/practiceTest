package com.example.test.designpatterns.factorymethod.order;

import com.example.test.designpatterns.factorymethod.pizza.LDCheesePizza;

import com.example.test.designpatterns.factorymethod.pizza.LDPepperPizza;
import com.example.test.designpatterns.factorymethod.pizza.Pizza2;

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
