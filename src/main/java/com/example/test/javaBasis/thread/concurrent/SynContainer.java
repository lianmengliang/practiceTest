package com.example.test.javaBasis.thread.concurrent;


import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author ： Leo
 * @Date : 2021/6/29 18:35
 * @Desc: 线程安全
 * 练习： list对应的并发容器 CopyOnWriteArrayList
 */
public class SynContainer {

    public static void main(String[] args) {


        currentDemo01();
        currentDemo02();
    }

    /**
     * 使用synchronized 往list中添加值
     */
    private static void currentDemo01() {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

    /**
     * list对应的并发容器 CopyOnWriteArrayList
     */
    private static void currentDemo02() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();


        for (int i = 0; i < 1000; i++) {
            new Thread(() ->
                    list.add(Thread.currentThread().getName())).start();
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }


}
