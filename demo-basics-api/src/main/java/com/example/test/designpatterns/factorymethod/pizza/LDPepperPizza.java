package com.example.test.designpatterns.factorymethod.pizza;

/**
 * @Author ： Leo
 * @Date : 2021/3/19 11:26
 * @Desc:
 */
public class LDPepperPizza extends Pizza2 {
    @Override
    public void prepare() {
        setName("伦敦胡椒pizza");
        System.out.println("给伦敦的胡椒pizza准备原材料。。。");
    }
}
