package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.domain.IpAddress;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ： Leo
 * @Date : 2020/11/4 12:14
 * @Desc:
 */
public class IPCheckUtil {

    private static final String INITIAL_URL = "http://api.ip138.com/ipv4/";

    //请求key
    private static final String IP_TOKEN = "419a9d3c203176c05f6081c703c715fd";

    private static final String format = "xml";


    public static final String REQUEST_URL = "http://api.ip138.com/ipv4/?ip=%s&datatype=xml&token=%s";

    public static final String REQUEST_URL_JSON = "http://api.ip138.com/ipv4/?ip=%s&datatype=jsonp&token=%s";


    public static IpAddress getXMLResult(String ip, Integer format){

        // format 请求返回格式： 1:json, 2:xml
        String type = "";
        if (format==1){
            type = "jsonp";
        }else {
            type = "xml";
        }

        StringBuilder builder = new StringBuilder(INITIAL_URL);
        //请求路径
        String requestUrl = builder.append("?ip=").append(ip)
                .append("&datatype=").append(type)
                .append("&token=" + IP_TOKEN).toString();
        //发送请求
        Map<String, String> map = new HashMap<>();
        String res = OkHttpUtil.requestOfGet(requestUrl, map, "");
        // 判断
        if (res.contains("ok")){
            //把xml格式转为json格式
            String jsonResponse = XmlTool.documentToJSONObject(res).toJSONString();
            //json解析
            JSONObject jsonObject = JSON.parseObject(jsonResponse);
            String s = jsonObject.getJSONArray("locationInfo")
                    .getJSONObject(0)
                    .getJSONArray("data")
                    .getJSONObject(0).toString();
            IpAddress ipAddress = JSON.parseObject(s, IpAddress.class);
            return ipAddress ;
        }
        return null ;
    }


    public static IpAddress ipAddress(String IP){
        RestTemplate restTemplate = new RestTemplate();
        String str = restTemplate.getForObject(String.format(REQUEST_URL, IP, IP_TOKEN), String.class);
        if (str.contains("ok")){
            JSONObject jsonObject = JSONObject.parseObject(XmlTool.documentToJSONObject(str).toJSONString());

            System.out.println(jsonObject);
            String s = jsonObject.getJSONArray("locationInfo")
                    .getJSONObject(0)
                    .getJSONArray("data")
                    .getJSONObject(0).toString();
            IpAddress ipAddress = JSON.parseObject(s, IpAddress.class);
            return ipAddress ;
        }
        return null;

    }

    public static void test(String ip){
        String url = String.format(REQUEST_URL_JSON, ip, IP_TOKEN);
        RestTemplate restTemplate = new RestTemplate();


        JSONObject jsonObject = restTemplate.getForObject(url,JSONObject.class);

        System.out.println(jsonObject);
    }

    public static void main(String[] args) {
//        String IP = "111.226.132.66";
        String IP = "192.168.10.93";

        System.out.println(ipAddress(IP));

//        test(IP);

       /* IpAddress ipAddress = getXMLResult(IP, 2);
        System.out.println(ipAddress);*/

    }



}
