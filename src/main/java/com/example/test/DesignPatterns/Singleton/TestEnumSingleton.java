package com.example.test.DesignPatterns.Singleton;

/**
 * @Author ： Leo
 * @Date : 2021/3/16 10:17
 * @Desc:
 */
public class TestEnumSingleton {

    public static void main(String[] args) {

        System.out.println(User.getInstance());
        System.out.println(User.getInstance());

        System.out.println(User.getInstance()==User.getInstance());

    }
}
