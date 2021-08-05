package com.example.test.designpatterns.decorator;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 18:04
 * @Desc: 具体的调味品 巧克力
 */
public class Chocolate extends Decorator {

    /**
     * 构造器
     *
     * @param obj
     */
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        // 调味品的价格
        setPrice(3.0f);
    }
}
