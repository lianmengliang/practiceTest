package com.example.test;

import cn.hutool.system.oshi.OshiUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.domain.Student;
import com.example.domain.User;
import com.example.utils.OkHttpUtil;
import com.example.utils.XmlTool;
import com.google.common.collect.Lists;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
 * 8.去重：stream().distinct()
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
                .filter(a -> 1 == a.getId() && a.getUserName().equals("leo"))
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

//        list.stream().collect()

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

    /**
     * 分割字符串
     */
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

    /**
     * 时间 类测试
     */
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
    public static void listFilter() {

        List<Order> orders = Lists.newArrayList();

        List list = new ArrayList<Order>();
        // 创建数据
        Order order1 = new Order(1L, 125L, "1221813", "服饰", 100.0f, 13.0f, 123);
        Order order2 = new Order(1L, 143L, "1212313", "水果", 1001.0f, 50.0f, 124);
        Order order3 = new Order(3L, 123L, "122313", "蔬菜", 300.0f, 113.0f, 145);
        Order order4 = new Order(3L, 113L, "1212813", "服饰", 1500.0f, 26.0f, 126);
        Order order5 = new Order(5L, 193L, "125453", "调料", null, 51.0f, 125);
        Order order6 = new Order(6L, 138L, "124543", "首饰", 200.0f, 106.0f, 133);
        Order order7 = new Order(6L, 138L, "124543", "首饰", 100.0f, 126.0f, 133);

        // 设置数据
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);


       list.forEach(System.out::println);


        // 1.筛选总金额大于1000的订单
        // orders = orders.stream().filter(item ->item.getAllAmt()>1000.00f).collect(toList());

        // 2.按类型分组
       /* Map<String, List<Order>> collect = orders.stream().collect(Collectors.groupingBy(Order::getType));
        collect.forEach((key, value)->
                System.out.println("Key="+key+"-------"+"value="+value)
        );*/
        // 2-1 按多个元素分组
       /* Map<Long, Map<String, List<Order>>> collect = orders.stream().collect(Collectors.groupingBy(Order::getId, Collectors.groupingBy(Order::getType)));
        collect.forEach((k,v)-> System.out.println(k+"----------\n"+v));*/

        // 3.按照订单编号去重
        /*orders = orders.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Order::getNum))), ArrayList::new));*/

        // 4.按照订单编号和类型去重
        /*orders = orders.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getNum() + "," + o.getType()))), ArrayList::new));*/

        //List转Map
        //5. 将订单集合转换成订单编号-应付金额 map，注意订单编号作为 key 不能重复，应先做去重处理
//        orders.stream().collect(Collectors.toMap(Order::getNum(),Order::getPayAmt));
//        Map<String, Float> map = orders.stream().collect(Collectors.toMap(Order::getNum, Order::getPayAmt));
//        Map numPayMap = orders.stream().collect(Collectors.toMap(Order::getNum, Order::getPayAmt));
//        map.forEach((k,v)-> System.out.println(k+"-"+ v));

        //6.用 id 做 key 将 List 转成 Map
        /*Map<Long, Order> map = orders.stream().collect(Collectors.toMap(Order::getId, item -> item));
        map.forEach((k,v)-> System.out.println(k+"-"+ v));*/

        // 排序
        // 7.按照订单总金额从高到低排序
        // 方式1:
        /* orders.sort((o1, o2)->o1.getAllAmt() == null ? 1 : (o2.getAllAmt() == null ? -1 : o2.getAllAmt().compareTo(o1.getAllAmt())));*/

        // 方式2： 降序排列
        orders.sort(Comparator.comparing(Order::getAllAmt, (o1, o2) -> o1 == null ? 1 : (o2 == null ? -1 : o2.compareTo(o1))));

        //1. -1 或者 1是判定o值为空的时候排在首位还是末位， -1就是首位， 1就是末位
        //2. o1.compareTo(o2) 这就是升序，否则就是降序
        orders.sort(Comparator.comparing(Order::getAllAmt, (o1, o2) -> o1 == null ? -1 : (o2 == null ? 1 : o1.compareTo(o2))));
        orders.stream().sorted(Comparator.comparing(Order::getAllAmt));

        orders.stream().sorted(Comparator.comparing(Order::getAllAmt, (o1, o2) -> o1 == null ? -1 : (o2 == null ? 1 : o1.compareTo(o2))));
        // 方式三:(allAmt 字段不能为 null， null 会导致排序失败) 升序排列， 加上.reversed()方法就是降序排列
//        orders.sort(Comparator.comparing(Order::getAllAmt));


        // 先按照订单类型排序，再按照订单应付金额从高到低排序
        /*orders.sort(Comparator.comparing(Order::getType, (o1, o2) -> o1 == null ? 1 : (o2 == null ? -1 : o1.compareTo(o2))).thenComparing((o1, o2) -> o1.getPayAmt() == null ? 1 : (o2.getPayAmt() == null ? -1 : o2.getPayAmt().compareTo(o1.getPayAmt()))));*/


        // 统计计数
        // 统计所有订单的总金额
        // 求和
      /*  double sum = orders.stream().filter(item -> item.getAllAmt() != null).mapToDouble(Order::getAllAmt).sum();
        System.out.println(sum);*/

        // 最大总金额
       /* OptionalDouble max = orders.stream().filter(item -> item.getAllAmt() != null).mapToDouble(Order::getAllAmt).max();
        System.out.println(max);
        // 防止没有订单数据处理
        Double max0 = max.isPresent()? max.getAsDouble():0;
        System.out.println(max0);*/

        // 最小总金额
        /*OptionalDouble min = orders.stream().filter(item -> item.getAllAmt() != null).mapToDouble(Order::getAllAmt).min();
        System.out.println(min);
        // 防止没有订单数据处理
        Double min0 = min.isPresent()? min.getAsDouble():0;
        System.out.println(min0);*/

        // 平均总金额
        /*OptionalDouble average = orders.stream().filter(item -> item.getAllAmt() != null).mapToDouble(Order::getAllAmt).average();
        System.out.println(average);
        double v = average.isPresent() ? average.getAsDouble() : 0;
        System.out.println(v);*/

        /* orders.sort((o1, o2)->o1.getAllAmt() == null ? 1 : (o2.getAllAmt() == null ? -1 : o2.getAllAmt().compareTo(o1.getAllAmt())));*/

//        orders.stream()


        // 提取对象中某一元素，最后保存成一个集合
       /* List<Long> collect = orders.stream().map(Order::getId).collect(toList());
        Map<Long, Float> longFloatMap = orders.stream().collect(Collectors.toMap(Order::getId, Order::getAllAmt));*/

        // 多重分组以后，再计算总金额 (加上判空，和数据类型转换)
        Map<Long, IntSummaryStatistics> collect = orders.stream().collect(Collectors.groupingBy(Order::getId,
                Collectors.summarizingInt(o -> o.getAllAmt() == null ? 0 : o.getAllAmt().intValue())));

        Map<Long, LongSummaryStatistics> collect1 = orders.stream().collect(Collectors.groupingBy(Order::getId, Collectors.summarizingLong(Order::getUserId)));

        Map<Long, Long> collect2 = orders.stream().collect(Collectors.groupingBy(Order::getId, Collectors.counting()));

        Map<Long, Map<String, Long>> collect3 = orders.stream().collect(Collectors.groupingBy(Order::getId, Collectors.groupingBy(Order::getType, Collectors.counting())));



        collect3.forEach((k, v) -> System.out.println(k + "----" + v));

        System.out.println("-------------------------");
        for (Order order : orders) {
            System.out.println(order);
        }

    }

    /**
     *
     */
    public static void test006(){
        List<Order> orders = Lists.newArrayList();

        // 创建数据
        Order order1 = new Order(1L, 125L, "12.21813", "服饰", 100.0f, 13.0f, 123);
        Order order2 = new Order(1L, 143L, "1212313", "水果", 1001.0f, 50.0f, 124);
        Order order3 = new Order(3L, 123L, "122313", "蔬菜", 300.0f, 113.0f, 145);
        Order order4 = new Order(3L, 113L, "12.12813", "服饰", 1500.0f, 26.0f, 126);
        Order order5 = new Order(5L, 193L, "125453", "调料", null, 51.0f, 125);
        Order order6 = new Order(6L, 138L, "124543", "首饰", 200.0f, 106.0f, 133);
        Order order7 = new Order(6L, 138L, "124.543", "首饰", 100.0f, 126.0f, 133);

        // 设置数据
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);


        orders.forEach(item->{
            if (item.getNum().contains(".")){
                item.setNum(item.getNum().replace(".", "_"));
            }
            System.out.println(item);
        });

       // java实现
//        orders.forEach(item->item.setNum(item.getNum().replace(".", "_")));


        String a =  "123.23w123";
        String replace = a.replace(".", "_");
        System.out.println(replace);
    }
    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
       /* String TOKEN = "419a9d3c203176c05f6081c703c715fd";
        String format = "xml";
//        String format = "jsonp";
        testIP(TOKEN, format);*/

        /*getStreamResult();

        String text = "Base64 finally in Java 8!";

        String encoded = Base64
                .getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        String decoded = new String(
                Base64.getDecoder().decode(encoded),
                StandardCharsets.UTF_8);

        System.out.println(decoded);*/


        test006();

    }


}


@Data
class Order {
    private Long id;

    private Long userId;

    private String num;

    private String type;

    private Float allAmt;

    private Float payAmt;

    private Integer orderNum;

    public Order(Long id, Long userId, String num, String type, Float allAmt, Float payAmt, Integer orderNum) {
        this.id = id;
        this.userId = userId;
        this.num = num;
        this.type = type;
        this.allAmt = allAmt;
        this.payAmt = payAmt;
        this.orderNum = orderNum;
    }


}
