package com.example.test;


import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Author ： Leo
 * @Date : 2020/11/30 15:59
 * @Desc:
 */
public class testDate {

    /**
     * new DateTime() 的基础知识
     */
    public static void basePonint() {

        DateTime dt = new DateTime();

        //获取年
        int year = dt.getYear();
        System.out.println(year);
        //获取月
        int month = dt.getMonthOfYear();
        System.out.println(month);
        //获取日
        int day = dt.getDayOfMonth();
        //一年的第几天 ---> 335
        System.out.println("year--" + dt.getDayOfYear());
        //一月的第几天 ---> 30
        System.out.println("month---" + day);
        //一周的第几天 ---> 1
        System.out.println("week---" + dt.getDayOfWeek());
        //获取星期
        int week = dt.getDayOfWeek();
        System.out.println(week);


        //获取点
        int hour = dt.getHourOfDay();
        System.out.println(hour);

        //获取分
        int minute = dt.getMinuteOfHour();
        System.out.println("minute---" + minute);
        System.out.println("2minute---" + dt.getMinuteOfDay());

        //获取秒
        int second = dt.getSecondOfMinute();
        System.out.println(second);
        System.out.println("second2---" + dt.getSecondOfDay());

        //获取毫秒
        int millis = dt.getMillisOfSecond();
        System.out.println(millis);

    }

    /**
     * 星期处理
     */
    public static void weekHandle() {
        DateTime dt = new DateTime();

        switch (dt.getDayOfWeek()) {
            case DateTimeConstants.SUNDAY:
                System.out.println("星期日");
                break;
            case DateTimeConstants.MONDAY:
                System.out.println("星期一");
                break;
            case DateTimeConstants.TUESDAY:
                System.out.println("星期二");
                break;
            case DateTimeConstants.WEDNESDAY:
                System.out.println("星期三");
                break;
            case DateTimeConstants.THURSDAY:
                System.out.println("星期四");
                break;
            case DateTimeConstants.FRIDAY:
                System.out.println("星期五");
                break;

        }
    }

    public static String getWeekByDateTime() {
        DateTime dt = new DateTime();

        System.out.println(dt.toString("EEEE dd MMMM yyyy HH:mm:ss a"));

        String weekResult = dt.toString("EEEE dd MMMM yyyy HH:mm:ss a").split(" ")[0];
        System.out.println(weekResult);
        return weekResult;
    }

    /**
     * 日期处理
     */
    public static void dateHandle() {

        /**
         * 日期格式化： hh:12小时制， HH:24小时制
         */
        DateTime dt = new DateTime();

        //2020/11/30 04:38:44.18下午
        System.out.println(dt.toString("yyyy/MM/dd hh:mm:ss.SSa"));

        //2020-11-30 16:38:44
        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss EEEE a"));

        //星期一 30 十一月 , 2020 16:38:44 下午
        System.out.println(dt.toString("EEEE dd MMMM yyyy HH:mm:ss a"));

        //2020/11/30 16:38 Asia/Shanghai
        System.out.println(dt.toString("yyyy/MM/dd HH:mm ZZZZ"));

        //2020/11/30 16:38 +0800
        System.out.println(dt.toString("yyyy/MM/dd HH:mm Z"));

        //拆分日期  时间+星期+上下午
        String dateStr = dt.toString("yyyy-MM-dd HH:mm:ss EEEE a");
        String[] s = dateStr.split(" ");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }


        /**
         * dt.miusXXX(int param)  之前的年 月 日 星期 时分秒
         * dt.plusXXX(int param)  之后的年 月 日 星期 时分秒
         *
         */
        //昨天
        DateTime yesterday = dt.minusDays(1);
        System.out.println("yesterday--:" + yesterday.toString("yyyy-MM-dd HH:mm:ss"));
        //明天
        DateTime tomorrow = dt.plusDays(1);
        System.out.println("tomorrow---:" + tomorrow.toString("yyyy-MM-dd HH:mm:ss"));
        //明天
        DateTime afterTwoWeeks = dt.plusWeeks(2);
        System.out.println("afterTwoWeeks---:" + afterTwoWeeks.toString("yyyy-MM-dd HH:mm:ss"));
        //1个月前
        DateTime beforeOneMonth = dt.minusMonths(1);
        System.out.println("beforeOneMonth----:" + beforeOneMonth.toString("yyyy-MM-dd HH:mm:ss"));
        //3个月前
        DateTime beforeThreeMonth = dt.minusMonths(3);
        System.out.println("beforeThreeMonth-----:" + beforeThreeMonth.toString("yyyy-MM-dd HH:mm:ss"));
        //2年前
        DateTime beforeTwoYears = dt.minusYears(2);
        System.out.println("beforeTwoYears------:" + beforeTwoYears.toString("yyyy-MM-dd HH:mm:ss"));
        //2月后
        DateTime afterTwoMonths = dt.plusMonths(3);
        System.out.println("afterTwoMonths-------:" + afterTwoMonths.toString("yyyy-MM-dd HH:mm:ss"));
        //2年后
        DateTime afterTwoYears = dt.plusYears(2);
        System.out.println("afterTwoYears---------:" + afterTwoYears.toString("yyyy-MM-dd HH:mm:ss"));

    }

    /**
     * 日期比较：
     */
    public static void dateComparison() {
        DateTime dTime1 = new DateTime("2020-10-12");
        DateTime dTime2 = new DateTime("2020-10-19");

        //和系统日期相比
        boolean afterNow = dTime1.isAfterNow();
        boolean isBeforeNow = dTime1.isBeforeNow();
        boolean isEqualNow = dTime1.isEqualNow();

        System.out.println(afterNow);
        System.out.println(isBeforeNow);
        System.out.println(isEqualNow);
        System.out.println("---------------");
        //和其他日期相比
        boolean after = dTime1.isAfter(dTime2);
        boolean before = dTime1.isBefore(dTime2);
        boolean equal = dTime1.isEqual(dTime2);

        System.out.println(after);
        System.out.println(before);
        System.out.println(equal);
    }

    /**
     * java Date  和 joda互换 --
     */
    public static void dateTimeExchangeToJavaDate(){
        
        // Date 转换为 DateTime
        Date date = new Date();
        DateTime dateTime = new DateTime(date);
        System.out.println("Date to DateTime : " + "date:"+date + "---->DateTime:"+ dateTime);


        System.out.println(dateTime.toString("yyyy/MM/dd HH:mm:ss"));
        System.out.println(dateTime.toString("yyyy-MM-dd"));


        DateTime dateTime1 = new DateTime();
        Date toDate = dateTime1.toDate();
        System.out.println("DateTime to Date : " + "DateTime:"+ dateTime + "---->date:"+date);


    }




    /**
     * 运行 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
       /* basePonint();
        System.out.println("-------------------");
        weekHandle();
        System.out.println("------------------");
        dateHandle();
        System.out.println("------------------");
        dateComparison();
        System.out.println("------------------");


        Date date = new Date();
        System.out.println("date=" + date);
        DateTime dt = new DateTime();
        System.out.println("dt=" + dt);*/

        dateTimeExchangeToJavaDate();
    }
}
