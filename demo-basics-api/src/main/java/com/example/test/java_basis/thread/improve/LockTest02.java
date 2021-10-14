package com.example.test.java_basis.thread.improve;

/**
 * @Author ： Leo
 * @Date : 2021/7/1 15:55
 * @Desc: <p>
 * 可重入锁： 锁可以延续使用 + 计数器
 */
public class LockTest02 {
    ReenLock lock = new ReenLock();
//    ReentrantLock lock = new ReentrantLock();

    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSth();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    // 可重入
    private void doSth() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        //。。。。。
        System.out.println("--------");
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }


    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        LockTest02 test02 = new LockTest02();
        test02.a();
        Thread.sleep(1000);
        System.out.println(test02.lock.getHoldCount());

    }
}

class ReenLock {

    /**
     * 是否被占用
     */
    private boolean isLocked = false;
    /**
     * 存储线程
     */
    private Thread lockedBy = null;

    private int holdCount = 0;

    public int getHoldCount() {
        return holdCount;
    }

    /**
     * //使用锁
     *
     * @throws InterruptedException
     */
    public synchronized void lock() throws InterruptedException {
        // 获取一个线程
        Thread t = Thread.currentThread();
        while (isLocked && lockedBy != t) {
            System.out.println("等待");
            wait();
        }
        isLocked = true;
        lockedBy = t;
        holdCount++;

    }

    /**
     * 释放锁
     */
    public synchronized void unlock() {

        // 当前线程等于自己的话 ，就释放锁
        if (Thread.currentThread() == lockedBy) {
            holdCount--;
            if (holdCount == 0) {
                isLocked = false;
                System.out.println("释放锁");
                notify();
                lockedBy = null;
            }
        }

    }

}