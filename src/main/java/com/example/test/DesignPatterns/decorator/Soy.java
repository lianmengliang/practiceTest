package com.example.test.DesignPatterns.decorator;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 18:07
 * @Desc:
 */
public class Soy extends Decorator {
    /**
     * 构造器
     *
     * @param obj
     */
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(1.5f);
    }
}
