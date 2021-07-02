package com.example.test.designpatterns.StrategyModel;

/**
 * @Author ： Leo
 * @Date : 2020/8/10 16:59
 * @Desc:
 */

/**
 * Cash 上下文
 */
public class CashContext {

    CashSuper cs = null;

    public CashContext(String type) {
        switch (type) {
            case "正常收费":
                CashNormal c0 = new CashNormal();
                cs = c0;
                break;
            case "满300返100":
                CashReturn c1 = new CashReturn("300", "100");
                cs = c1;
                break;
            case "打8折":
                CashRebate c2 = new CashRebate("0.8");
                cs = c2;
                break;
        }


    }
    public double getResult(double money){

        return cs.acceptCash(money);
    }

}
