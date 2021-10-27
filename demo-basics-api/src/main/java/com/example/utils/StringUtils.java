package com.example.utils;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * AUTHOR: ws
 * DATE : 2019/9/19 15:26
 * DESCRIPTION:
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 字符传切割拼接***  a:需要切割的字符串，展示前几位，c:展示后几位
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static String subString(String a, int b, int c) {
        String sub01 = a.substring(0, b);
        String sub02 = a.substring(a.length() - c);
        return sub01 + "**" + sub02;
    }

    /**
     * 手机号码
     *
     * @param phone
     * @return
     */
    public static String subPhone(String phone) {
        return phone.replaceAll("(\\d{4})\\d{4}(\\d{3})", "$1****$2");
    }

    /**
     * 身份证号码
     *
     * @param idCard
     * @return
     */
    public static String subIdCard(String idCard) {
        return idCard.replaceAll("(\\d{3})\\d{11}(\\w{4})", "$1********$2");
    }

    /**
     * 截取某个字符
     * 之后的所有值
     * subStringParam 分割字符
     */
    public static String subStringBeforeParam(String param, String subStringParam) {
        return param.substring(param.indexOf(subStringParam) + 1);
    }

    /**
     * 截取某个字符
     * 之前的所有值
     * subStringParam 分割字符
     */
    public static String subStringAfterParam(String param, String subStringParam) {
        return param.substring(0, param.indexOf(subStringParam));
    }

    /**
     * 截取两个字符
     * 中间值
     */
    public static String subStringCenterParam(String param, String first, String second) {
        if (null == param) {
            return null;
        }
        String rgex = "(?<=" + first + ").*?(?=" + second + ")";
        Pattern pattern = Pattern.compile(rgex);
        Matcher m = pattern.matcher(param);
        while (m.find()) {
            return m.group(0);
        }
        return null;
    }

    /**
     * trim头尾指定字符
     *
     * @param content
     * @param trimStr
     * @return
     */
    public static String trim(String content, String trimStr) {
        if (isEmpty(content)) {
            return content;
        }

        return content.replaceAll("^" + trimStr + "|" + trimStr + "$", "");
    }

    /**
     * 分割拼接序号，
     * 句号和换行标签
     * 返回String
     */
    public static String introDescribe(List<String> list){
        String intro = "";
        int num = 1;
        for (String a:list) {
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(a)) {
                String[] split = a.split("\n");
                for (int i=0;i<split.length;i++) {
                    String describe = num + "、" + split[i] + "。\n";
                    intro = intro + describe;
                    num++;
                }
            }
        }
        if ("".equals(intro)) {
            intro ="1、优化用户体验，修复部分BUG\n";
        } else {
            intro = intro + num +"、"+"优化用户体验，修复部分BUG。\n";
        }
        return intro;
    }

}
