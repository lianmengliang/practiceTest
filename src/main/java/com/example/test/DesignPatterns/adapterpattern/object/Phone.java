package com.example.test.DesignPatterns.adapterpattern.object;

/**
 * @Author ： Leo
 * @Date : 2021/3/23 16:55
 * @Desc:
 */
public class Phone {

    private final int SUITABLE_U = 5;

    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == SUITABLE_U) {
            System.out.println("电压为5V，可以充电。。。");
        } else if (iVoltage5V.output5V() > SUITABLE_U) {
            System.out.println("电压大于5V 不能充电、、、");
        }

    }
}
