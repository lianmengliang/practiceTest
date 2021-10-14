package com.example.test.java_basis.thread.api;


/**
 * @Author ： Leo
 * @Date : 2021/6/23 15:02
 * @Desc:
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        thread02();
    }


    /**
     * 1. 关于Thread基础api调用
     * 2. 中止休眠 interrupt() 方法
     *
     * @throws {}InterruptedException
     */
    public static void thread01 () throws InterruptedException {
        T1 t = new T1();
        System.out.println("线程名称：" + t.getName());
        System.out.println("线程的优先级：" + t.getPriority());
        // 启动子线程
        t.start();

        Thread.currentThread().setName("Leo");
        for (int i = 0; i <= 10; i++) {
            Thread.sleep(50);
            System.out.println(Thread.currentThread().getName() + "在玩耍..." + i);
        }

//        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println("线程的优先级重新设置为：" + t.getPriority());

        t.setName("Kevin");
        // 当执行到这里t线程就会被中断休眠，然后继续学习
        t.interrupt();
        System.out.println("中断了子线程的休眠...");
    }

    /**
     * 1.插队
     * 2.礼让
     *
     * @throws {}InterruptedException
     */
    public static void thread02() throws InterruptedException {
        T2 t2 = new T2();
        t2.setName("老大");
        t2.start();

        Thread.currentThread().setName("小弟");
        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "在吃包子..." + i);
            if (i % 2 == 1) {
                System.out.println("小弟让老大插队。。。");
                // 礼让 - 但不一定 让其线程插队成功
                Thread.yield();
                // 插队 -- 一定让线程先执行
//                t2.join();
                System.out.println("小弟继续吃包子...");

            }

        }
    }

}


class T2 extends Thread {
    @Override
    public void run() {

        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            System.out.println(Thread.currentThread().getName() + "在吃包子..." + i);
        }


    }

}

/**
 * 中断 休眠操作
 */
class T1 extends Thread {

    @Override
    public void run() {

        while (true) {

            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + "在学习..." + i);
            }

            try {
                Thread.sleep(10 * 1000);
                System.out.println("休眠结束，继续学习");
            } catch (InterruptedException e) {
                //  e.printStackTrace();
                // 当线程执行到一个interrupt 方法时，就会catch一个异常
                // 下面就可以加入自己的业务代码
                System.out.println(Thread.currentThread().getName() + "被中断休眠了，然后继续学习...");
            }
        }

    }
}

