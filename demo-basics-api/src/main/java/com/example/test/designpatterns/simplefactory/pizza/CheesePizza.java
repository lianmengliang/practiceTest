package com.example.test.designpatterns.simplefactory.pizza;

public class CheesePizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("给奶酪披萨制作准备材料。。。");
    }
}

