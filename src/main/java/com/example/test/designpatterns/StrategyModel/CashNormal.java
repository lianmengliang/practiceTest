package com.example.test.designpatterns.StrategyModel;

/**
 * @Author ： Leo
 * @Date : 2020/8/10 16:20
 * @Desc:
 */

/**
 * 正常收费子类
 */
public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money ;
    }
}
