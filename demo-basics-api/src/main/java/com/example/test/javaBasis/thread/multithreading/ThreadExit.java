package com.example.test.javaBasis.thread.multithreading;

/**
 * @Author ： Leo
 * @Date : 2021/6/23 14:45
 * @Desc: 通知线程退出
 *
 * 在A线程中，可以设置B线程 的是否退出 （执行）变量，
 * 如控制死循环的loop = true，A线程中可以设置为false 终止B线程
 *
 */
public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        // 如果希望main线程去控制t1，线程的终止，必须可以修改loop
        // t1 退出run方法，从而终止 t1线程 --> t1线程退出

        System.out.println("main线程休眠10s...");
        Thread.sleep( 20 * 1000);
        t.setLoop(false);

        for (int i = 1; i <= 10; i++) {
            Thread.sleep(500);
            System.out.println("main"+i+"线程继续运行。。。");
        }
    }
}


class T extends Thread {
    private int count = 0;

    // 设置一个控制变量
    private boolean loop = true;

    @Override
    public void run() {

        while (loop) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中..." + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
