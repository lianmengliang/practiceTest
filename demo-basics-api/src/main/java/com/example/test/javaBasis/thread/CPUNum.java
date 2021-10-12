package com.example.test.javaBasis.thread;


import org.apache.poi.ss.formula.functions.T;

/**
 * @Author ： Leo
 * @Date : 2021/6/22 16:09
 * @Desc:  获取 当前电脑的CPU 个数
 */
public class CPUNum {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        int cpuNums = runtime.availableProcessors();

        System.out.println("当前电脑的CPU 个数：" + cpuNums);

    }
}
