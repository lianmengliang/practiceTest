package com.example.test.DesignPatterns.decorator;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 17:59
 * @Desc: 装饰器
 */
public class Decorator extends Drink {

    private Drink obj;

    /**
     * 构造器
     *
     * @param obj
     */
    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        // getPrice() 自己的价格 + Drink的价格
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        // obj.getDes()输出被装饰者的信息
        return des + ":" + super.getPrice() + " & " + obj.getDes();
    }
}
