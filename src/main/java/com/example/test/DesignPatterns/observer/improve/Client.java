package com.example.test.DesignPatterns.observer.improve;


/**
 * @Author ： Leo
 * @Date : 2021/4/8 17:36
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {

        // 创建一个WeatherData
        WeatherData weatherData = new WeatherData();

        // 创建一个观察者
        CurrentConditions conditions = new CurrentConditions();

        // 注册到WeatherData
        weatherData.registerObserver(conditions);

        // 测试
        System.out.println("通知各个接入方");
        weatherData.setData(10,20,60.2f);

        // 创建一个百度接入方
        Baidu baidu = new Baidu();
        weatherData.registerObserver(baidu);

        Sina sina = new Sina();
        weatherData.registerObserver(sina);

        weatherData.setData(20,30,80);
        weatherData.removeObserver(conditions);
        weatherData.dataChange();

    }
}
