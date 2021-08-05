package com.example.test.javaBasis.thread.homework;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author ： Leo
 * @Date : 2021/6/24 16:50
 * @Desc:
 */
public class HomeWork {

    public static void main(String[] args) {
        WorkThread01 workThread01 = new WorkThread01();
        WorkThread02 workThread02 = new WorkThread02(workThread01);

        workThread02.start();
        workThread01.start();
    }
}


class WorkThread01 extends Thread {

    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {

        while (loop) {
            int random = (int) (Math.random() * 100 + 1);
            System.out.println(Thread.currentThread().getName() + "线程在打印数字 " + random);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         /*   Random random1 = new Random();
            int i = random1.nextInt(100);

            System.out.println(Thread.currentThread().getName() + "线程在打印数字 " + i);*/
        }
        System.out.println(Thread.currentThread().getName() + "线程退出...");

    }
}

class WorkThread02 extends Thread {

    private WorkThread01 workThread01;

    private Scanner scanner = new Scanner(System.in);

    public WorkThread02(WorkThread01 workThread01) {
        this.workThread01 = workThread01;
    }

    @Override
    public void run() {
        while (true) {

            System.out.println(Thread.currentThread().getName() + "线程提醒请输入Q 退出" + workThread01.getName() + "线程");
            char charAt = scanner.next().toUpperCase().charAt(0);

            if (charAt == 'Q') {
                workThread01.setLoop(false);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "线程退出...");
                break;
            }

        }


    }
}