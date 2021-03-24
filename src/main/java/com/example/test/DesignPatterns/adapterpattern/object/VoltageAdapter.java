package com.example.test.DesignPatterns.adapterpattern.object;

/**
 * @Author ： Leo
 * @Date : 2021/3/23 17:01
 * @Desc:
 */
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if(null !=voltage220V ){
            // 获取220的电压
            int srcV = voltage220V.output220V();
            System.out.println("使用对象适配器，进行适配。。。");
            dst = srcV / 44; // 转成5V
        }

        return dst;
    }

}
