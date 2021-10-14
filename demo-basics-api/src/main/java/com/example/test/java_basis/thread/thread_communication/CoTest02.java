package com.example.test.java_basis.thread.thread_communication;



/**
 * @Author ： Leo
 * @Date : 2021/6/30 16:55
 * @Desc: 线程通信
 * <p>
 * 协作模型: 生产者与 消费者实现方式二： 信号灯法，（解耦，提高效率）
 * 借助 boolean: 进行切换
 *
 */
public class CoTest02 {
    public static void main(String[] args) {

        TV tv = new TV();

        new Player(tv).start();
        new Watcher(tv).start();


    }
}


/**
 * //生产者：演员
 */
class Player  extends Thread{
    private TV tv;


    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        // 表演
        for (int i = 0; i < 20; i++) {
            if (i % 2 ==0){
                this.tv.play("奇葩说 --->" + i);
            }else{
                this.tv.play("辩论上了头，喝瓶王老吉 去去火 --->" + i);
            }
        }

    }
}


/**
 * 消费者：观众
 */
class Watcher extends Thread {

    private TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        // 观看
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }

    }
}


/**
 * 同一个资源：电视
 */
class TV {

    private String program;

    /**
     * 信号灯：
     * T: 表示演员表演 观众等待
     * F: 表示观众观看 演员等待
     */
    private boolean flag = true;

    /**
     * 表演 过程
     * @param program
     */
    public synchronized void play(String program){
        // 控制表演： 演员等待
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了：" + program);
        this.program = program;
        // 唤醒
        this.notifyAll();
        // 切换标志
        this.flag = !this.flag;
    }

    /**
     * 观看过程
     */
    public synchronized void watch(){

        // 控制观看: 观众观看过程
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了："+program);
        // 唤醒
        this.notifyAll();
        // 切换： 红绿灯
        this.flag = !this.flag;
    }

}


