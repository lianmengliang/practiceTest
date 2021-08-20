package com.example.test.javaBasis.collection;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author ： Leo
 * @Date : 2021/8/19 12:04
 * @Desc:
 */

@SuppressWarnings("all")
public class SetDemo {
    public static void main(String[] args) {
        test001();
        Map<String, Object> map = new ConcurrentHashMap<>();
    }


    /**
     * 测试
     */
    public static void test001() {

        // 普通格式
        /*Set set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo(((String)o2));
            }
        });*/

        // jdk8 的lambda格式
        // 正序排列
//        Set<String> set = new TreeSet<>(Comparator.comparing(o -> (o))); //[231, Tom, ios, kevin, leo]
        // 倒序排列
        Set<String> set = new TreeSet<>(Comparator.reverseOrder()); //[leo, kevin, ios, Tom, 231]

//        Set<String> set = new TreeSet<>();  //[231, Tom, ios, kevin, leo]

        set.add("231");
        set.add("leo");
        set.add("kevin");
        set.add("Tom");
        set.add("ios");

        System.out.println(set);


//        Set<Integer> set1 = new TreeSet<>(Comparator.comparingInt(o -> (o)));
        //倒序排列
        Set<Integer> set1 = new TreeSet<>(Comparator.reverseOrder());

        set1.add(123);
        set1.add(12);
        set1.add(1343);
        set1.add(11);

        System.out.println("set1:" + set1);


        Set<Integer> set2 = new TreeSet<>(Comparator.comparingInt(o->o));

        set2.add(3);
        set2.add(2);
        set2.add(5);
        set2.add(6);
        set2.add(7);


        System.out.println("set2："+set2.toString());


    }
}
