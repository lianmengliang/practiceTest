package com.example.test;

import java.math.BigDecimal;

/**
 * @Author ： leo
 * @Date :2020/5/21 20:43
 */
public class testBigDecima {
    public static void main(String[] args) {
        getBigDecimalResult();


    }


    public static void getBigDecimalResult(){
        Double d1 = 1233.555;
        /*
         * 这里有个坑，new BigDecimal的时候参数不要传Double类型，要转成String类型
         * 参数Double类型：实际bd=1233.555000000000063664629124104976654052734375
         * 参数String类型：实际bd=1233.555
         */
        BigDecimal bd = new BigDecimal(d1.toString());
        System.out.println(bd);


        // 进1 -->1233.56
        System.out.println("进1：" + bd.setScale(2, BigDecimal.ROUND_UP).toString());
        // 退1 -->1233.55
        System.out.println("退1：" + bd.setScale(2, BigDecimal.ROUND_DOWN).toString());
        // >=.5进1 -->1233.56
        System.out.println(">=.5进1：" + bd.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        // >.5进1    -->1233.55
        System.out.println(">.5进1：" + bd.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
        // 进1截取:正数则ROUND_UP，负数则ROUND_DOWN   -->1233.56
        System.out.println("进1截取：" + bd.setScale(2, BigDecimal.ROUND_CEILING).toString());
        // 退1截取:正数则ROUND_DOWN，负数则ROUND_UP   -->1233.55
        System.out.println("退1截取：" + bd.setScale(2, BigDecimal.ROUND_FLOOR).toString());
    }

    public static void BigDecimalTurnOthers(){

        Double d = 1233.555500;

        BigDecimal bd = new BigDecimal("12.356");

        System.out.println(d);
        System.out.println(bd);

        System.out.println();


    }
}
