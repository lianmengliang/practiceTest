package com.example.test.designpatterns.strategy;

import java.util.Arrays;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:45
 * @Desc: 用于主方法测试
 */
public class Client {
    public static void main(String[] args) {



        Integer [] arr = {12,2,4,23,76,0,23};

        Arrays.sort(arr);

        for (Integer integer : arr) {
            System.out.println(integer);
        }

        System.out.println(Arrays.toString(arr));

    }
}
