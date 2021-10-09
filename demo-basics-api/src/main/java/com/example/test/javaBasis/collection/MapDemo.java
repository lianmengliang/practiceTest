package com.example.test.javaBasis.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author ： Leo
 * @Date : 2021/8/18 17:52
 * @Desc:
 */
public class MapDemo {
    public static void main(String[] args) {
       /* tsetMap001();
        tsetMap002();*/


        Map<Object, String> map = new HashMap<>();
        map.put(1, "Leo");
        map.put(2, "Leo");


        System.out.println("size:" + map.size());

        Hashtable<Object, String> tableMap = new Hashtable<>();
        tableMap.put(3,"Kevin");
        tableMap.put(4,"Alice");

        ConcurrentHashMap<Object, String> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put(3,"Kevin");
        concurrentHashMap.put(4,"Alice");

        int i = 1;
        int j;

        j = ++i;
    }

    /**
     * 测试HashMap
     */
    private static void tsetMap001() {

        List list = new ArrayList();

        Map<String, Object> hashMap = new HashMap<>(16);


        hashMap.put("Leo", 123);

        Object leo = hashMap.get("Leo");
        Object a = hashMap.get("123");
        System.out.println(leo);
        System.out.println(a);


        Map<String, Object> map = new HashMap<>();
    }

    /**
     * 测试HashTable
     */
    private static void tsetMap002() {


//        HashMap<Integer, String> treeMap = new HashMap<>();


        TreeMap<Integer, Object> treeMap = new TreeMap<>(Comparator.reverseOrder());


        treeMap.put(2, "leo");
        treeMap.put(34, "Kevin");
        treeMap.put(12, "Jane");
        treeMap.put(46, "Tom");
        treeMap.put(10, "Alice");


        System.out.println(treeMap.toString());

     /*   treeMap.forEach((k, v) -> System.out.println(k + "--" + v));

        StringBuilder sb = new StringBuilder();

        treeMap.forEach((k,v)-> sb.append(v).append("   "));

        System.out.println(sb.toString());*/


    }


    /**
     * 测试HashTable
     */
    private static void tsetMap003() {


        Map<String, Object> currentHashMap = new ConcurrentHashMap<>();


        currentHashMap.put("leo", 123);

        currentHashMap.get("leo");

        LinkedHashSet<Object> set = new LinkedHashSet<>();

        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();


    }

    /**
     * 基于 “...”的测试， 三个点相当于“[]”, 数组
     * 可以传入多个int类型的参数 （或者其他类型也可以）
     *
     * @param args
     */
    public void testDemo(int... args) {


        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }


        int[] ints = new int[9];
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }

}
