package com.example.test.designpatterns.absfactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 12:01
 * @Desc:
 */
public class PizzaStore {
    public static void main(String[] args) {

        // 1.依赖接口 传递方式 实现
        OrderPizza orderPizza = new OrderPizza();
        String area = getArea();
        if(area.equals("001")){
            BJFactory bjFactory = new BJFactory();
            orderPizza.orderPizza(bjFactory);
        }else if(area.equals("002")){
            LDFactory ldFactory = new LDFactory();
            orderPizza.orderPizza(ldFactory);
        }else{
            System.out.println("输入地区有误，请重新输入 选择北京001或伦敦002");
        }


        //2.构造器 方式实现
        // 伦敦pizza
       /* new OrderPizza(new LDFactory());
        // 北京地区pizza
        new OrderPizza(new LDFactory());*/
    }

    /**
     * 获取地区
     *
     * @return
     */
    private static String getArea() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入地区代码: ‘001:北京’或‘002:伦敦’");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
