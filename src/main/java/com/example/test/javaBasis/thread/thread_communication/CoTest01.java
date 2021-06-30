package com.example.test.javaBasis.thread.thread_communication;



/**
 * @Author ： Leo
 * @Date : 2021/6/30 16:55
 * @Desc: 线程通信
 * <p>
 * 协作模型: 生产者与 消费者实现方式一： 管程法，（解耦，提高效率）
 * 借助 缓冲区实现
 *
 * 拓展： 比如馒头的种类可以多样化 + 商家多样化  （本案例采用的是一家商铺和一种馒头）
 *
 * 馒头的种类： 比如 高粱面。糯米面，小麦面等等， 哪种缺了生产哪种
 * 不同的线程可以用工厂模式解决，不同的面粉使用工厂创建不同的线程去生产。
 *
 * 多个商家： 也可采用工厂模式解决
 *
 */
public class CoTest01 {
    public static void main(String[] args) {

        // 创建缓冲区
        BufferArea container = new BufferArea(100);

        new Productor(container).start();
        new Consumer(container).start();

    }
}


/**
 * //生产者
 */
class Productor extends Thread {
    private BufferArea container;

    public Productor(BufferArea container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产-> 第" + i + "个馒头");
            container.push(new Steamedbun(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 * //消费者
 */
class Consumer extends Thread {

    private BufferArea container;

    public Consumer(BufferArea container) {
        this.container = container;
    }

    @Override
    public void run() {
        /**
         * 消费
         */
        for (int i = 0; i < 100; i++) {
            System.out.println("消费-> 第" + container.pop().getId() + "个馒头");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


/**
 * //缓冲区
 */
class BufferArea {
    /**
     * 缓存馒头
     */
//    Steamedbun[] buns = new Steamedbun[10];
    private Steamedbun[] buns;

    /**
     * 缓冲区 最多放多少个馒头
     *
     * @param lenth
     */
    public BufferArea(int lenth) {
        buns = new Steamedbun[lenth];
    }

    /**
     * 用于计数
     */
    private int count;

    /**
     * 存储馒头：生产
     */
    public synchronized void push(Steamedbun bun) {
        // 何时可以生产,容器存在空间
        // 何时不能生产,容器不存在空间
        if (count == buns.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count] = bun;
        count++;
        // 存在数据了，可以通知消费了
        this.notifyAll();
    }

    /**
     * 获取取馒头 : 消费
     */
    public synchronized Steamedbun pop() {
        // 何时消费：容器里是否存在数据
        // 没有数据时，只有等待
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Steamedbun bun = buns[count];
        // 消费了，存在空间了，就可以通知生产了
        // 所有的等待都会被唤醒
        this.notifyAll();
        return bun;
    }

}


/**
 * //馒头
 */
class Steamedbun {

    private int id;

    public Steamedbun(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}