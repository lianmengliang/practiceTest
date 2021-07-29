package com.example.test.javaBasis.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @Author ： Leo
 * @Date : 2021/7/26 17:04
 * @Desc:
 */
public class ListDemo {


    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(8);
        List<String> list2 = new Vector<>();
        List<String> list3 = new LinkedList<>();


        list1.add("宫保鸡丁");
        list1.add("回锅肉");
        list1.add("辣子鸡丁");
        list1.add("小炒肉");

        list2.add("宫保鸡丁");
        list2.add("回锅肉");
        list2.add("辣子鸡丁");
        list2.add("小炒肉");


        list3.add("宫保鸡丁");
        list3.add("回锅肉");
        list3.add("辣子鸡丁");
        list3.add("小炒肉");


        listDemo(list1);
        vectorDemo(list2);
        vectorDemo(list3);
    }


    public static void listDemo(List list){
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("-----------------------------");
    }

    public static void vectorDemo(List list){
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("-----------------------------");
    }


    public static void linkedListdemo(List list){
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("-----------------------------");
    }
}
