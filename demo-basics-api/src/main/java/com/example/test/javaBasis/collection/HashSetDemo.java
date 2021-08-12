package com.example.test.javaBasis.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ： Leo
 * @Date : 2021/8/10 18:01
 * @Desc: Set接口对象 HashSet的练习及说明
 */
public class HashSetDemo {
    public static void main(String[] args) {


        basicPratices();
    }

    /**
     * 基础练习
     */
    private static void basicPratices() {

        Set set = new HashSet();
        System.out.println("set：" + set);
        // 添加
        set.add(null);
        set.add("leo");
        set.add("kevin");
        set.add(123);
        System.out.println(set.add(888));
        set.add(666);
        System.out.println(set.add(888));

        System.out.println("set：" + set);

        set.add(new Dog("tom"));
        set.add(new Dog("tom"));


        // 删除
        set.remove(123);


        System.out.println("set：" + set);

    }


}

class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}