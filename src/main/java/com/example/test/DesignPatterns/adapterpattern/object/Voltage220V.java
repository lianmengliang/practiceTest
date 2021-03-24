package com.example.test.DesignPatterns.adapterpattern.object;

/**
 * @Author ： Leo
 * @Date : 2021/3/23 16:57
 * @Desc:
 */
public class Voltage220V {

    // 输出220V的电压
    public int output220V() {
        int src = 220;
        System.out.println("电压:" + src + "V");
        return src;
    }
}
