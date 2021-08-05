package com.example.test.designpatterns.prototype;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 15:05
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {

        Sheep sheep = new Sheep("tom", 2, "黑色");
        Sheep sheep2 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep3 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep4 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep5 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());


        System.out.println(sheep);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);
    }
}
