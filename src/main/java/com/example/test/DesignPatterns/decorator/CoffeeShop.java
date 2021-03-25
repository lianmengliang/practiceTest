package com.example.test.DesignPatterns.decorator;

import cn.hutool.core.util.NumberUtil;

import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 18:08
 * @Desc:
 */
public class CoffeeShop {
    public static void main(String[] args) {

        // 1.先点一份LongBlack
        Drink order = new LongBlack();
        System.out.println("费用1:" + order.cost());
        System.out.println("描述1:" + order.getDes());
        // 2.加入一份牛奶
        order = new Milk(order);

        System.out.println("费用2:" + order.cost());
        System.out.println("描述2:" + order.getDes());
        // 3.加一份巧克力
        order = new Chocolate(order);
        System.out.println("费用3:" + order.cost());
        System.out.println("描述3:" + order.getDes());

        System.out.println("====================");

        Drink order2 = new DeCaf();
        System.out.println("费用1:" + order2.cost());
        System.out.println("描述1:" + order2.getDes());
        order2 = new Milk(order2);
        System.out.println("费用2:" + order2.cost());
        System.out.println("描述2:" + order2.getDes());

        String num = "40.0f";

        int i = NumberUtil.parseInt(num);
        System.out.println(i);


    }
}
