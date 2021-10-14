package com.example.test.java_basis.thread.improve;

/**
 * @Author ： Leo
 * @Date : 2021/7/1 15:55
 * @Desc: 可重入锁 ： 锁可以延续使用 + 计算器  （new ReentrantLock();）
 * <p>
 * 不可重入锁： 锁不可以延续使用
 */
public class LockTest {

    public void test() {
        // 第一次获得同样的锁
        synchronized (this) {
            while (true) {
                // 第二次获得同样的锁
                synchronized (this) {
                    System.out.println("ReentrantLock !");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        // 可重入锁的调用
        lockTest.test();
    }
}
