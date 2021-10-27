package com.example.utils;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * PACKAGE_NAME:com.xq.mgxq.util
 * AUTHOR: hexOr
 * DATE :2019/3/11 19:56
 * DESCRIPTION:
 */
public class SMSCodeUtil {
    public static final  String base = "0123456789";

    public static void main(String[] args) {
        System.out.println(getRandomString(4));
    }

    /***
     * 随机获得
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
