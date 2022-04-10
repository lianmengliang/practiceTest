package com.example.test.java_basis.generic.homework.homework_pro;

import java.util.HashMap;
import java.util.Map;

/**
 * lianmengliang
 * <p>
 * 2022-03-27 22:56
 */
public class DAO<T> {

    private Map<String, T> map = new HashMap<>();


    public static void main(String[] args) {


        double num1 = .222;
        float num2 = 2.3F;

        double num3 = 0.2244e3;
        float num4 = 3.11E-2F;
        System.out.println(num3);
        System.out.println(num4);

        double num5 = 2.7;
        double num6 = 8.1 / 3;
        System.out.println(num5);
        System.out.println(num6);

        //如何比较？ 使用Math.abs();
        if (Math.abs(num6 - num5) < 0.000001) {
            System.out.println("差值非常小，可以认为是相等。。。。");
        }


        float num7 = 2.7F;
        float num8 = 8.1F / 3;
        System.out.println(num7);
        System.out.println(num8);


        Double num9 = 2.7;
        Double num10 = 8.1 / 3;
        System.out.println(num9);
        System.out.println(num10);

        System.out.println(num9.toString());
        System.out.println(num10.toString());


        System.out.println(10f);
        System.out.println((double) 10);


        System.out.println("其他转十进制练习......");

        int b1 = 0b1100011100;
        int b2 = 02456;
        int b3 = 0xA45;

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        System.out.println("其他转十进制练习......");



        System.out.println("其他转十进制练习......");

        System.out.println("原码反码和补码练习");
        System.out.println(2|3);
        System.out.println(2^3);
        System.out.println((-2)|3);


    }

}
