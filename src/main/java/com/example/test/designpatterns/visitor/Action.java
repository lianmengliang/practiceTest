package com.example.test.designpatterns.visitor;

/**
 * @Author ： Leo
 * @Date : 2021/4/7 17:51
 * @Desc:
 */
public abstract class Action {
    // 得到男性的测评
    abstract void getManResult(Man man);

    // 得到女性的测评
    abstract void getWemanResult(Weman weman);
}
