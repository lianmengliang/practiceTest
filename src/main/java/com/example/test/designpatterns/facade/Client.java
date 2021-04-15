package com.example.test.designpatterns.facade;


/**
 * @Author ： Leo
 * @Date : 2021/3/25 15:19
 * @Desc:
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {


        String s = "hello";
        String s2 = new String("hello");

        System.out.println(s.equals(s2));

        HomeTheaterFacade home = new HomeTheaterFacade();

        System.out.print("电影准备阶段");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200);
            System.out.print("-");
        }
        System.out.println();
        home.ready();
        Thread.sleep(3000);

        System.out.println("=====电影开始了======");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200);
            System.out.print("-");
        }
        System.out.println();
        home.play();
        Thread.sleep(3000);

        System.out.println("=====电影暂停======");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200);
            System.out.print("-");
        }
        System.out.println();
        home.pause();
        Thread.sleep(3000);

        System.out.println("=====电影结束了======");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200);
            System.out.print("-");
        }
        System.out.println();
        home.end();


//        Configuration


    }
}
