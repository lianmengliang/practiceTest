package com.example.test.java_basis.thread.improve.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author ： Leo
 * @Date : 2021/7/2 16:38
 * @Desc: CAS : 比较并交换
 */
public class CASDemo {

    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                // 模拟下网络延时
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = stock.decrementAndGet();
                if (left < 1) {
                    System.out.println("抢完了...");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " 抢到了了一件商品"+"-->还剩" + left + "件商品");
            }).start();
        }


    }
}
