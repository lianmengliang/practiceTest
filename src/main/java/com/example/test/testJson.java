package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.domain.IpAddress;
import com.example.domain.User;
import com.example.utils.JsonFormatUtil;
import com.fasterxml.jackson.databind.ObjectMapper;



import java.awt.*;

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

    private static final String JSON_NO = "{\"_index\":\"book_shop\",\"_type\":\"it_book\",\"_id\":\"1\",\"_score\":1.0," +
            "\"_source\":{\"name\": \"Java编程思想（第4版）\",\"author\": \"[美] Bruce Eckel\",\"category\": \"编程语言\"," +
            "\"price\": 109.0,\"publisher\": \"机械工业出版社\",\"date\": \"2007-06-01\",\"tags\": [ \"Java\", \"编程语言\" ]}}";

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {

       /* JSONObject jsonObject1 = JSON.parseObject(TEST_STR1);
        System.out.println(jsonObject1);

        JSONObject jsonObject = JSON.parseObject(TEST_STR);
        System.out.println(jsonObject);*/
        /*System.out.println(TEST_STR);*/
        System.out.println("格式化前：" + JSON_NO);
        System.out.println("------------------------------------------------------------");
        JSONObject object = JSONObject.parseObject(JSON_NO);
        String pretty = jsonStringFormat(object);
        System.out.println("SerializerFeature格式后：" + pretty);
        System.out.println("------------------------------------------------------------");
       /* String format = toPrettyFormat(JSON_NO);
        System.out.println("Format:" + format);
        System.out.println("----------------------------------------------------------------");*/
        String s = JsonFormatUtil.formatJson(JSON_NO);
        System.out.println(s);

        /*User user = new User();
        user.setId(1);
        user.setUserName("leo");
        user.setRealName("MrLian");
        user.setPassWord("123");
        System.out.println(user);
        String s = JSON.toJSONString(user);
        System.out.println(s);
        String format1 = jsonStringFormat(JSON.parseObject(s));
        System.out.println(format1);*/



    }

    /**
     * json字符串格式化输出
     *
     * @param object
     * @return
     */
    public static String jsonStringFormat(Object object) {
        return JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
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

    /**
     * 谷歌的插件： json字符串格式化-输出
     * @param json
     * @return
     */
   /* private static String toPrettyFormat(String json) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonObject);
    }*/


    public static void getJson() {

        User user = new User();
        user.setId(1);
        user.setPassWord("123");
        user.setRealName("leo");
        user.setUserName("lml");


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
