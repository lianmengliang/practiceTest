package com.example.test.java_basis.thread.improve;

import java.util.*;

/**
 * @Author ： Leo
 * @Date : 2021/7/1 11:58
 * @Desc: Timer 任务调度的使用
 */
public class TimerDemo01 {
    public static void main(String[] args) {

        Timer timer = new Timer();

        // 执行安排
//        timer.schedule(new MyTask01(),1000);    //执行一次
//        timer.schedule(new MyTask01(),1000,500);    //执行多次


    }

}

class MyTask01 extends TimerTask {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("累了？困了？喝点茶缓解一下");
        }
        System.out.println("============================end======================================");
    }
}