package com.example.test;

import java.math.BigDecimal;

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
        if (s.length()>10){
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


    }public static void getResult2() {

        String str = "25.51654561564615656151%";
        //去掉 %
        //2.截取  去掉最后一位
        String substring = str.substring(0, str.length()-1);
        if(substring.split("\\.")[1].length()>10){
            BigDecimal bigDecimal = new BigDecimal(substring);
            System.out.println(bigDecimal);
        }

    }public static void getResult3() {

        String str = "25.51654561564615656151%";

        String split = str.split("%")[0];
        if (split.split("\\.")[1].length()>10){
            BigDecimal bigDecimal = new BigDecimal(split);
            System.out.println(bigDecimal);

            System.out.println("string+ " + bigDecimal.toString());

        }


    }


    public static void main(String[] args) {
        getResult();

    }

    /**
     * 工具类
     * 去除小数的百分号，然后再判断小数个数是否符合标准
     * @param str
     * @param length
     * @return
     */
    public static BigDecimal String(String str , int length ){

        //首先去除%号
        String replaceStr = str.replace("%", "");
        //获取小数个数
        int checkLength = replaceStr.split("\\.")[1].length();
        //判断
        if (checkLength>length){
            BigDecimal bigDecimal = new BigDecimal(replaceStr);
            return bigDecimal;
        }
        return null;

    }

}
