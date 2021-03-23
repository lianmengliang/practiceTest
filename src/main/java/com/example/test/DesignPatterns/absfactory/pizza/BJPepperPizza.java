package com.example.test.DesignPatterns.absfactory.pizza;

/**
 * @Author ： Leo
 * @Date : 2021/3/19 11:24
 * @Desc:
 */
public class BJPepperPizza extends Pizza2 {
    @Override
    public void prepare() {
        setName("北京胡椒pizza");
        System.out.println("给北京的胡椒pizza 准备原材料。。。");
    }
}
