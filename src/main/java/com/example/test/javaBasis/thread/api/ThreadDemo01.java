package com.example.test.javaBasis.thread.api;

/**
 * @Author ： Leo
 * @Date : 2021/6/23 16:46
 * @Desc: 守护线程
 */
public class ThreadDemo01 {
    public static void main(String[] args) throws InterruptedException {
        T3 t2 = new T3();

        // 设置为 守护线程
        t2.setDaemon(true);
        // 启动线程
        t2.start();



        for (int i = 1; i <= 20; i++) {
            System.out.println("宝强在辛勤的工作..." + i);
            Thread.sleep(1000);
        }
        System.out.println("宝强休息了...");

    }
}


class T3 extends Thread {
    @Override
    public void run() {
        for (; ; ) {
            System.out.println("马蓉和宋吉吉在聊天，嘻嘻。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }

    }

}