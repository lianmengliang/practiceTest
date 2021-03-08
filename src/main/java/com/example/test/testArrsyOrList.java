package com.example.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.swagger.models.auth.In;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author ： Leo
 * @Date : 2021/2/23 16:03
 * @Desc: Java8 增强工具类 Arrays 笔记
 */
public class testArrsyOrList {


    public static void getRandomNum() {
        long[] arrays = new long[20];

        Arrays.parallelSetAll(arrays, index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrays).limit(10).forEach(i -> System.out.println(i + " "));

        System.out.println("-------------------------");
        //升序排列
        Arrays.parallelSort(arrays);
        Arrays.stream(arrays).limit(10).forEach(i -> System.out.println(i + " "));


    }

    /**
     *
     */
    public static void testArraysUtil(){
        //新建一个测试数组
        Integer[] arrays = {6,1,9,2,5,7,6,10,6,12};

        //直接创建一个list
        List<Integer> intList = Arrays.asList(arrays);

        //以下是单线程算法，处理数组
        //1.
        //查找数组中为 key 的 下标 ：binarySearch 二分法查找,数组必须有序，且存在            此数组中，否则返回负数下标
        Integer[] arr = {1,2,3,4,5,6};
        int binarySearch = Arrays.binarySearch(arr, 6);
//        System.out.println(binarySearch);

        //在指定的范围内查找 key 的下标
        int binarySearch1 = Arrays.binarySearch(arr, 0, 5,4 );
//        System.out.println(binarySearch1);


        System.out.println("-----------------------------");

        //copyOf:复制出新的数组，复制的长度由newLength决定，长度可大于被复制数组的长度
        //copyOfRang: 复制指定小标范围的值
        Integer[] copyOfArray = Arrays.copyOf(arrays, 6);
        for (Integer integer : copyOfArray) {
            System.out.print(integer+"-");
        }
        System.out.println();
        //复制指定下标范围内的值，含头不含尾
        Integer[] copyOfRange = Arrays.copyOfRange(arrays, 2, 7);
        for (Integer integer : copyOfRange) {
            System.out.print(integer+"-");
        }

        System.out.println("-------------------------------");

        //在指定下标内，对数组进制默认升序排序，这将改变原数组，下标含头不含尾
        // 输出结果：1-2-5-6-6-7-9-10-6-12-  对前8个元素进行了排序
        Integer[] arrayTest = Arrays.copyOf(arrays, arrays.length);
        Arrays.sort(arrayTest,0,8);
        for (Integer integer : arrayTest) {
            System.out.print(integer+"-");
        }
        System.out.println();
        //数组内全部排序
        Arrays.sort(arrayTest);
        for (Integer integer : arrayTest) {
            System.out.print(integer+"-");
        }

        System.out.println();
        System.out.println("-------------------------------");

        //使用比较器降序排序，在指定 下标范围内
        Integer[] arrayTest1 = Arrays.copyOf(arrays, arrays.length);
        // 对前8个元素进行降序排序
        Arrays.sort(arrayTest1,0,8, Comparator.reverseOrder());
        // 对所有的元素进行降序排序
        Arrays.sort(arrayTest1, Comparator.reverseOrder());
        for (Integer integer : arrayTest1) {
            System.out.print(integer+"-");
        }


        System.out.println();
        System.out.println("-------------------------------");

        //数组 toString
        String toString = Arrays.deepToString(arrayTest1);
        System.out.println("数组转换为字符串"+toString);

        Integer[][] stuGrade={{1,3,5,7,9},{2,4,6,8},{1,5,20}};
        String s = Arrays.deepToString(stuGrade);
        System.out.println("二维数组转换为字符串"+s);

        //比较一维数组内容是否相等
        boolean b = Arrays.deepEquals(arrayTest1, arrays);
        System.out.println(b);
        Integer[] arrayTest2 = Arrays.copyOf(arrays, arrays.length);
        boolean b1 = Arrays.deepEquals(arrays,arrayTest2);
        System.out.println(b1);
        System.out.println("-------------------------------");

        Integer[] fillArr = new Integer[5];
        //将一个数组置为 val(5)    ----输出：5-5-5-5-5-
        Arrays.fill(fillArr,5);
        for (Integer integer : fillArr) {
            System.out.print(integer+"-");
        }
        System.out.println();
        //将一个数组指定范围内置为 val(10)  含头不含尾  ----输出：5-10-10-10-5-
        Arrays.fill(fillArr,1,4,10);
        for (Integer integer : fillArr) {
            System.out.print(integer+"-");
        }

        System.out.println("--------------------------");

        //自定义数组内的 元素按照某种表达式 添加
        //如表达式：(a+1)*2 --->输出：2-4-6-8-10-12-14-16
        Integer[] setAllArr = Arrays.copyOf(arrays, 8);
        //一个数组全部做表达式操作
        Arrays.setAll(setAllArr,a->(a+1)*2);
        for (Integer integer : setAllArr) {
            System.out.print(integer+"-");
        }

        //以下是多线程算法，处理数组(大多以parallel做为开头的方法，可以充分利用现代CPU多核，处理大规模庞大的数组很有效)

        System.out.println();
        Integer[] arrayPP = Arrays.copyOf(arrays, arrays.length);

        for (Integer integer : arrayPP) {
            System.out.print(integer+"-");
        }
        System.out.println();
        /*Arrays.parallelPrefix(arrayPP,(x,y)->x*y);
        for (Integer integer : arrayPP) {
            System.out.print(integer+"-");
        }*/
        //在指定下标范围内，对原数组内容进行二元操作，下标含头不含尾
        Arrays.parallelPrefix(arrayPP,0,5,(x,y)->x*y);
        for (Integer integer : arrayPP) {
            System.out.print(integer+"-");
        }

        System.out.println();
        Integer[] arrayPP1 = Arrays.copyOf(arrays, arrays.length);
        for (Integer integer : arrayPP1) {
            System.out.print(integer+"-");
        }
        System.out.println();
        Arrays.parallelSetAll(arrayPP1,a->a*5);
        for (Integer integer : arrayPP1) {
            System.out.print(integer+"-");
        }

        System.out.println();


        //返回一个Spliterator进行其他操作
        Spliterator<Integer> spliterator = Arrays.spliterator(arrays);

        //将原有Spliterator切出一部分为新的Spliterator，不可切时返回null
        Spliterator<Integer> integerSpliterator = spliterator.trySplit();
        //对Spliterator遍历操作
        integerSpliterator.forEachRemaining(a-> System.out.print(a+" "));
        System.out.println();
        // estimateSize 还有几个元素要处理
        while(spliterator.estimateSize()>0){
            //对每个元素进行处理
            spliterator.tryAdvance(x-> System.out.print(x*2+" "));
        }
        System.out.println();
        for (Integer array : arrays) {
            System.out.print(array+"-");
        }

        //还有几个要遍历
        System.out.println(integerSpliterator.getExactSizeIfKnown());


        //表示该Spliterator有那些特性，用于优化
        System.out.println(spliterator.characteristics());

    }

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
//        getRandomNum();

        testArraysUtil();
    }



}