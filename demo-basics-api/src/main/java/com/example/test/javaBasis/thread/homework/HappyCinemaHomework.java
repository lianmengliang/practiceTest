package com.example.test.javaBasis.thread.homework;

/**
 * @Author ： Leo
 * @Date : 2021/6/28 18:28
 * @Desc:
 */
public class HappyCinemaHomework {
    public static void main(String[] args) {

        Cinema cinema = new Cinema(10, "阿里影业");

       /* new Thread(new Customer(cinema, 4), "1").start();
        new Thread(new Customer(cinema, 5), "2").start();*/
        new Thread(new Customer(cinema, 1), "Leo").start();
        new Thread(new Customer(cinema, 1), "Kevin").start();
        new Thread(new Customer(cinema, 1), "Alice").start();

    }
}


/**
 * 顾客
 */
class Customer implements Runnable {

    private Cinema cinema;
    private int seats;

    @Override
    public void run() {
        // 加入同步锁
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功！" + Thread.currentThread().getName() +
                        "选择的位置个数：" + seats + "个");

            } else {
                System.out.println("出票失败");
            }
        }

    }

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }
}

/**
 * 影院
 */
class Cinema {

    /**
     * 可用的位置
     */
    private int available;

    private String name;

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }


    /**
     * 购票
     *
     * @param seats
     * @return
     */
    public boolean bookTickets(int seats) {
        System.out.println("可用的位置个数为：" + available + "个");
        if (seats > available) {
            return false;
        }
        available -= seats;
        return true;
    }
}
