package com.example.test.java_basis.thread.create_thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author ： Leo
 * @Date : 2021/10/18 14:26
 * @Desc: 创造线程池的方法
 */
public class CreateTeadPoolDemo {
    public static void main(String[] args) {

        createTeadPoll();
    }


    /**
     * 创建线程池的方法
     */
    public static void createTeadPoll() {

        ThreadLocalRandom current = ThreadLocalRandom.current();

        System.out.println(current);


    }
}
