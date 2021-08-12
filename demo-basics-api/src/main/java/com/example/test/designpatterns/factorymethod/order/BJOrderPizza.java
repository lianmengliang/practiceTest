package com.example.test.designpatterns.factorymethod.order;

import com.example.test.designpatterns.factorymethod.pizza.BJCheesePizza;

import com.example.test.designpatterns.factorymethod.pizza.BJPepperPizza;
import com.example.test.designpatterns.factorymethod.pizza.Pizza2;


/**
 * @Author ： Leo
 * @Date : 2021/3/19 11:18
 * @Desc:
 */
public class BJOrderPizza extends OrderPizzaDevice {


    @Override
    Pizza2 createPizza(String orderType) {
        Pizza2 pizza2 = null;
        if (orderType.equals("cheese")) {
            pizza2 = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza2 = new BJPepperPizza();
        }

        return pizza2;
    }
}
