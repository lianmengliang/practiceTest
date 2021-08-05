package com.example.utils.Weather;

import lombok.Data;

import java.util.Date;

/**
 * @Author ： Leo
 * @Date : 2020/11/4 16:44
 * @Desc:
 */
@Data
public class OneWeekWeather {

    //更新时间
    private Date date ;
    //白天天气图标
    private String dayIcon;
    //星期几
    private String week;
    //夜晚天气图标
    private String nightIcon;

    //天气情况
    private String weather;
    //风力情况
    private String wind;

    //最高温
    private String tempHigh;

    //最低温
    private String tempLow;


}
