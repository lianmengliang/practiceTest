package com.example.test;


import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ： leo
 * @Date :2020/2/27 18:38
 */
public class testString {

    public static void getString() {

        String[] split = "asd,fg,hjk".split(",");
        String s = "asd,fg,hjk".split("\\,")[0];

        System.out.println(split);
        System.out.println(s);
    }

    public String getStr() {
        String str = null;

        if (str.equals("1122")) {
            return "321312";
        } else {
            return "31231";
        }
    }

    public static void getStr1() {
        String config = "/try/try_cpl_plus.aspx?adid= 6106";

        String[] split = config.split("'?'");
        String[] split1 = config.split("[?]", 2);
        for (String s : split1) {
            System.out.println(s);
        }

        System.out.println("qewq?".replaceAll("[?]", "a"));
        System.out.println(config.split("[?]")[1]);
    }

    public static void getStr2() {

        String adid = "4589";

        String arg = "/try/try_cpl_plus.aspx";

        String format = String.format("%s?adid=%s", arg, adid);

        System.out.println(format);
    }


    public static void getResult() {

        String str = "25.51654561564615656151%";

        //去掉 %
        //1.替换  % 替换成 ""
        String replace = str.replace("%", "");
        System.out.println(replace);
        //2.
        String s = replace.split("\\.")[1];
        if (s.length() > 10) {
            BigDecimal bigDecimal = new BigDecimal(replace);
            System.out.println(bigDecimal);

            System.out.println("============================");

            System.out.println(bigDecimal.toString());

        }

        /*if (replace.split("\\.")[1].length()>10){
            BigDecimal decimal = new BigDecimal(replace);
            System.out.println(decimal);
        }*/


        //2.截取  去掉最后一位
       /* String substring = str.substring(0, str.length() - 2);
        System.out.println(substring);
*/
        //3.分隔  以%为分隔
        /*String split = str.split("%")[0];
        System.out.println(split);*/


    }

    public static void getResult2() {

        String str = "25.51654561564615656151%";
        //去掉 %
        //2.截取  去掉最后一位
        String substring = str.substring(0, str.length() - 1);
        if (substring.split("\\.")[1].length() > 10) {
            BigDecimal bigDecimal = new BigDecimal(substring);
            System.out.println(bigDecimal);
        }

    }

    public static void getResult3() {

        String str = "25.51654561564615656151%";

        String split = str.split("%")[0];
        if (split.split("\\.")[1].length() > 10) {
            BigDecimal bigDecimal = new BigDecimal(split);
            System.out.println(bigDecimal);

            System.out.println("string+ " + bigDecimal.toString());

        }


    }

    /**
     * String.join
     * 1.以连接符号，连接各个分开的字符串 如： String.join("%", "java", "python","C++"); --> java%python%C++
     * 2.以连接符号，连接数组或集合中的各个元素 如： String.join(",", list); --> 123,456,789
     * *注意： 数组或集合中的元素必须是字符串类型
     */
    public static void testString001() {

        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");

     /*   List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        String join = String.join(",", (CharSequence) list2);
        System.out.println("Integer----->"+ join);*/

        //表示被连接的数组（也可以是集合），或者是要连接的多个字符串
        String joinResult = String.join(",", list);
        System.out.println(joinResult);         //123,456,789

        String[] arr = {"java", "c++", "ruby"};
        String result = String.join("*", arr);
        System.out.println(result);  //java*c++*ruby


        //拼接字符串:表示连接的符号
        String join1 = String.join("-", "C++", "python", "java"); //C++-python-java
        String join2 = String.join("%", "java", "python", "C++");  //java%python%C++
        String join3 = String.join("$", "python", "C++", "java"); //java%python%C++

        System.out.println(join1);
        System.out.println(join2);
        System.out.println(join3);


    }

    public static void main(String[] args) {
        testString001();

    }

    /**
     * 工具类
     * 去除小数的百分号，然后再判断小数个数是否符合标准
     *
     * @param str
     * @param length
     * @return
     */
    public static BigDecimal String(String str, int length) {

        //首先去除%号
        String replaceStr = str.replace("%", "");
        //获取小数个数
        int checkLength = replaceStr.split("\\.")[1].length();
        //判断
        if (checkLength > length) {
            BigDecimal bigDecimal = new BigDecimal(replaceStr);
            return bigDecimal;
        }
        return null;

    }


    public static String getStringCompareResult(String str1, String str2) {

        //参数校验
        if (StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2)) {
            return "不存在";
        }
        // asd123fgh
        // qwe123few

        //先将两个字符串 转换未char数组
        char[] charArray1 = str1.toCharArray();

        Map<Integer,String> map = new HashMap<>();

        for (int i = 0; i < charArray1.length; i++) {
            map.put(i,String.valueOf(charArray1[i]));
        }

        char[] charArray2 = str2.toCharArray();



        //maxLength是出现最大的公共子串长度

        return "";
    }

}
