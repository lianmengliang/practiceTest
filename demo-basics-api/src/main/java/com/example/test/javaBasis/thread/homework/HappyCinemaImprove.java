package com.example.test.javaBasis.thread.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/6/28 18:28
 * @Desc:  多线程练习作业
 *
 * 快乐影院：
 * 模拟多个用户买一家影院的票
 * 1. 一个用户可以多张票
 * 2. 加入同步机制，保证不超卖
 * 3. 加入座位校验，保证不错卖
 * <p>
 * 延伸：
 * 1.位置校验，这个位置已售或没有这个位置
 * 2.多个用户多个影院购买--> 判断用户选择的影院-->再按照多用户购买一个影院的逻辑走
 * 3.加上票数 和 价钱 （打折/优惠券等等）
 */
public class HappyCinemaImprove {
    public static void main(String[] args) throws InterruptedException {

        //可用位置添加
        ArrayList<Integer> available = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            available.add(i);
        }
        HappyCinema happyCinema = new HappyCinema(available, "快乐影院");

        ArrayList<Integer> seats1 = new ArrayList<>();
        seats1.add(1);
        seats1.add(2);
        ArrayList<Integer> seats2 = new ArrayList<>();
        seats2.add(4);
        seats2.add(5);
        seats2.add(6);
        ArrayList<Integer> seats3 = new ArrayList<>();
        seats3.add(7);
        seats3.add(8);
        ArrayList<Integer> seats4 = new ArrayList<>();
        seats4.add(3);
        seats4.add(9);
        ArrayList<Integer> seats5 = new ArrayList<>();
        seats5.add(10);
        seats5.add(9);


        new Thread(new HappyCustomer(happyCinema, seats2), "Leo").start();
        new Thread(new HappyCustomer(happyCinema, seats3), "Kevin").start();
        new Thread(new HappyCustomer(happyCinema, seats1), "Alice").start();
        new Thread(new HappyCustomer(happyCinema, seats4), "Jelena").start();

        Thread.sleep(1000);
        new Thread(new HappyCustomer(happyCinema, seats5), "Jane").start();
    }
}


/**
 * 顾客
 */
class HappyCustomer implements Runnable {

    private HappyCinema cinema;

    private List<Integer> seats;

    private final static double price = 28.0;

    @Override
    public void run() {
        // 双重检验锁
        if (cinema.getAvailable().size() == 0) {
            System.out.println("当前无剩余票数");
            return;
        }
        // 加入同步锁
        synchronized (cinema) {
            if (cinema.getAvailable().size() == 0) {
                System.out.println("当前无剩余票数");
                return;
            }
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功！"
                        + Thread.currentThread().getName() + "购买了" + seats.size() + "张,"
                        + "选择的位置是：" + seats
                        + "  此次消费共：" + (seats.size() * price) + "元"
                        + "  \n当前剩余的位置：" + cinema.getAvailable());
            } else {
                System.out.println("出票失败！"
                        + Thread.currentThread().getName()
                        + "选择的位置是：" + seats
                        + "  当前剩余的位置：" + cinema.getAvailable());
            }
        }

    }

    public HappyCustomer(HappyCinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }
}

/**
 * 影院
 */
class HappyCinema {

    /**
     * 可用的位置
     */
    private List<Integer> available;

    private String name;

    public HappyCinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public List<Integer> getAvailable() {
        return available;
    }

    /**
     * 购票
     *
     * @param seats
     * @return
     */
    public boolean bookTickets(List<Integer> seats) {
        System.out.println("目前可选择的座位是：" + available);

        List<Integer> copy = new ArrayList<>(available);

        // 除掉购票数
        copy.removeAll(seats);
        // 判断大小
        if ((available.size() - copy.size()) != seats.size()) {
            return false;
        }

        // 成功
        available = copy;
        return true;
    }
}
