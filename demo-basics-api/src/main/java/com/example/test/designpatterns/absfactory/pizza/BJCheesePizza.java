package com.example.test.designpatterns.absfactory.pizza;

/**
 * @Author ： Leo
 * @Date : 2021/3/19 11:23
 * @Desc:
 */
public class BJCheesePizza extends Pizza2 {

    @Override
    public void prepare() {
        setName("北京奶酪pizza");
        System.out.println("给北京的奶酪pizza 准备原材料。。。");
    }
}
