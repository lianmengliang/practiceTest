package com.example.utils.Weather;

import lombok.Data;

import java.util.Date;

/**
 * @Author ： Leo
 * @Date : 2020/11/4 16:44
 * @Desc:
 */
@Data
public class OneDayWeather {
    //更新时间
    private Date time ;

    //白天天气图标
    private String dayIcon;
    //白天天气
    private String dayWeather;
    //白天温度
    private String dayTemp;
    //白天风力
    private String dayWind;

    //夜晚天气图标
    private String nightIcon;
    //夜晚天气
    private String nightWeather;
    //夜晚温度
    private String nightTemp;
    //夜晚风力
    private String nightWind;

    //实时温度
    private String temp;
    //天气图标
    private String Icon;
    //实时天气
    private String weather;
    //实时风力
    private String wind;

    //湿度
    private String humidity;
    //pm2.5
    private String pm25;
}
