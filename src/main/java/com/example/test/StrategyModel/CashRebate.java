package com.example.test.StrategyModel;

/**
 * @Author ： Leo
 * @Date : 2020/8/10 16:22
 * @Desc:
 */

/**
 * 打折收费子类
 */
public class CashRebate extends CashSuper {

    private double moneyRebate = 1.0 ;

    public CashRebate (String moneyRebate){
        this.moneyRebate = Double.parseDouble(moneyRebate);
    }


    @Override
    public double acceptCash(double money) {
       return money*moneyRebate ;
    }

}
