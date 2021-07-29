package com.example.test.javaBasis.collection;

import java.util.*;

/**
 * @Author ： Leo
 * @Date : 2021/7/26 15:35
 * @Desc:
 */
public class Collection_ {
    public static void main(String[] args) {



    }
    public static void test002(){

    }

    public static void test001(){
        List<String> list = new ArrayList<>();
        list.add("12312");
        list.add("12");
        list.add("123");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        list.forEach(System.out::println);
        System.out.println(list.toString());
    }
}
