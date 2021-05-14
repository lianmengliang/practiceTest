package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.domain.IpAddress;
import com.example.domain.Student;
import com.example.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;

/**
 * @Author ： leo
 * @Date :2020/3/16 10:09
 * @Desc: 测试json字符串
 */
public class testJson {

    private static final String TEST_STR = "{\n" +
            "\"adid\": 6000,\n" +
            "\"dataparseconfig\": \"{\\n\\t\\\"merid\\\": \\\"$.data.uid\\\",\\n\\t\\\"mername\\\": \\\"$.data.nickname\\\",\\n\\t\\\"deviceid\\\": \\\"$.data.imei\\\",\\n\\t\\\"newuser\\\": \\\"$.data.newuser\\\",\\n\\t\\\"activate\\\": \\\"$.data.can_activate\\\",\\n\\t\\\"newuserValue\\\": 1,\\n\\t\\\"activateValue\\\": 1\\n}\",\n" +
            "\"h5keycode\": \"kb1485[merid]e434d61a386f4cd3150db2c595525df3\",\n" +
            "\"h5pageurl\": \"https://fish-api.4gqp.com/Verifypos\",\n" +
            "\"h5params\": \"?channel=kb1485&uid=[merid]&sign=[keycode]\",\n" +
            "\"islog\": 1,\n" +
            "\"isupper\": 0,\n" +
            "\"itime\": 1587025040000,\n" +
            "\"keycode\": \"kb1485[OaidDeviceID]e434d61a386f4cd3150db2c595525df3\",\n" +
            "\"method\": \"GET\",\n" +
            "\"note\": \"麦游H5激活\",\n" +
            "\"operator\": \"超级管理员\",\n" +
            "\"params\": \"?imei=[OaidDeviceID]&channel=kb1485&sign=[keycode]&version=2&os=1\",\n" +
            "\"status\": 0,\n" +
            "\"successfield\": \"status\",\n" +
            "\"successvalue\": \"1\",\n" +
            "\"url\": \"http://fish-api.4gqp.com/Cpl/reginfoimei\"\n" +
            "}";
    private static final String TEST_STR1 = "{\n" +
            "    \"adid\":6000,\n" +
            "    \"h5keycode\":\"kb1485[merid]e434d61a386f4cd3150db2c595525df3\",\n" +
            "    \"h5pageurl\":\"https://fish-api.4gqp.com/Verifypos\",\n" +
            "    \"h5params\":\"?channel=kb1485&uid=[merid]&sign=[keycode]\",\n" +
            "    \"islog\":1,\n" +
            "    \"isupper\":0,\n" +
            "    \"itime\":1587025040000,\n" +
            "    \"keycode\":\"kb1485[OaidDeviceID]e434d61a386f4cd3150db2c595525df3\",\n" +
            "    \"method\":\"GET\",\n" +
            "    \"note\":\"麦游H5激活\",\n" +
            "    \"operator\":\"超级管理员\",\n" +
            "    \"params\":\"?imei=[OaidDeviceID]&channel=kb1485&sign=[keycode]&version=2&os=1\",\n" +
            "    \"status\":0,\n" +
            "    \"successfield\":\"status\",\n" +
            "    \"successvalue\":\"1\",\n" +
            "    \"url\":\"http://fish-api.4gqp.com/Cpl/reginfoimei\"\n" +
            "}";

    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {

        JSONObject jsonObject1 = JSON.parseObject(TEST_STR1);
        System.out.println(jsonObject1);

        JSONObject jsonObject = JSON.parseObject(TEST_STR);
        System.out.println(jsonObject);


        /*String a = "hello xiqu";

        String jsonDemo = "{\"locationInfo\":[{\"ret\":\"ok\", \"data\":[{\"zip\":\"321000\", \"country\":\"中国\", \"city\":\"金华\", \"zone\":\"0579\", \"district\":\"\", \"isp\":\"移动\", \"region\":\"浙江\"} ], \"ip\":\"112.17.25.148\"} ] }";
        testJson(jsonDemo);*/

        /*String json = "" +
                "\"{\n" +
                "\t\\\"locationInfo\\\":[\n" +
                "\t\t{\n" +
                "\t\t\t\\\"ret\\\":\\\"ok\\\",\n" +
                "\t\t\t\\\"data\\\":[\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\\\"zip\\\":\\\"321000\\\",\n" +
                "\t\t\t\t\t\\\"country\\\":\\\"中国\\\",\n" +
                "\t\t\t\t\t\\\"city\\\":\\\"金华\\\",\n" +
                "\t\t\t\t\t\\\"zone\\\":\\\"0579\\\",\n" +
                "\t\t\t\t\t\\\"district\\\":\\\"\\\",\n" +
                "\t\t\t\t\t\\\"isp\\\":\\\\\"移动\\\",\n" +
                "\t\t\t\t\t\\\"region\\\":\\\"浙江\\\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\\\"ip\\\":\\\"112.17.25.148\\\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}\"";
*/

    }

    public static void testJson(String json) {

        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println("jsonObject--" + jsonObject);

        String locationInfo = jsonObject.getJSONArray("locationInfo").toJSONString();
        System.out.println("locationInfo--" + locationInfo);


        JSONObject dataJsonObject = jsonObject.getJSONArray("locationInfo").getJSONObject(0);
        System.out.println("dataJsonObject--" + dataJsonObject);

        JSONObject object = dataJsonObject.getJSONArray("data").getJSONObject(0);
        System.out.println("object--" + object);


        //FuluResponse response = JSON.parseObject(res, FuluResponse.class);
        String string = object.toString();
        System.out.println(string);

        IpAddress ipAddress = JSON.parseObject(string, IpAddress.class);
        System.out.println(ipAddress);

        String s = jsonObject.getJSONArray("locationInfo")
                .getJSONObject(0)
                .getJSONArray("data")
                .getJSONObject(0).toString();
        IpAddress ipAddress1 = JSON.parseObject(s, IpAddress.class);


        System.out.println(ipAddress1);
        /*JSONArray data = JSON.parseObject(locationInfo)
                .getJSONArray("data");
        System.out.println("data--"+data);
        */


/*
        JSONObject object = JSON.parseObject(jsonString);
        System.out.println(object);
*/
        //System.out.println(jsonobj.getJSONObject("sysProperty").getString("dataTimestamp"));

    }

    public static void getJson() {


        User user = new User();

        user.setId(1);
        user.setPassWord("123");
        user.setRealName("leo");
        user.setUserName("lml");


        ObjectMapper objectMapper = new ObjectMapper();


        Label message = new Label("hello,java");
        String text = message.getText();
        System.out.println(text);

        Font font = new Font("text", 12, 12);

        message.setFont(font);
        System.out.println(message);

    /*   System.out.println(json);

        Student student = objectMapper.readValue(json, Student.class);

        System.out.println(student);*/


    }
}
