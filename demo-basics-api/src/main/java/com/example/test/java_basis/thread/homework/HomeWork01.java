package com.example.test.java_basis.thread.homework;

/**
 * @Author ： Leo
 * @Date : 2021/6/24 18:09
 * @Desc:
 */
public class HomeWork01 {
    public static void main(String[] args) {

       /* A a = new A();
        new Thread(a).start();
        new Thread(a).start();*/


        B b = new B();
        new Thread(b).start();
        new Thread(b).start();
    }
}


class A implements Runnable {

    private int money = 2000;

    private boolean loop = true;

    public synchronized void withdrawMoney() {

        if (money < 100) {
            loop = false;
            System.out.println("卡内余额不足...");
            return;
        }
        money -= 100;
        System.out.println(Thread.currentThread().getName() + "线程取走100元，余额为" + money + "元");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while (loop) {
            withdrawMoney();
        }


    }
}


class B implements Runnable {

    private int money = 2000;

    private boolean loop = true;

    @Override
    public void run() {

        while (loop) {

            //解读
            //1. 这里使用 synchronized 实现了线程同步
            //2. 当多个线程执行到这里时，就会去争夺 this对象锁
            //3. 哪个线程争夺到(获取)this对象锁，就执行 synchronized 代码块, 执行完后，会释放this对象锁
            //4. 争夺不到this对象锁，就blocked ，准备继续争夺
            //5. this对象锁是非公平锁.
            synchronized (this){
                if (money < 100) {
                    loop = false;
                    System.out.println("余额不足...");
                    return;
                }
                money -= 100;
                System.out.println(Thread.currentThread().getName() + "线程取走100元，余额为" + money + "元");
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}