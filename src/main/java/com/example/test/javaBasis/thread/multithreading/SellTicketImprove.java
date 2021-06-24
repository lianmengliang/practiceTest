package com.example.test.javaBasis.thread.multithreading;

/**
 * @Author ： Leo
 * @Date : 2021/6/24 11:03
 * @Desc:
 */
public class SellTicketImprove {
    public static void main(String[] args) {


        TicketSell t1 = new TicketSell();
        TicketSell t2 = new TicketSell();
        TicketSell t3 = new TicketSell();


        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

    }
}


class TicketSell implements Runnable {
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
