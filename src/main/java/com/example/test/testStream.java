package com.example.test;

import java.util.*;

/**
 * @Author ： leo
 * @Date :2020/3/26 10:40
 *
 * 练习 jdk8的stream
 */
public class testStream {


    public static void stringConversionList(){

        // String的数组
        String[]  array = {"12","21","21"};
        // 数组转集合
        // 1.Collections.addAll() 方法
        List<String> resultList = new ArrayList<>(array.length);
        Collections.addAll(resultList,array);


       // 数组转集合ArrayList<String> list =  List.of(str);   jdk1.9的方法
        // 已知“确定个数的字符串”转换为集合
        List<String> menus = Arrays.asList("宫保鸡丁", "糖醋鲤鱼", "重庆辣子鸡","回锅肉","水煮鱼");


        Integer[] arrayInt = {1,3,2};

        ArrayList<Integer> intList = new ArrayList<>(arrayInt.length);
        Collections.addAll(intList,arrayInt);
    }

    /**
     * 字符串数组 转化为 集合
     * ArrayList集合只能存储引用数据类型，
     * 其实也可以存储基本数据类型。
     * 在ArrayList集合当中，
     * 如果要存储基本数据类型需要用到基本数据类型相对应的包装类
     * @param array
     * @return
     */
    public static ArrayList stringConList(String[] array){

        // 1. 方法： Collections.addAll()
        ArrayList<String> list1 = new ArrayList<>(array.length);

        Collections.addAll(list1,array);

        //2. 方法： Arrays.asList()
        /**
         * 调用Arrays.asList()时，其返回值类型是ArrayList，
         * 但此ArrayList是Array的内部类，调用add()时，
         * 会报错：java.lang.UnsupportedOperationException，
         * 并且结果会因为array的某个值的改变而改变，
         * 故需要再次构造一个新的ArrayList
         */
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(array));

        return list1;
    }



    public static void main(String[] args) {


    }
}
