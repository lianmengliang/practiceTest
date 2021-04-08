package com.example.test.DesignPatterns.visitor;

/**
 * @Author ： Leo
 * @Date : 2021/4/7 17:57
 * @Desc:
 */
public class Success extends Action {
    @Override
    void getManResult(Man man) {
        System.out.println("男性给的评价是很成功的");
    }

    @Override
    void getWemanResult(Weman weman) {
        System.out.println("女性给的评价是很成功的");
    }
}