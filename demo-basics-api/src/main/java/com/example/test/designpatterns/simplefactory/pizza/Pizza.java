package com.example.test.designpatterns.simplefactory.pizza;

/**
 * @Author ： Leo
 * @Date : 2021/3/18 16:54
 * @Desc:
 */
public abstract class Pizza {

    // 披萨的名称
    protected String name;

    public abstract void prepare();

    public void bake() {
        System.out.println(name + "bakinging...");
    }

    public void cut() {
        System.out.println(name + "cutting...");
    }

    public void box() {
        System.out.println(name + "boxing...");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

