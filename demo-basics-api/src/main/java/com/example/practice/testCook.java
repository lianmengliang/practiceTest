package com.example.practice;

import com.example.practice.impl.Cook;

import javax.xml.ws.spi.Invoker;

/**
 * @Author ： leo
 * @Date :2020/4/22 12:05
 */
public class testCook {
    public static void main(String[] args) {
        invokeCook(()->
                System.out.println("做饭啦")
        );

    }

    public static void invokeCook(Cook cook){
        cook.makeFood(); }
}
