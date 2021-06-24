package com.example.test.javaBasis.thread.multithreading;

/**
 * @Author ： Leo
 * @Date : 2021/6/23 12:03
 * @Desc: 使用多线程。模拟三个窗口同时售票
 */
public class SellTicket {
    public static void main(String[] args) {

        // 第一种方式
       /* System.out.println("第3种方式售票");
        SellTicketDemo ticket01 = new SellTicketDemo();
        SellTicketDemo ticket02 = new SellTicketDemo();
        SellTicketDemo ticket03 = new SellTicketDemo();
        ticket01.start();
        ticket02.start();
        ticket03.start();*/




        /*System.out.println("第2种方式售票");
        SellTicket02 sellTicket01 = new SellTicket02();
        SellTicket02 sellTicket02 = new SellTicket02();
        SellTicket02 sellTicket03 = new SellTicket02();

        Thread thread1 = new Thread(sellTicket01);
        Thread thread2 = new Thread(sellTicket02);
        Thread thread3 = new Thread(sellTicket03);

        thread1.start();
        thread2.start();
        thread3.start();*/

        System.out.println("第2种方式售票");
        SellTicketDemo1 sellTicket01 = new SellTicketDemo1();
        SellTicketDemo1 sellTicket02 = new SellTicketDemo1();
        SellTicketDemo1 sellTicket03 = new SellTicketDemo1();

        Thread thread1 = new Thread(sellTicket01);
        Thread thread2 = new Thread(sellTicket02);
        Thread thread3 = new Thread(sellTicket03);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}


/**
 * 第一种方式：继承Thread类
 */
class SellTicket01 extends Thread {
    private static int ticket = 60;


    @Override
    public void run() {
        while (true) {
            if (ticket <= 0) {
                System.out.println("---售票结束---");
                break;
            }

            System.out.println(Thread.currentThread().getName() + "售出票数一张,还剩" + (--ticket) + "张");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

/**
 * 第二种方式：实现Runnable接口
 */
class SellTicket02 implements Runnable {
    private static int ticket = 50;

    @Override
    public void run() {
        while (true) {
            if (ticket <= 0) {
                System.out.println("---售票结束---");
                break;
            }

            System.out.println(Thread.currentThread().getName() + "售出票数一张,还剩" + (--ticket) + "张");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 第一种方式：继承Thread类
 */
class SellTicketDemo extends Thread {
    private static int ticket = 60;

    private boolean loop = true;

    public synchronized void sell() {
        if (ticket <= 0) {
            System.out.println("---售票结束---");
            loop = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "售出票数一张,还剩" + (--ticket) + "张");
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }

}


class SellTicketDemo1 implements Runnable {
    private static int ticket = 60;

    private static boolean loop = true;

    public synchronized void sell() {
        if (ticket <= 0) {
            System.out.println("---售票结束---");
            loop = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "售出票数一张,还剩" + (--ticket) + "张");
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }

}