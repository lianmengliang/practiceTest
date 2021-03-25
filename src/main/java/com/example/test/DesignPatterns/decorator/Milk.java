package com.example.test.DesignPatterns.decorator;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 18:04
 * @Desc:
 */
public class Milk extends Decorator {
    /**
     * 构造器
     *
     * @param obj
     */
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2.0f);
    }
}
