package com.example.test.DesignPatterns.observer.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/8 18:46
 * @Desc:
 */
public class Baidu implements Observer {

    /**
     * 温度，气压，湿度
     */

    private float temperature;

    private float pressure;

    private float humidity;

    /**
     * 更新天气情况，是由WeatherData来调用，我是用推送模式
     *
     * @param temperature
     * @param pressure
     * @param humidity
     */
    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    /**
     * 显示
     */
    public void display() {
        System.out.println("***百度Today mTemperature:" + temperature + "***");
        System.out.println("***百度Today mPressure:" + pressure + "***");
        System.out.println("***百度Today mHumidity:" + humidity + "***");
        System.out.println("-------------------------------------------");
    }
}
