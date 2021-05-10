package com.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ： Leo
 * @Date : 2021/5/8 10:13
 * @Desc:
 */
@Slf4j
public class UnicodeUtils {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "{\"status\":0,\"msg\":\"imei\\u4e0d\\u5b58\\u5728\",\"data\":\"\",\"code\":2}";

        String s = unicodeToString(str);
        System.out.println(s);

        String string = "{\"status\":0,\"msg\":\"imei\\u4e0d\\u5b58\\u5728\",\"data\":\"\",\"code\":2}";
        byte[] utf8 = string.getBytes("UTF-8");

        String s1 = new String(utf8, "UTF-8");
        System.out.println(s1);

        String cn = "中国人民";
        String s2 = stringToUnicode(cn);
        System.out.println(s2);

        String s3 = cnToUnicode(cn);
        System.out.println(s3);

        String unicode = "imei\\u4e0d\\u5b58\\u5728";
        String unicode1 = "\\u4e2d\\u56fd\\u4eba\\u6c11";
        String s4 = unicodeToCn(unicode);
        String s5 = unicodeToCn(unicode1);
        System.out.println(s4);
        System.out.println(s5);

        String longString = getLongString(80000);
        System.out.println(longString);

        //进行转码
        long startTime = System.currentTimeMillis();
        String s6 = cnToUnicode(longString);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println(s6);

        long startTime1 = System.currentTimeMillis();
        String s7 = stringToUnicode(longString);
        long endTime1 = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime1 - startTime1) + "ms");

        System.out.println(s7);


    }

    /**
     * 生成汉字长度为10000的字符串
     * 10000次循环， 汉字添加
     *
     * @return
     */
    public static String getLongString(Integer length) {

        StringBuilder returnStr = new StringBuilder();
        for (int i = 0; i < length; i++) {

            int j = i % 20;
            returnStr.append(Surname[j]);
        }
        return returnStr.toString();
    }

    /**
     * 计算程序运行时间
     */
    public static void getRunTime(){
        long startTime = System.currentTimeMillis();
        //do something
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }


    /**
     * 静态变量
     */
    private static Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
    private static String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许"};

    /**
     * Unicode转中文方法
     *
     * @param unicode
     * @return
     */
    public static String unicodeToCn(String unicode) {
        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        String[] strs = unicode.split("\\\\u");
        StringBuilder returnStr = new StringBuilder();
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strs.length; i++) {
            returnStr.append((char) Integer.valueOf(strs[i], 16).intValue());
        }
        return returnStr.toString();
    }


    /**
     * Unicode转 汉字字符串
     *
     * @param str \u6728
     * @return '木' 26408
     */
    public static String unicodeToString(String str) {
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            //group1 \u6728
            String group1 = matcher.group(1);
            str = str.replace(group1, ch + "");
        }
        return str;
    }

    /**
     * 中文转Unicode
     *
     * @param cn
     * @return
     */
    public static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        StringBuilder returnStr = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            returnStr.append("\\u").append(Integer.toString(chars[i], 16));
        }
        return returnStr.toString();
    }

    /**
     * 获取字符串的unicode编码
     * 汉字“木”的Unicode 码点为Ox6728
     *
     * @param s 木
     * @return \ufeff\u6728  \ufeff控制字符 用来表示「字节次序标记（Byte Order Mark）」不占用宽度
     */
    public static String stringToUnicode(String s) {
        try {
            StringBuffer out = new StringBuffer("");
            //直接获取字符串的unicode二进制
            byte[] bytes = s.getBytes("unicode");
            //然后将其byte转换成对应的16进制表示即可
            for (int i = 0; i < bytes.length - 1; i += 2) {
                out.append("\\u");
                String str = Integer.toHexString(bytes[i + 1] & 0xff);
                for (int j = str.length(); j < 2; j++) {
                    out.append("0");
                }
                String str1 = Integer.toHexString(bytes[i] & 0xff);
                out.append(str1);
                out.append(str);
            }
            return out.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
