package com.example.test.designpatterns.visitor;

/**
 * @Author ： Leo
 * @Date : 2021/4/7 18:38
 * @Desc:
 */
public class Wait extends Action {
    @Override
    void getManResult(Man man) {
        System.out.println("男性给的评价是待定");
    }

    @Override
    void getWomanResult(Woman woman) {
        System.out.println("女性给的评价是待定");
    }
}
