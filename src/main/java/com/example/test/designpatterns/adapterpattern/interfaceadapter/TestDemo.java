package com.example.test.designpatterns.adapterpattern.interfaceadapter;


/**
 * @Author ： Leo
 * @Date : 2021/3/23 18:30
 * @Desc:
 */
public class TestDemo {
    public static void main(String[] args) {

        AbsImpl abs = new AbsImpl() {
            @Override
            public void m1() {
                System.out.println("使用了m1的方法");
            }

        };

        abs.m1();
        abs.m2();


    }
}
