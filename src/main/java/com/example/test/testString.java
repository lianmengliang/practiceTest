package com.example.test;

import java.util.function.Function;

/**
 * @Author ： leo
 * @Date :2020/2/27 18:38
 */
public class testString {
    public static void main(String[] args) {
        getString1();
    }

    public static void getString(){

        String[] split = "asd,fg,hjk".split(",");
        String s = "asd,fg,hjk".split("\\,")[0];

        System.out.println(split);
        System.out.println(s);
    }

    public static void getString1(){


        String s = "2312";

        Function<String,Integer> fun1 = after -> null;


        Integer apply = fun1.apply(s);

        System.out.println(apply);
    }
}
