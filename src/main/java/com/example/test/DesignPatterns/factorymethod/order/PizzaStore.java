package com.example.test.DesignPatterns.factorymethod.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author ： Leo
 * @Date : 2021/3/19 11:55
 * @Desc:
 */
public class PizzaStore {

    public static void main(String[] args) {

        int orderTime = 1;
        do {
            String area = getArea();
            if (area.equals("001")) {
//            北京口味
                new BJOrderPizza();
            } else if (area.equals("002")) {
//            伦敦口味
                new LDOrderPizza();
            } else if (orderTime >= 3) {
                System.out.println("输入地区代码有误超过三次，请退出重新尝试");
                break;
            } else {
                orderTime++;
                System.out.println("输入地区代码有误，请重新输入001或002");
            }
        } while (true);

    }

    /**
     * 获取 pizza地区
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
