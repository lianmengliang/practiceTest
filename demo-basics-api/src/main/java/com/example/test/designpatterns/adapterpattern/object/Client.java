package com.example.test.designpatterns.adapterpattern.object;

/**
 * @Author ： Leo
 * @Date : 2021/3/23 16:53
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {

        System.out.println("----适配器模式----");

        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));

    }
}
