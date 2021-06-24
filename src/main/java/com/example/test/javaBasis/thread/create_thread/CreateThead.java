package com.example.test.javaBasis.thread.create_thread;

/**
 * @Author ： Leo
 * @Date : 2021/6/22 16:13
 * @Desc: 创建 线程 的练习
 * <p>
 * # 线程使用的2种方式：
 * 1. 继承Thread类
 * 2. 实现Runable接口
 */
public class CreateThead {
    public static void main(String[] args) throws InterruptedException {

        // 创建一个Cat对象，可以当线程使用
       /* Cat cat = new Cat();
        // 启动线程 -> 最终会执行cat的run方法
        cat.start();*/

        // cat.run(); // 就是普通的方法：没有真正启动一个线程，就会把run方法执行完毕,才向下执行。 会阻塞

        Dog dog = new Dog();
        // dog.start() 这里不能调用start
        // 创建Thread对象，把dog对象（实现Runnable），放入Thread
        Thread thread = new Thread(dog);
        thread.start();

        //说明：当main线程启动一个子线程 Thread-0，主线程不会阻塞，会继续执行
        // 主线程 和 子线程 交替进行
        for (int i = 1; i <= 50; i++) {
            System.out.println("主线程 i=" + i + " 线程名称：" + Thread.currentThread().getName());
            // 休眠
            Thread.sleep(1000);
        }



    }


}

/**
 * 1.当一个类继承了 Thread类，该类就可以当做线程使用
 * 2.重写run方法，协商自己的业务代码
 * 3. run Thread类 实现了Runable接口的run方法
 */
class Cat extends Thread {

    int times = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello.你好" + " " + (++times) + " 线程名称：" + Thread.currentThread().getName());
            // 让线程休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (times == 80) {
                break;
            }
        }

    }
}

class Dog implements Runnable {

    @Override
    public void run() {
        int times = 0;
        while (true) {
            System.out.println("hi：" + (++times) + "  " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 50) {
                break;
            }
        }
    }
}