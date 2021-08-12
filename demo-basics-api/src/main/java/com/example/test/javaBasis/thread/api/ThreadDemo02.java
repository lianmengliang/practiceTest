package com.example.test.javaBasis.thread.api;

/**
 * @Author ： Leo
 * @Date : 2021/6/23 16:46
 * @Desc: 守护线程
 */
public class ThreadDemo02 {
    public static void main(String[] args) throws InterruptedException {
        T4 t = new T4();

        System.out.println(t.getName() + " 状态 " + t.getState());
        t.start();

        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + " 状态 " + t.getState());
            Thread.sleep(500);
        }

        System.out.println(t.getName() + " 状态 " + t.getState());

    }
}


class T4 extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }

    }

}