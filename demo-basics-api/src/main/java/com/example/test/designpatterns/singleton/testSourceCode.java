package com.example.test.designpatterns.singleton;

/**
 * @Author ： Leo
 * @Date : 2021/3/18 16:09
 * @Desc:
 */
public class testSourceCode {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.totalMemory());
        System.out.println(runtime.availableProcessors());
        System.out.println();

    }
}
