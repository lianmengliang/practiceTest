package com.example.test.javaBasis.thread.improve.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @Author ： Leo
 * @Date : 2021/7/2 18:04
 * @Desc:
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 1.创建指定数量的线程池
        ExecutorService service = newFixedThreadPool(10);
//
        // 设置线程的属性
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        service1.setCorePoolSize(15);
//        service1.se

        // 2.执行指定的线程的操作，需要提供实现Runnable/Callable接口实现类的对象
        // 说明service.execute() 适用于 实现Runnable接口的实例
        service.execute(new NumberThread());
        service.execute(new NumberThread1());
        // 说明service.submit() 适用于 实现Callable接口的实例
//        service.submit(new NumberThread());
        // 3.关闭连接池
        service.shutdownNow();



    }
}


class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+"--》"+i);
            }
        }
    }
}
class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName()+"--》"+i);
            }
        }
    }
}