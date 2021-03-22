package com.example.test.DesignPatterns.simplefactory.order;

import com.example.test.DesignPatterns.simplefactory.pizza.CheesePizza;
import com.example.test.DesignPatterns.simplefactory.pizza.GreekPizza;
import com.example.test.DesignPatterns.simplefactory.pizza.PepperPizza;
import com.example.test.DesignPatterns.simplefactory.pizza.Pizza;

/**
 * @Author ： Leo
 * @Date : 2021/3/18 17:35
 * @Desc:
 */
public class SimplePizzaFactory {

    /**
     * 根据orderType 返回不同类型的pizza
     * @param orderType
     * @return
     */
    public static Pizza createPizza(String orderType) {

        System.out.println("使用简单工厂模式。。。");

        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨 ");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" 奶酪披萨 ");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }
        return pizza;
    }
}
