package com.example.test.java_basis.reflex;

/**
 * @Author ： Leo
 * @Date : 2021/6/17 14:42
 * @Desc:
 */
public class Car {

    public String brand = "凯迪拉克";

    public int price= 120000;

    public String color = "白色";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    public void hello(){
        System.out.println("hello，你好");
    }

    public void love(){
        System.out.println("love YOU！");
    }
}
