package com.example.test.javaBasis.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * lianmengliang
 * <p>
 * 2021-05-30 09:53
 * 正则表达式的练习
 */
public class testRegExp {
    public static void main(String[] args) {
        testLimitSymbol();
    }

    /**
     * 练习转义字符
     * <p>
     * 特别强调的是：不区分大小写
     * (?i)abc ：不区分abc大小写
     * a(?i)bc : 不区分bc大小写
     * a((?i)b)c : 不区分b大小写
     * Pattern.compile(regStr,Pattern.CASE_INSENSITIVE) 不区分大小写
     *
     */
    public static void testMatchSymbol() {
        String content = "abc 11 c8aBc.ABC?()";
        // 1.匹配a-z之间的任意一个字符 或者 A-Z之间的任意一个字符 regStr = "[A-Z]" ,非[^a-zA-Z]
//        String regStr = "[a-z]";
        // 2.匹配abc字符串【默认区分大小写】
//        String regStr = "abc";
        // 3.匹配abc字符串【不区分大小写】
//        String regStr = "a((?i)b)c";
        // 4.匹配0-9任意一个字符 [0-9]  ,非0-9: [^0-9]
       // String regStr = "[abcd]"; //5.匹配在abcd之间的任意一个字符

//        String regStr = "\\w";  //6.匹配任意[a-zA-Z0-9]的一个字符
//        String regStr = "\\W";   //7.匹配非任意[a-zA-Z0-9]的一个字符
//        String regStr = "\\s";    //8。匹配到 空格字符
//        String regStr = "\\S";    //9。匹配到 非空格字符
        String regStr = ".";    //10。匹配到所有

        pattern(content,regStr);
    }

    /**
     * 练习：选择匹配符
     */
    public static void testSelectSymbol() {
        String content = "lianmengliang连孟亮";

        String regStr1 = "lian|连|梦";    //8。匹配到所有

        pattern(content,regStr1);



    }
    /**
     * 练习：限制匹配符
     *
     * 细节：java匹配默认贪婪匹配，即可能匹配多的， 如："2{2,3} 优先匹配3个2的
     */
    public static void testLimitSymbol() {
        String content = "11111aa1111";

        String regStr1 = "1{2,5}";
        // 我们都是好孩纸 都是好孩纸
        //String str = "!@#$%^&*)";

        pattern(content,regStr1);



    }

    /**
     * 练习：分组匹配符
     * 说明：
     * 1。group(0): 得到的匹配的字符串
     * 2。group(1)：
     * 3。group(2)
     */
    public static void testGroupSymbol() {
        String content = "1a2a3d4d";

        String regStr1 = "\\d\\d\\d\\d";
        // 我们都是好孩纸 都是好孩纸
        //String str = "!@#$%^&*)";

        pattern(content,regStr1);



    }




















    /**
     * 根据字符串 和 匹配规则，来执行正则表达式过程
     * @param content
     * @param regStr
     */
    public static void pattern(String content,String regStr){
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }


    private String str1 = "hello韩顺平教育，jack韩顺平老师 韩顺平同学hello";
    /**
     * 不能用group（1）分组
     */
    private String regString1 = "韩顺平（?:同学｜教育｜老师）"; //韩顺平教育 韩顺平老师 韩顺平同学
    private String regString2 = "韩顺平（?:同学｜教育）";  // 韩顺平  韩顺平
    private String regString3 = "韩顺平（?!同学｜教育）";  // 韩顺平  韩顺平    不是同学，教育的韩顺平



    private String str2 = "hello11111 ？";
    private String regString4 = "\\d+?"; // 非贪婪匹配

    // 举例：
    // 1. 验证是否为汉字   ^[\u0391-\uffe5]+$
    private String regString5 = "^[\\u0391-\\uffe5]+$";

    // 2.验证邮政编码    ^[1-9]$\\d{5}$   开头是1-9的开头的6位数
    // 3。验证QQ号：1-9开头的5位数-10位数   ^[1-9]\\d{4,9]$
    // 4.验证手机号：要求：必须是13，14，15，18开头的11位数  ^1[3|4|5|8]\\d{9}$
    // 5.验证URL： 如：https://www.bilibili.com/video/BV1qq4y1E7tp?spm_id_from=333.851.b_7265636f6d6d656e64.1
    // 分析： http或https开头


    // ^((http|https)://)([\\w-]+\\.)+

    private String regString6 = "^((http|https)://)([\\w_]+\\.)+[\\w_]+(\\/[\\w-?=&/%.#]*)?$";


}
