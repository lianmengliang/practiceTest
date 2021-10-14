package com.example.test.designpatterns.facade;

/**
 * @Author ： Leo
 * @Date : 2021/10/13 18:07
 * @Desc:
 */
public abstract class TimeSleep {


     public void timeSheep(){
         for (int i = 0; i < 20; i++) {
             try {
                 Thread.sleep(200);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.print("-");
         }
     }

}
