package com.example.test.DesignPatterns.factorymethod.pizza;

/**
 * @Author ： Leo
 * @Date : 2021/3/19 11:25
 * @Desc:
 */
public class LDCheesePizza extends Pizza2{
    @Override
    public void prepare() {
        setName("伦敦奶酪pizza");
        System.out.println("给伦敦的奶酪pizza 准备原材料。。。");
    }
}
