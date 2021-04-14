package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.domain.Student;
import com.example.domain.User;
import com.example.utils.OkHttpUtil;
import com.example.utils.XmlTool;

import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Author ： leo
 * @Date :2020/3/26 10:40
 * <p>
 * 练习 jdk8的stream
 */

/**
 * stream 的常用方法：
 * 1.循环 stream.forEach();
 * 2.过滤 stream.filter();
 * 3.类型转换 stream.map();  如：stream.map((String s)-> Integer.parseInt(s));
 * 4.计数 stream.count();
 * 5.截取 stream.limit();  如： stream.limit(3); 截取前三个元素
 * 6.跳过元素 stream.skip(); 如： stream.skip(3); 跳过前三个元素
 * 7.把流组合到一起 Stream.concat(stream1, stream2);
 */
public class testStream {


    public static void stringConversionList() {

        // String的数组
        String[] array = {"12", "21", "21"};
        // 数组转集合
        // 1.Collections.addAll() 方法
        List<String> resultList = new ArrayList<>(array.length);
        Collections.addAll(resultList, array);


        // 数组转集合ArrayList<String> list =  List.of(str);   jdk1.9的方法
        // 已知“确定个数的字符串”转换为集合
        List<String> menus = Arrays.asList("宫保鸡丁", "糖醋鲤鱼", "重庆辣子鸡", "回锅肉", "水煮鱼");


        Integer[] arrayInt = {1, 3, 2};

        ArrayList<Integer> intList = new ArrayList<>(arrayInt.length);
        Collections.addAll(intList, arrayInt);
    }

    /**
     * 字符串数组 转化为 集合
     * ArrayList集合只能存储引用数据类型，
     * 其实也可以存储基本数据类型。
     * 在ArrayList集合当中，
     * 如果要存储基本数据类型需要用到基本数据类型相对应的包装类
     *
     * @param array
     * @return
     */
    public static ArrayList stringConList(String[] array) {

        // 1. 方法： Collections.addAll()
        ArrayList<String> list1 = new ArrayList<>(array.length);

        Collections.addAll(list1, array);

        //2. 方法： Arrays.asList()
        /**
         * 调用Arrays.asList()时，其返回值类型是ArrayList，
         * 但此ArrayList是Array的内部类，调用add()时，
         * 会报错：java.lang.UnsupportedOperationException，
         * 并且结果会因为array的某个值的改变而改变，
         * 故需要再次构造一个新的ArrayList
         */
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(array));

        return list1;
    }


    private static void getStreamResult() {
        //创建一个 List 集合,存储姓名
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        /*list.stream().filter(s‐>
                s.startsWith("张"))
        .filter(s ‐> s.length() == 3)
        .forEach(System.out::println); }
        */
//        list.stream().forEach(System.out::println);

        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 0)
                .forEach(System.out::println);

        long count = list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() != 0)
                .count();

        System.out.println(count);

        list.stream()
                .filter(s -> s.length() != 0)
                .forEach(System.out::println);


        System.out.println(list.stream().count());


    }

    /**
     * 转换流
     */
    private static void getStreamToMap() {
        //获取一个 String 类型的 Stream 流
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        // 使用 map 方法,把字符串类型的整数,转换(映射)为 Integer 类型 的整数
        Stream<Integer> stream2 = stream.map((String s) -> Integer.parseInt(s));
        //System.out.println(stream2.count());
        // 遍历 Stream2 流
        stream2.forEach(i -> System.out.println(i));


    }


    public static void getResult() {

        /*list.stream()
                .filter(s->s.startsWith("张"))
                .filter(s->s.length()==3)
                .forEach(System.out::println);*/


        ArrayList<User> users = new ArrayList<>();

        List<User> collect = users.stream()
                .filter(a -> 1 == a.getId())
                .filter(a -> a.getUserName().equals("leo"))
                .collect(Collectors.toList());


        ArrayList<User> result = new ArrayList<>();

        for (User user : users) {

            if (user.getId() == 1) {
                result.add(user);
            }
        }

    }

    public static void get() {

        String a = "1.6";
        Double v = Double.parseDouble(a);

        double floor = Math.floor(v);
        System.out.println(floor);

        String line = new Scanner(System.in).nextLine();

        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();


    }

    public static void getDemo001() {

        String a = "     ";

        String b = "123";


        String s = b.replaceAll("123", a);

        System.out.println(1 + s + 1);


    }

    /*Button.addActionListener(new ActionListener()){
        public void actionPerformed(ActionEvent event){
            System.out.println("button clicked");
        }
    }*/

    public static void testOptional() {

        List<User> list = new ArrayList<>();

        User user = new User();
        user.setId(1);
        user.setUserName("leo");
        list.add(user);

//        Optional<List<User>> optional = Optional.ofNullable(list).filter(l ->l.get(0).getUserName().contains("leo"));

        Optional<List<User>> optional = Optional.ofNullable(list);

//        System.out.println(optional.isPresent());

        if (!optional.isPresent()) {

        }
    }

    public static void test001() {

        Integer i = null;

        User user = new User();
        //user.setId(i);
        System.out.println(user);

        Student student = new Student();
        student.setId(2);
        student.setName(user.getUserName());
        System.out.println(student);

        student.setName("12321");
        System.out.println(student);

    }


    public static void test002() {

        String str = "3123123,123123123,3213123，66666，888";

        String[] split = str.split(",");

        for (String s : split) {
            System.out.println(s);
        }
        String[] split1 = str.replace("，", ",").replace("1", "a").split(",");

        for (String s : split1) {
            System.out.println(s + "---------------------");
        }


    }


    public static void testTime() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDate = yesterday.format(fmt);
        String endDate = today.format(fmt);

        System.out.println(today + "----------today");
        System.out.println(yesterday + "------yesterday");
        System.out.println(startDate + "------startDate");
        System.out.println(endDate + "------endDate");


    }


    public static void testTime1() {
        LocalDateTime thisHour = LocalDateTime.now().withMinute(0).withSecond(0);
        LocalDateTime fourHourAgo = thisHour.minusHours(4);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String startTimeString = fourHourAgo.format(fmt);
        String endTimeStr = thisHour.format(fmt);


        System.out.println(thisHour + "--" + fourHourAgo + "--" + startTimeString + "--" + endTimeStr);
    }

    public static void testIP(String token, String format) {

        String IP = "111.226.132.66";


        StringBuilder builder = new StringBuilder("http://api.ip138.com/ipv4/");
        //https://api.ip138.com/ipv4/?ip=112.17.25.148&datatype=jsonp&callback=find&token=419a9d3c203176c05f6081c703c715fd
        StringBuilder append = builder.append("?ip=").append(IP)
                .append("&datatype=").append(format)
//                .append("&callback=find")
                .append("&token=").append(token);

        String url = append.toString();


        Map<String, String> map = new HashMap<>();

        String res = OkHttpUtil.requestOfGet(url, map, "");
        System.out.println(res);


        String jsonResponse = XmlTool.documentToJSONObject(res).toJSONString();
        System.out.println(jsonResponse);

        //解析json字符串


        //JSONObject res = JSON.parseObject(s);


    }


    public static void main(String[] args) {
       /* String TOKEN = "419a9d3c203176c05f6081c703c715fd";
        String format = "xml";
//        String format = "jsonp";
        testIP(TOKEN, format);*/

        getStreamResult();

        /*testTime();
        testTime1();*/

        String text = "Base64 finally in Java 8!";

        String encoded = Base64
                .getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        String decoded = new String(
                Base64.getDecoder().decode(encoded),
                StandardCharsets.UTF_8);



        System.out.println(decoded);
    }




}
