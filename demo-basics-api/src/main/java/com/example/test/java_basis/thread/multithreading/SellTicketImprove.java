package com.example.test.java_basis.thread.multithreading;

/**
 * @Author ： Leo
 * @Date : 2021/6/24 11:03
 * @Desc:
 */
public class SellTicketImprove {
    public static void main(String[] args) {

        // 第一种方式：实现Runnable接口
        // 测试的时候注意以下问题：
        // 1.只new一个卖票类，保证只有100张票
        // 2.多个线程共享一个资源,也就是票的数量
        // 3.可以把票的数量多加点，才能看出效果
        TicketSell t1 = new TicketSell();

        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();


    }
}


/**
 * 练习
 */

/**
 *  方法锁
 */
class TicketSell implements Runnable {
    private int ticket = 100;

    private boolean loop = true;

    Object object = new Object();


    //同步方法（静态的）的锁为当前类本身
    //老师解读
    //1. public synchronized static void m1() {} 锁是加在 TicketSell.class
    //2. 如果在静态方法中，实现一个同步代码块.
    /*
        synchronized (TicketSell.class) {
            System.out.println("m2");
        }
     */
    public synchronized static void m1() {

    }

    public static void m2() {
        synchronized (TicketSell.class) {
            System.out.println("m2");
        }
    }

    //1. public synchronized void sell() {} 就是一个同步方法
    //2. 这时锁在 this对象
    //3. 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在this对象
    public /*synchronized*/ void sell() {

        synchronized (/*this*/object) {
            if (ticket <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticket));
        }

    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }

}
