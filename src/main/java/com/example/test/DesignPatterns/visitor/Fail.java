package com.example.test.DesignPatterns.visitor;

/**
 * @Author ： Leo
 * @Date : 2021/4/7 17:59
 * @Desc:
 */
public class Fail extends Action {
    @Override
    void getManResult(Man man) {
        System.out.println("男性给的评价是很失败的");
    }

    @Override
    void getWemanResult(Weman weman) {
        System.out.println("女性给的评价是很失败的");
    }
}
