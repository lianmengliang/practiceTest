package com.example.test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author ： leo
 * @Date :2020/3/26 10:40
 *
 * 练习 jdk8的stream
 */

/**
 * stream 的常用方法：
 * 1.循环 stream.forEach();
 * 2.过滤 stream.filter();
 * 3.类型转换 stream.map();  如：stream.map((String s)-> Integer.parseInt(s));
 * 4.计数 stream.count();
 * 5.截取 stream.limit();  如： stream.limit(3); 截取前三个元素
 * 6.跳过元素 stream.skip(); 如： stream.skip(3); 跳过前三个元素
 * 7.把流组合到一起 Stream.concat(stream1, stream2);
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


    private static void getStreamResult(){
        //创建一个 List 集合,存储姓名
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        /*list.stream().filter(s‐>
                s.startsWith("张"))
        .filter(s ‐> s.length() == 3)
        .forEach(System.out::println); }
        */

        list.stream()
                .filter(s->s.startsWith("张"))
                .filter(s->s.length()==3)
                .forEach(System.out::println);

        System.out.println(list.stream().count());


    }

    /**
     * 转换流
     */
    private static void getStreamToMap(){
        //获取一个 String 类型的 Stream 流
         Stream<String> stream = Stream.of("1", "2", "3", "4");
        // 使用 map 方法,把字符串类型的整数,转换(映射)为 Integer 类型 的整数
        Stream<Integer> stream2 = stream.map((String s)-> Integer.parseInt(s));
        //System.out.println(stream2.count());
        // 遍历 Stream2 流
        stream2.forEach(i-> System.out.println(i));


    }


    public static void main(String[] args) {

        getStreamResult();
    }


}
