package com.example.utils.Weather;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.Value;

/**
 * @Author ： Leo
 * @Date : 2020/11/4 16:14
 * @Desc:
 */

@Data
public class WeatherResponse {

    @JSONField(name="ret")  //状态码
    private String ret;

    @JSONField(name="code") //邮政编码
    private Integer code;

    @JSONField(name="province") //省份
    private String province;

    @JSONField(name="city")   // 市区
    private String city;

    @JSONField(name="area")   //区域
    private String area;

    @JSONField(name="data")   //data 具体天气信息
    private Object data;


    @Data
    private static class OneDayWeather{

        public OneDayWeather() {
            super();
        }


    }


    @Data
    private static class OneWeekWeather{

    }

}


