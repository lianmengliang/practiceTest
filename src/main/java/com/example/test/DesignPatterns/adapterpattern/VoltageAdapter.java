package com.example.test.DesignPatterns.adapterpattern;

/**
 * @Author ： Leo
 * @Date : 2021/3/23 17:01
 * @Desc:
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        // 获取220的电压
        int srcV = output220V();
        int dstV = srcV / 44; // 转成5V

        return dstV;
    }

    /*@Override
    public int output220V() {

    }*/
}
