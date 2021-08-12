package com.example.test.javaBasis.thread.multithreading;

/**
 * @Author ： Leo
 * @Date : 2021/6/23 11:45
 * @Desc:
 */
public class MultithreadingDemo {
    public static void main(String[] args) {

        T1 t1 = new T1();
        t1.start();

        T2 t2 = new T2();
        Thread thread = new Thread(t2);
        thread.start();


    }
}


class T1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(i + " Hello,World!" + "-" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class T2 implements Runnable {
    @Override
    public void run() {

        int count = 0;
        while (true) {
            System.out.println((++count) + " Hello,World!" + "-" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 30) {
                break;
            }

        }

    }
}