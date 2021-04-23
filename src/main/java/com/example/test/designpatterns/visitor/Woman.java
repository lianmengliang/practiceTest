package com.example.test.designpatterns.visitor;

/**
 * @Author ： Leo
 * @Date : 2021/4/7 17:54
 * @Desc:
 * 1. 这里我们使用到了双分派，即首先在客户端程序中，奖具体状态作为参数传递Woman中（第一次分派）
 * 2.然后woman类调用作为参数的“具体方法”中方法getWomanResult，同事将自己this作为参数传入，完成第二次分派
 *
 */
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
