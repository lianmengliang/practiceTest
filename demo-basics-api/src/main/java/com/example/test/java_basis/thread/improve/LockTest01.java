package com.example.test.java_basis.thread.improve;

/**
 * @Author ： Leo
 * @Date : 2021/7/1 15:55
 * @Desc: <p>
 * 不可重入锁： 锁不可以延续使用
 */
public class LockTest01 {
    UnReenLock lock = new UnReenLock();

    public void a() throws InterruptedException {
        lock.lock();
        doSth();
        lock.unlock();
    }

    // 不可重入
    private void doSth() throws InterruptedException {
        lock.lock();
        //。。。。。
        System.out.println("--------");
        lock.unlock();
    }


    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        LockTest01 test01 = new LockTest01();
        test01.a();
        test01.doSth();

    }
}

class UnReenLock {

    /**
     * 是否被占用
     */

    private boolean isLocked = false;


    /**
     * //使用锁
     *
     * @throws InterruptedException
     */
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            System.out.println("等待");
            wait();
        }
    }

    /**
     * 释放锁
     */
    public synchronized void unlock() {
        isLocked = true;
        System.out.println("释放锁");
        notify();
    }

}