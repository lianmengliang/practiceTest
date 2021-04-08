package com.example.utils.Weather;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * @Author ： Leo
 * @Date : 2020/11/4 16:14
 * @Desc:
 */
public class WeatherCheckUtil {
    private static final String oneWeekJson = "{\n" +
            "    \"ret\": \"ok\",\n" +
            "    \"code\": 330110,\n" +
            "    \"province\": \"浙江省\",\n" +
            "    \"city\": \"杭州市\",\n" +
            "    \"area\": \"余杭区\",\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"date\": \"2020-11-04\",\n" +
            "            \"week\": \"星期三\",\n" +
            "            \"dayIcon\": \"https://cache.ip138.com/user/image/tianqi/d00.png\",\n" +
            "            \"nightIcon\": \"https://cache.ip138.com/user/image/tianqi/n01.png\",\n" +
            "            \"observer\": \"晴转多云\",\n" +
            "            \"tempHigh\": \"18\",\n" +
            "            \"tempLow\": \"11\",\n" +
            "            \"wind\": \"4-5级转3-4级\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"date\": \"2020-11-05\",\n" +
            "            \"week\": \"星期四\",\n" +
            "            \"dayIcon\": \"https://cache.ip138.com/user/image/tianqi/d01.png\",\n" +
            "            \"nightIcon\": \"https://cache.ip138.com/user/image/tianqi/n00.png\",\n" +
            "            \"observer\": \"多云转晴\",\n" +
            "            \"tempHigh\": \"21\",\n" +
            "            \"tempLow\": \"14\",\n" +
            "            \"wind\": \"4-5级\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"date\": \"2020-11-06\",\n" +
            "            \"week\": \"星期五\",\n" +
            "            \"dayIcon\": \"https://cache.ip138.com/user/image/tianqi/d01.png\",\n" +
            "            \"nightIcon\": \"https://cache.ip138.com/user/image/tianqi/n01.png\",\n" +
            "            \"observer\": \"多云\",\n" +
            "            \"tempHigh\": \"23\",\n" +
            "            \"tempLow\": \"14\",\n" +
            "            \"wind\": \"3-4级转<3级\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"date\": \"2020-11-07\",\n" +
            "            \"week\": \"星期六\",\n" +
            "            \"dayIcon\": \"https://cache.ip138.com/user/image/tianqi/d01.png\",\n" +
            "            \"nightIcon\": \"https://cache.ip138.com/user/image/tianqi/n01.png\",\n" +
            "            \"observer\": \"多云\",\n" +
            "            \"tempHigh\": \"22\",\n" +
            "            \"tempLow\": \"12\",\n" +
            "            \"wind\": \"3-4级转<3级\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"date\": \"2020-11-08\",\n" +
            "            \"week\": \"星期日\",\n" +
            "            \"dayIcon\": \"https://cache.ip138.com/user/image/tianqi/d00.png\",\n" +
            "            \"nightIcon\": \"https://cache.ip138.com/user/image/tianqi/n00.png\",\n" +
            "            \"observer\": \"晴\",\n" +
            "            \"tempHigh\": \"21\",\n" +
            "            \"tempLow\": \"11\",\n" +
            "            \"wind\": \"4-5级转3-4级\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"date\": \"2020-11-09\",\n" +
            "            \"week\": \"星期一\",\n" +
            "            \"dayIcon\": \"https://cache.ip138.com/user/image/tianqi/d00.png\",\n" +
            "            \"nightIcon\": \"https://cache.ip138.com/user/image/tianqi/n00.png\",\n" +
            "            \"observer\": \"晴\",\n" +
            "            \"tempHigh\": \"19\",\n" +
            "            \"tempLow\": \"10\",\n" +
            "            \"wind\": \"4-5级转<3级\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"date\": \"2020-11-10\",\n" +
            "            \"week\": \"星期二\",\n" +
            "            \"dayIcon\": \"https://cache.ip138.com/user/image/tianqi/d00.png\",\n" +
            "            \"nightIcon\": \"https://cache.ip138.com/user/image/tianqi/n00.png\",\n" +
            "            \"observer\": \"晴\",\n" +
            "            \"tempHigh\": \"19\",\n" +
            "            \"tempLow\": \"11\",\n" +
            "            \"wind\": \"4-5级\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    private static final String oneDayJson = "{\n" +
            "    \"ret\": \"ok\",\n" +
            "    \"code\": 330110,\n" +
            "    \"province\": \"浙江省\",\n" +
            "    \"city\": \"杭州市\",\n" +
            "    \"area\": \"余杭区\",\n" +
            "    \"data\": {\n" +
            "        \"time\": \"2020-11-04 15:40\",\n" +
            "        \"dayIcon\": \"https://cache.ip138.com/user/image/tianqi/d00.png\",\n" +
            "        \"dayWeather\": \"晴\",\n" +
            "        \"dayTemp\": \"18\",\n" +
            "        \"dayWind\": \"4-5级\",\n" +
            "        \"nightIcon\": \"https://cache.ip138.com/user/image/tianqi/n01.png\",\n" +
            "        \"nightWeather\": \"多云\",\n" +
            "        \"nightTemp\": \"11\",\n" +
            "        \"nightWind\": \"3-4级\",\n" +
            "        \"temp\": \"18\",\n" +
            "        \"Icon\": \"https://cache.ip138.com/user/image/tianqi/d00.png\",\n" +
            "        \"observer\": \"晴\",\n" +
            "        \"wind\": \"东北风1级\",\n" +
            "        \"humidity\": \"49\",\n" +
            "        \"pm25\": \"\"\n" +
            "    }\n" +
            "}";

    private static final String WEATHER_TOKEN = "efd6111b0d6b81c25ee97a07a219f04e";

    private static final String WEATHER_URL = "https://api.ip138.com/observer/?code=%s&type=%s&token=%s";

//    private static final String ERROR_MSG = "行政区划代码code有误";

    private static final String ERROR_MSG = "行政区划代码code无效";


    /**
     * 获取某一区域天气情况
     * @param code ： 行政区划代码
     * @param type ：（1: 当日天气， 7：本周内天气）
     * @return
     */
    private static Object getWeatherResult(String code, Integer type) {

        RestTemplate restTemplate = new RestTemplate();

        String requestUrl = String.format(WEATHER_URL, code, type, WEATHER_TOKEN);

        String res = restTemplate.getForObject(requestUrl, String.class);
        JSONObject jsonObject = JSONObject.parseObject(res, JSONObject.class);

        if ("ok".equals(jsonObject.get("ret").toString())&& !jsonObject.get("city").toString().isEmpty()) {

            // 结果是 当日天气 预报
            if (type == 1) {
                String data = jsonObject.get("data").toString();

                OneDayWeather oneDayWeather = JSON.parseObject(data, OneDayWeather.class);

                if (oneDayWeather != null){
                    System.out.println("当日天气 ------------" );
                    System.out.println(oneDayWeather);
                    return oneDayWeather ;
                }
            }

            // 结果是一周内天气预报
            if (type == 7) {
                ArrayList<OneWeekWeather> weatherArrayList = new ArrayList<>();
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (Object object : jsonArray) {
                    String s = object.toString();
                    OneWeekWeather oneWeekWeather = JSON.parseObject(s, OneWeekWeather.class);
                    if (oneWeekWeather != null) {
                        weatherArrayList.add(oneWeekWeather);
                    }

                }

                if (null != weatherArrayList && !weatherArrayList.isEmpty()){

                    for (OneWeekWeather oneWeekWeather : weatherArrayList) {
                        System.out.println("本周内天气 ------------" );
                        System.out.println(oneWeekWeather);
                    }
                    return weatherArrayList;
                }

            }
        }


        return ERROR_MSG;
    }


    /**
     * 获取当日天气预报
     * @param json
     */
    private static void getOneDayWeather(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        if ("ok".equals(jsonObject.get("ret").toString())&&!jsonObject.get("city").toString().isEmpty()) {

            String data = jsonObject.get("data").toString();

            OneDayWeather dayWeather = JSON.parseObject(data, OneDayWeather.class);

            if (dayWeather != null) {
                System.out.println(dayWeather);
            }

        }

    }

    /**
     * 获取本周内天气预报
     * @param json
     */
    private static void getOneWeekWeather(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println("jsonObject"+jsonObject);
        if ("ok".equals(jsonObject.get("ret").toString())&&!jsonObject.get("city").toString().isEmpty()) {
            JSONArray data = jsonObject.getJSONArray("data");

            ArrayList<OneWeekWeather> weekWeatherList = new ArrayList<>();

            for (Object object : data) {
                String s = object.toString();
                OneWeekWeather weekWeather = JSONObject.parseObject(s, OneWeekWeather.class);
                if (weekWeather != null) {
                    weekWeatherList.add(weekWeather);
                }
            }
            if (null != weekWeatherList && !weekWeatherList.isEmpty()) {
                for (OneWeekWeather oneWeekWeather : weekWeatherList) {
//                    return oneWeekWeather
                    System.out.println(oneWeekWeather);
                }
            } else {
                System.out.println("行政区划代码有误");
            }


        }


    }

    public static void main(String[] args) {

        String code = "330110";

        /**
         * 查询一天天气预报
         */
//        getOneDayWeather(oneDayJson);

        /**
         * 查询一周天气预报
         */
//        getOneWeekWeather(oneWeekJson);


        /**
         * 查询天气情况
         */
        Object weatherResult = getWeatherResult("23123123121", 7);
        System.out.println("oneDayWeather---"+weatherResult);
    }

}
