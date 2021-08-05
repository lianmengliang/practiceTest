package com.example.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ： Leo
 * @Desc: Unicode转码工具 1.Unicode转中文 ，2.中文转Unicode
 */

public class UnicodeUtil {

    public static void main(String[] args) {

        //中文转Unicode编码
        String cnStr = "中文转码";
        String unicodeResult = cnToUnicode(cnStr);
        System.out.println("中文转Unicode编码后结果：" + unicodeResult);

        //Unicode编码转中文
        //第一种格式
        String cnResult = unicodeToCN(unicodeResult);
        System.out.println("Unicode编码转中文后结果：" + cnResult);

        //第二种格式
        String unicodeStr = "{\"status\":0,\"msg\":\"\\u4e2d\\u6587\\u8f6c\\u7801\",\"code\":2}";
        String cnResult2 = unicodeToCN(unicodeStr);
        System.out.println("Unicode编码转中文后结果：" + cnResult2);


    }

    private static final String UNICODE_PATTERN ="(\\\\u(\\p{XDigit}{4}))";

    String regStr = "(\\\\u(\\p{XDigit}{4}))";

    /**
     * Unicode转 汉字字符串
     *
     * @param str
    中文转Unicode编码后结果：\u4e2d\u6587\u8f6c\u7801
     * @return
     */
    public static String unicodeToCN(String str) {
        Pattern pattern = Pattern.compile(UNICODE_PATTERN);
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
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
        String str = returnStr.toString();
        return str;
    }
}
