package com.example.test.StrategyModel;

/**
 * @Author ： Leo
 * @Date : 2020/8/10 17:07
 * @Desc:
 */

/**
 * 客户端main方法
 */
public class CashClient {

    public static void main(String[] args) {

        CashContext context = new CashContext("正常收费");

        double result1 = context.getResult(300);
        System.out.println("正常收费: "+ result1);

        context = new CashContext("打8折");
        double result2 = context.getResult(300);
        System.out.println("打8折: "+result2);

        context = new CashContext("满300返100");
        double result3 = context.getResult(300);
        System.out.println("满300返100: "+result3);

        System.out.println("--------------------------------------------");

        getResult("打8折",300);
    }

    public static void getResult(String type ,double money){


        CashContext context = new CashContext(type);

        double result = context.getResult(money);
        System.out.println(type + ": "+ result);

    }
}
