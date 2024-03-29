package com.example.test.java_basis.collection.homework;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @Author ： Leo
 * @Date : 2021/8/17 18:32
 * @Desc: HashSet的作业2：
 *
 * 描述：
 * 定义一个Employee类,该类包含:private成员属性name,sal,birthday(MyDate类型)，
 * 其中birthday 为 MyDate类型(属性包括: year, month, day),
 *
 * 要求:
 * 1.创建3个Employee 放入 HashSet中
 * 2.当name和birthday的值相同时，认为是相同员工,不能添加到HashSet集合中
 */
public class HashSetHomeWork002 {
    public static void main(String[] args) {

        //  LinkedHashSet的练习
        LinkedHashSet<Integer> integers = new LinkedHashSet<>();

        integers.add(1);
        integers.remove(2);


        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
