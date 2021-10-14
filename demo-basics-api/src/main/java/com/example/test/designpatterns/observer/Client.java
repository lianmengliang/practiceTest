package com.example.test.designpatterns.observer;

import java.util.Observable;

/**
 * @Author ： Leo
 * @Date : 2021/4/8 17:36
 * @Desc:
 */
public class Client extends Observable {
    public static void main(String[] args) {

        // 创建第三接入方
        CurrentConditions conditions = new CurrentConditions();

        // 创建WeatherDATA并将 接入方currentCondition传递到WeatherData中
        WeatherData weatherData = new WeatherData(conditions);

        // 更新天气
        weatherData.setData(30, 150, 40);

        // 天气情况变化
        System.out.println("========天气情况变化=======");
        weatherData.setData(40, 160, 20);

    }


    public void test() {
        Client client = new Client();
        client.notify();
    }
}
