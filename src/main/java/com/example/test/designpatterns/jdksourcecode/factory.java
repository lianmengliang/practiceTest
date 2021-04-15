package com.example.test.designpatterns.jdksourcecode;

import java.util.Calendar;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 14:32
 * @Desc: 使用了简单工厂模式
 */
public class factory {
    public static void main(String[] args) {
// TODO Auto-generated method stub
// getInstance 是 Calendar 静态方法
        Calendar cal = Calendar.getInstance();
// 注意月份下标从 0 开始，所以取月份要+1
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println(" 月 :" + (cal.get(Calendar.MONTH) + 1)); System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));

    }
}
