package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.domain.IpAddress;
import com.example.domain.User;
import com.example.test.model.ReportClass;
import com.example.utils.CollectionUtil;
import com.example.utils.JsonFormatUtil;
import jdk.nashorn.internal.ir.IfNode;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;


import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
     * json字符串格式化输出
     *
     * @param object
     * @return
     */
    public static String jsonStringFormat(Object object) {
        return JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
    }


    /**
     * 谷歌的插件： json字符串格式化-输出
     *
     * @param
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

    }

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {

        /*JSONObject jsonObject1 = JSON.parseObject(TEST_STR1);
        System.out.println(jsonObject1);

        JSONObject jsonObject = JSON.parseObject(TEST_STR);
        System.out.println(jsonObject);
        System.out.println(TEST_STR);
        System.out.println("格式化前：" + JSON_NO);
        System.out.println("------------------------------------------------------------");
        JSONObject object = JSONObject.parseObject(JSON_NO);
        String pretty = jsonStringFormat(object);
        System.out.println("SerializerFeature格式后：" + pretty);
        System.out.println("------------------------------------------------------------");

        String s = JsonFormatUtil.formatJson(JSON_NO);
        System.out.println(s);
*/

//        testJson(TEST_STR);

        handleJsonStr();

    }

    /**
     * json字符串的各种操作方法
     *
     * @param json
     */
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
     * 处理Json字符串 各种用法
     */
    public static void handleJsonStr() {
        // JSON字符串-->JSON对象
        JSONObject jsonObject = JSON.parseObject(INITIAL_JSON);
        System.out.println("jsonObject--" + jsonObject);

        /**
         * 解析第一层：状态值
         */
        // 获取判断请求是否成功返回的状态值
        Integer status = jsonObject.getInteger("status");
        System.out.println(status);
        //
        String msg = jsonObject.getString("msg");
        System.out.println(msg);

        /**
         * 解析第二层:数据封装层
         */
        JSONObject data = jsonObject.getJSONObject("data");
        System.out.println(data);

        //获取页码和总数
        Integer pageNum = data.getInteger("pageNum");
        Integer total = data.getInteger("total");
        System.out.println("页码：" + pageNum + " 数据总条数：" + total);

        System.out.println("报表名称：" + data.getString("name"));

        //获取封装的数据
        JSONArray list = data.getJSONArray("list");
        System.out.println(list);

        JSONArray headers = data.getJSONArray("headers");
        System.out.println(headers);

        /**
         * 解析第三层： 处理封装好的数据
         */

        //把封装好的数据，转化为类
        List<ReportClass> dataList = new ArrayList<>();
        //循环 转化为实体类，并且添加到集合中
        for (Object o : list) {
            ReportClass reportClass = JSON.parseObject(o.toString(), ReportClass.class);
            dataList.add(reportClass);
        }
        System.out.println(dataList);

        //处理headers
        ArrayList<String> headerList = new ArrayList<>();
        for (Object header : headers) {
            JSONObject jsonObjectForHeader = JSON.parseObject(header.toString());
            String key = jsonObjectForHeader.getString("key");
            headerList.add(key);
        }
        System.out.println(headerList);

        System.out.println("----------------------------------------");

        //快速获取list
       /* JSONArray jsonArrayForList = jsonObject.getJSONObject("data").getJSONArray("list");
        for (Object o : jsonArrayForList) {
            System.out.println(o.toString());
        }
*/

       /* String date = "2021-02-16";

        pattern(date,"\\d{4}-\\d{2}");

        String substring = date.substring(0, 7);
        System.out.println(substring);*/
        /*dataList.forEach(item -> {
                    DateTime dateTime = new DateTime(item.getDate());
                    int year = dateTime.getYear();
                    int currentMonth = dateTime.getMonthOfYear();
                    int currentQuarter = currentMonth % 3 == 0 ? (currentMonth / 3) : (currentMonth / 3 + 1);
                    item.setDate(String.format("%s年%s季度", year, currentQuarter));


                }
        );*/

       /* dataList.forEach(item -> item.setDate(item.getDate().substring(0, 4)));
        dataList.forEach(System.out::println);*/
        //按月份对 集合中的类 进行处理

//        List<ReportClass> dataList1 = new ArrayList<>(dataList);
//        dataList1.forEach(System.out::println);
       /* sortCollectionByDateType(dataList, 3);
        sortCollectionByDateType(dataList, 1);
        sortCollectionByDateType(dataList, 2);
*/
        System.out.println("handleList(dataList)----------------------------------------");
        handleList(dataList);
    }


    /**
     * 根据字符串 和 匹配规则，来执行正则表达式过程
     *
     * @param content
     * @param regStr
     */
    public static void pattern(String content, String regStr) {
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }


    /**
     * 根据条件进行排序
     *
     * @param list
     * @param dateType 日期分类： 0就是按日，1：按月份，2：按季度，3：按年份
     */
    public static void sortCollectionByDateType(List<ReportClass> list, int dateType) {
        // 深拷贝，保证处理的同一个集合中 元素 不会改变
        /**
         * 需要Address实现cloneable接口和重写clone方法，该方法有限制性，
         *  例如要先声明List是保存的什么对象，并且当碰到对象里面还持有List集合的时候
         *  就不管用的，所以建议使用第一种方法
         */
        /*List<ReportClass> dataList = new ArrayList<>();
        list.forEach(item->dataList.add((ReportClass) item.clone()));*/

        // 深拷贝
        List<ReportClass> dataList = CollectionUtil.deoCopy(list);


        // 根据日期类型处理list
        if (dateType == 1) {
            dataList.forEach(item -> item.setDate(item.getDate().substring(0, 7)));
        } else if (dateType == 2) {
            dataList.forEach(item -> {
                        DateTime dateTime = new DateTime(item.getDate());
                        int year = dateTime.getYear();
                        int currentMonth = dateTime.getMonthOfYear();
                        int currentQuarter = currentMonth % 3 == 0 ? (currentMonth / 3) : (currentMonth / 3 + 1);
                        item.setDate(String.format("%s年%s季度", year, currentQuarter));
                    }
            );
        } else if (dateType == 3) {
            dataList.forEach(item -> item.setDate(item.getDate().substring(0, 4) + "年"));
        } else {
            return;
        }


        System.out.println(dataList.size() + "----------------------------------------------------------------");
        System.out.println("-------------转化为Map<String, ReportClass>集合");
        //合并求和
        Map<String, ReportClass> map = new HashMap<>();
        dataList.forEach(item -> {
            //首先判断item，是否存在，
            ReportClass reportClass = map.get(item.getDate());
            if (reportClass == null || StringUtils.isEmpty(reportClass.getDate())) {
                // 第一次加入
                map.put(item.getDate(), item);
            } else {
                // 第二次或超过第二次加入
                reportClass.setAdNum(reportClass.getAdNum() + item.getAdNum());
                reportClass.setDownloadNum(reportClass.getDownloadNum() + item.getDownloadNum());
                reportClass.setChannelNum(reportClass.getChannelNum() + item.getChannelNum());
                map.put(reportClass.getDate(), reportClass);
            }
        });
        map.forEach((k, v) -> System.out.println(k + "：" + v));
        System.out.println("-------------转化为List<ReportClass>集合");
        ArrayList<ReportClass> reportClasses = new ArrayList<>();
        map.forEach((k, v) -> reportClasses.add(v));

        // 下面2种方法都是降序 排序
//      reportClasses.sort(Comparator.comparing(ReportClass::getDate, Comparator.reverseOrder()));
        // 使用 流 stream
        reportClasses.stream().sorted((o1, o2) -> o2.getDate().compareTo(o1.getDate()));

        // 下面4种方法都是升序 排序  （默认方法就是升序排序）
       /* reportClasses.sort(Comparator.comparing(ReportClass::getDate, Comparator.naturalOrder()));
        reportClasses.sort(Comparator.comparing(ReportClass::getDate, String::compareTo));
        reportClasses.sort(Comparator.comparing(ReportClass::getDate));
        // 使用流 stream
        reportClasses.stream().sorted(Comparator.comparing(ReportClass::getDate));*/

        // 打印輸出
        reportClasses.forEach(System.out::println);


        System.out.println("-----------------------------------------------------------");

        System.out.println("-----------------------------------------------------------");

        // 分组
       /* Map<String, List<ReportClass>> collect = list.stream().collect(Collectors.groupingBy(ReportClass::getDate));
        //,Collectors.toMap(Collectors.groupingBy(ReportClass::getDate))

        list.stream().forEach(item -> item.setDate(item.getDate().substring(0, 7)));
        collect.forEach((k, v) -> System.out.println(k + "：" + v));*/

        /*list.stream().collect(Collectors.groupingBy(ReportClass::getDate, Collectors.summarizingInt(ReportClass::getAdNum)));
        System.out.println(list);
*/

    }

    /**
     * 集合处理
     *
     * @param list
     */
    public static void handleList(List<ReportClass> list) {

        // 先处理集合
        // 按月份处理
//        list.forEach(item -> item.setDate(item.getDate().substring(0, 7)));

        //按季度处理
        list.forEach(item -> {
            DateTime dateTime = new DateTime(item.getDate());
            int currentYear = dateTime.getYear();
            int currentMonth = dateTime.getMonthOfYear();
            int currentQuarter = currentMonth % 3 == 0 ? (currentMonth / 3) : (currentMonth / 3 + 1);
            item.setDate(String.format("%s年%s季度", currentYear, currentQuarter));
        });

        // 按年份处理
//        list.forEach(item -> item.setDate(item.getDate().substring(0, 4) + "年"));
        // 创建一个新集合
        ArrayList<ReportClass> reportList = new ArrayList<>();

        list.forEach(item -> {
            if (reportList.size() == 0) {
                reportList.add(item);
            } else {
                // 判断目标集合中是否有原集合的元素
                boolean isContain = false;
                for (ReportClass item1 : reportList) {
                    if (item1.getDate().equals(item.getDate())) {
                        item1.setAdNum(item1.getAdNum() + item.getAdNum());
                        item1.setDownloadNum(item1.getDownloadNum() + item.getDownloadNum());
                        item1.setChannelNum(item1.getChannelNum() + item.getChannelNum());
                        isContain = true;
                    }
                }
                if (!isContain) {
                    reportList.add(item);
                }
            }
        });

       /* for (ReportClass item : list) {
            if (reportList.size() == 0) {
                reportList.add(item);
            } else {
                // 判断目标集合中是否有原集合的元素
                boolean isContain = false;
                for (ReportClass item1 : reportList) {
                    if (item1.getDate().equals(item.getDate())) {
                        item1.setAdNum(item1.getAdNum() + item.getAdNum());
                        item1.setDownloadNum(item1.getDownloadNum() + item.getDownloadNum());
                        item1.setChannelNum(item1.getChannelNum() + item.getChannelNum());
                        isContain = true;
                    }
                }
                if (!isContain) {
                    reportList.add(item);
                }
            }
        }
*/
        reportList.sort(Comparator.comparing(ReportClass::getDate, Comparator.reverseOrder()));
        reportList.forEach(System.out::println);


    }

    private static String INITIAL_JSON = "{\"status\":0,\"timestamp\":1628050481988,\"msg\":\"success\",\"data\":{\"pageNum\":1,\"total\":93,\"list\":[{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2021-07-07\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2021-07-02\",\"广告数量\":1},{\"下载数量\":3,\"渠道数量\":3,\"日期\":\"2021-06-09\",\"广告数量\":3},{\"下载数量\":4,\"渠道数量\":4,\"日期\":\"2021-06-08\",\"广告数量\":4},{\"下载数量\":3,\"渠道数量\":3,\"日期\":\"2021-06-07\",\"广告数量\":3},{\"下载数量\":4,\"渠道数量\":4,\"日期\":\"2021-06-01\",\"广告数量\":4},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2021-05-26\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2021-05-12\",\"广告数量\":1},{\"下载数量\":2,\"渠道数量\":2,\"日期\":\"2021-05-11\",\"广告数量\":2},{\"下载数量\":3,\"渠道数量\":3,\"日期\":\"2021-04-29\",\"广告数量\":3},{\"下载数量\":8,\"渠道数量\":8,\"日期\":\"2021-04-28\",\"广告数量\":8},{\"下载数量\":4,\"渠道数量\":4,\"日期\":\"2021-04-07\",\"广告数量\":4},{\"下载数量\":3,\"渠道数量\":3,\"日期\":\"2021-03-23\",\"广告数量\":3},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2021-03-22\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2021-02-01\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2021-01-22\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-12-30\",\"广告数量\":1},{\"下载数量\":6,\"渠道数量\":6,\"日期\":\"2020-12-29\",\"广告数量\":6},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-12-28\",\"广告数量\":1},{\"下载数量\":3,\"渠道数量\":3,\"日期\":\"2020-12-14\",\"广告数量\":3},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-12-11\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-11-05\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-11-03\",\"广告数量\":1},{\"下载数量\":6,\"渠道数量\":6,\"日期\":\"2020-10-13\",\"广告数量\":6},{\"下载数量\":3,\"渠道数量\":3,\"日期\":\"2020-08-11\",\"广告数量\":3},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-07-10\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-07-08\",\"广告数量\":1},{\"下载数量\":2,\"渠道数量\":2,\"日期\":\"2020-06-30\",\"广告数量\":2},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-06-01\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-05-28\",\"广告数量\":1},{\"下载数量\":7,\"渠道数量\":7,\"日期\":\"2020-05-19\",\"广告数量\":7},{\"下载数量\":3,\"渠道数量\":3,\"日期\":\"2020-05-18\",\"广告数量\":3},{\"下载数量\":2,\"渠道数量\":2,\"日期\":\"2020-04-21\",\"广告数量\":2},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-04-16\",\"广告数量\":1},{\"下载数量\":4,\"渠道数量\":4,\"日期\":\"2020-04-15\",\"广告数量\":4},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-04-14\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-04-13\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-04-10\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-04-09\",\"广告数量\":1},{\"下载数量\":4,\"渠道数量\":4,\"日期\":\"2020-03-30\",\"广告数量\":4},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2020-03-28\",\"广告数量\":1},{\"下载数量\":4,\"渠道数量\":4,\"日期\":\"2020-03-12\",\"广告数量\":4},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-12-20\",\"广告数量\":1},{\"下载数量\":2,\"渠道数量\":2,\"日期\":\"2019-12-18\",\"广告数量\":2},{\"下载数量\":3,\"渠道数量\":3,\"日期\":\"2019-12-11\",\"广告数量\":3},{\"下载数量\":5,\"渠道数量\":5,\"日期\":\"2019-12-04\",\"广告数量\":5},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-12-02\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-11-29\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-11-28\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-11-26\",\"广告数量\":1},{\"下载数量\":2,\"渠道数量\":2,\"日期\":\"2019-11-22\",\"广告数量\":2},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-11-21\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-11-19\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-10-24\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-10-23\",\"广告数量\":1},{\"下载数量\":4,\"渠道数量\":4,\"日期\":\"2019-09-18\",\"广告数量\":4},{\"下载数量\":2,\"渠道数量\":2,\"日期\":\"2019-09-16\",\"广告数量\":2},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-09-12\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-09-09\",\"广告数量\":1},{\"下载数量\":2,\"渠道数量\":2,\"日期\":\"2019-09-05\",\"广告数量\":2},{\"下载数量\":8,\"渠道数量\":8,\"日期\":\"2019-09-04\",\"广告数量\":8},{\"下载数量\":2,\"渠道数量\":2,\"日期\":\"2019-09-03\",\"广告数量\":2},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-09-02\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-08-30\",\"广告数量\":1},{\"下载数量\":4,\"渠道数量\":4,\"日期\":\"2019-08-22\",\"广告数量\":4},{\"下载数量\":15,\"渠道数量\":15,\"日期\":\"2019-08-21\",\"广告数量\":15},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-07-31\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-07-26\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-07-18\",\"广告数量\":1},{\"下载数量\":2,\"渠道数量\":2,\"日期\":\"2019-07-05\",\"广告数量\":2},{\"下载数量\":2,\"渠道数量\":2,\"日期\":\"2019-07-04\",\"广告数量\":2},{\"下载数量\":2,\"渠道数量\":2,\"日期\":\"2019-07-03\",\"广告数量\":2},{\"下载数量\":6,\"渠道数量\":6,\"日期\":\"2019-07-02\",\"广告数量\":6},{\"下载数量\":5,\"渠道数量\":5,\"日期\":\"2019-07-01\",\"广告数量\":5},{\"下载数量\":3,\"渠道数量\":3,\"日期\":\"2019-06-28\",\"广告数量\":3},{\"下载数量\":18,\"渠道数量\":18,\"日期\":\"2019-06-27\",\"广告数量\":18},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-06-03\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-05-31\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-05-30\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-05-29\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-05-28\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-05-23\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-04-30\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-04-25\",\"广告数量\":1},{\"下载数量\":7,\"渠道数量\":7,\"日期\":\"2019-04-09\",\"广告数量\":7},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-03-28\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-03-26\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-02-28\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-02-27\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-02-21\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2019-01-15\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2018-12-26\",\"广告数量\":1},{\"下载数量\":1,\"渠道数量\":1,\"日期\":\"2018-12-07\",\"广告数量\":1}],\"name\":\"广告下载明细测试-用于日期测试\",\"sql\":\"select * from (select temp_page.*,rownum rn_ from (select to_char(itime,'yyyy-mm-dd') 日期, count(id) 下载数量,\\r\\ncount(adid) 广告数量,\\r\\ncount(appid) 渠道数量\\r\\n  from mg_usercenter.t_ad_bind_test\\r\\n where 1 = 1 \\r\\n  \\r\\n \\r\\n group by to_char(itime,'yyyy-mm-dd')\\r\\n order by to_char(itime,'yyyy-mm-dd') desc) temp_page where rownum <= 100) where rn_>=1\",\"headers\":[{\"key\":\"日期\",\"title\":\"日期\",\"remark\":null,\"sortable\":null,\"width\":80,\"align\":null,\"summary\":\"sum()\"},{\"key\":\"下载数量\",\"title\":\"下载数量\",\"remark\":null,\"sortable\":null,\"width\":80,\"align\":null,\"summary\":\"sum()\"},{\"key\":\"广告数量\",\"title\":\"广告数量\",\"remark\":null,\"sortable\":null,\"width\":80,\"align\":null,\"summary\":\"sum()\"},{\"key\":\"渠道数量\",\"title\":\"渠道数量\",\"remark\":null,\"sortable\":null,\"width\":80,\"align\":null,\"summary\":\"sum()\"}]},\"exceptionClass\":null,\"errorMsg\":null}";

}
