package com.example.utils;

import com.example.encryptionUtil.MD5Utils;

import java.util.Random;

/**
 * @Author ： Leo
 * @Date : 2020/8/6 11:50
 * @Desc:
 */
public class RandomNumberUtils {


    public static void main(String[] args) {
        String code = getCode();
        System.out.println(code);
    }


    // 4-->10-->22-->46
    public static String getCode() {
//        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String str = "0123456789";

        Integer a = 1;
        StringBuilder sb = new StringBuilder(6);
        System.out.println(sb.capacity());
        for (int i = 0; i < 17; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        System.out.println(sb.toString());
        System.out.println(sb.capacity());
        String code = sb.toString();
        return code;
    }
}
