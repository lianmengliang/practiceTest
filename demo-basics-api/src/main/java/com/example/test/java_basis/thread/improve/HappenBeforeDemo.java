package com.example.test.java_basis.thread.improve;

/**
 * @Author ： Leo
 * @Date : 2021/7/1 14:54
 * @Desc: 指令重拍： 代码执行顺序 和 编码顺序不一致 （预期不一致）
 * 目的： 提高性能
 */
public class HappenBeforeDemo {

    private static int a = 0;

    private static boolean flag = false;

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            a = 0;
            flag = false;

            // 线程1读取数据
            Thread t1 = new Thread(() -> {
                a = 1;
                flag = true;
            });

            // 线程2更改数据
            Thread t2 = new Thread(() -> {

                if (flag) {
                    a *= 1;
                }
                if (a == 0) {
                    System.out.println((++count) + "  happen before -> " + a);
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }


    }
}
