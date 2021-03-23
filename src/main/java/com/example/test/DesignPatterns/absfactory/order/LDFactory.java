package com.example.test.DesignPatterns.absfactory.order;



import com.example.test.DesignPatterns.absfactory.pizza.LDCheesePizza;
import com.example.test.DesignPatterns.absfactory.pizza.Pizza2;


/**
 * @Author ： Leo
 * @Date : 2021/3/22 11:38
 * @Desc: 伦敦工厂
 */
public class LDFactory implements AbsFactory {
    @Override
    public Pizza2 createPizza(String orderType) {
        Pizza2 pizza2 =null ;
        if (orderType.equals("cheese")) {
            pizza2 = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza2 = new LDCheesePizza();
        }

        return pizza2;
    }
}
