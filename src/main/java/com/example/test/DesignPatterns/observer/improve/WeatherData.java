package com.example.test.DesignPatterns.observer;

/**
 * @Author ： Leo
 * @Date : 2021/4/8 17:36
 * @Desc:
 * 核心类：
 * 1.包含最新的天气情况信息
 * 2.含有CurrentCondition对象
 * 3.当数据有更新时，就主动的调用。
 * *CurrentConditions对象update方法(含 display),这样他们(接入方)就看到最新的信息
 */
public class WeatherData {

    private float temperatrue;

    private float pressure;

    private float humidity;

    private CurrentConditions currentConditions;

    /**
     * 假如新的第三方
     * @param currentConditions
     */
    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }


    public void dataChange(){
        // 调用接入方的 update
        currentConditions.update(getTemperatrue(),getPressure(),getHumidity());
    }

    /**
     * 当数据有更新时，就调用setData
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
