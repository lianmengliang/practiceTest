package com.example.test.DesignPatterns.observer.improve;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/4/8 17:36
 * @Desc: 核心类：
 * 1.包含最新的天气情况信息
 * 2.含有观察者集合，使用{ArrayList}管理
 * 3.当数据有更新时，就主动的调用ArrayList，
 * *通知所有接入方，获取最新的天气预报信息
 */
public class WeatherData implements Subject
{

    private float temperatrue;

    private float pressure;

    private float humidity;

    /**
     * 观察者集合
     */
    private List<Observer> observerList;

    /**
     * 假如新的第三方

     */
    public WeatherData() {
        observerList = new ArrayList<>();
    }


    public void dataChange() {
        // 调用接入方的 update
        notifyObservers();
    }

    /**
     * 当数据有更新时，就调用setData
     *
     * @param temperatrue
     * @param pressure
     * @param humidity
     */
    public void setData(float temperatrue, float pressure, float humidity) {
        this.temperatrue = temperatrue;
        this.pressure = pressure;
        this.humidity = humidity;

        // 调用dataChange，奖最新的消息推送给接入方currentConditions
        dataChange();

    }

    /**
     * 注册一个观察者
     * @param o
     */
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    /**
     * 移除一个观察者
     * @param o
     */
    @Override
    public void removeObserver(Observer o) {
        if (observerList.contains(o)){
            observerList.remove(o);

        }
    }

    /**
     * 遍历所有的观察者，并通知
     */
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observerList.size(); i++) {
            observerList.get(i).update(this.temperatrue,this.pressure,this.humidity);
        }
    }

    public float getTemperatrue() {
        return temperatrue;
    }

    public void setTemperatrue(float temperatrue) {
        this.temperatrue = temperatrue;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }


}
