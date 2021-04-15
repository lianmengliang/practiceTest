package com.example.test.designpatterns.prototype.improve;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 15:16
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {

        Sheep sheep = new Sheep("tom", 2, "黑色");

        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();

        System.out.println(sheep);
        System.out.println(sheep1);
        System.out.println(sheep2);
    }
}
