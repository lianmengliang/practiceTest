package com.example.test.DesignPatterns.Proxy;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 15:45
 * @Desc:
 */
public class ProxyPatterDemo {

    public static void main(String[] args) {

        Image image = new ProxyImage("hello.txt");

        //
        image.display();
        System.out.println("---------------");
        //
        image.display();

    }
}
