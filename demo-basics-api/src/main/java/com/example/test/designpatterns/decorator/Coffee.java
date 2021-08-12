package com.example.test.designpatterns.decorator;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 17:54
 * @Desc:
 */
public class Coffee extends Drink{

    @Override
    public float cost() {
        System.out.println("获取咖啡饮品的价格");
        return super.getPrice();
    }
}
