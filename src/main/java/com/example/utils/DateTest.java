package com.example.utils;

import lombok.Data;
import lombok.experimental.var;

import java.util.*;

/**
 * @Author ： Leo
 * @Date : 2021/7/30 16:54
 * @Desc:
 */
@SuppressWarnings("all")
public class DateTest {
    /**
     * 根据时间制定时间段，按照月份分割指定时间段
     *
     * @param startTime 格式如： 2020-01-04
     * @param endTime
     * @return List<String> --> 子元素为：[2021-01, 2021-02, 2021-03]
     */
    public static List<String> monthGroup(String startTime, String endTime) {
        // 每个月份或季度对应的时间
        // 比如 按月份 k-2020-01, v- (2020-01-01 -- 2020-02-01)
        // 比如 按季度 k-2020年1季度, v- (2020-01-01 -- 2020-04-01)
        HashMap<String, StartAndEndTime> dateMap = new HashMap<>();


        List<String> dateList = new ArrayList<>();

        Date startDate = DateUtil.parseDate(startTime);
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        int startYear = startCal.get(Calendar.YEAR);//获取年份
        int startMonth = startCal.get(Calendar.MONTH) + 1;//获取月份

        Date endDate = DateUtil.parseDate(endTime);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        int endYear = endCal.get(Calendar.YEAR);//获取年份
        int endMonth = endCal.get(Calendar.MONTH) + 1;//获取月份


        int isSameYear = endYear - startYear;
        //逻辑开始
        if (isSameYear == 0) {
            for (int i = startMonth; i < endMonth + 1; i++) {
                dateMonthHandle(dateList, startYear, 0, i);
            }
            return dateList;
        } else {
            //外循环
            for (int i = 0; i < isSameYear + 1; i++) {
                if (i == 0) {
                    //第一次赋值
                    for (int i1 = startMonth; i1 <= 12; i1++) {
                        dateMonthHandle(dateList, startYear, i, i1);
                    }
                } else if (0 < i && i < isSameYear) {
                    //中间赋值
                    for (int i1 = 1; i1 <= 12; i1++) {
                        dateMonthHandle(dateList, startYear, i, i1);
                    }
                } else {
                    //最后一次赋值
                    for (int i1 = 1; i1 <= endMonth; i1++) {
                        dateMonthHandle(dateList, startYear, i, i1);
                    }
                }
            }
            return dateList;
        }

    }

    /**
     * @param list
     * @param year
     * @param addValue
     * @param judgmentValue
     */
    public static void dateMonthHandle(Map<String, StartAndEndTime> map, int year, int addValue, int judgmentValue) {
        // 阶段时间
        StartAndEndTime phaseTime = getStageDate(year, judgmentValue);
        if (judgmentValue < 10) {
            String date = (year + addValue) + "-0" + judgmentValue;
            map.put(date,phaseTime);
        } else {
            String date = (year + addValue) + "-" + judgmentValue;
            map.put(date,phaseTime);
        }
    }

    /**
     * 返回阶段时间
     *
     * @param month
     * @return
     */
    public static StartAndEndTime getStageDate(int year, int month) {

        StartAndEndTime time = new StartAndEndTime();

        switch (month) {
            case 1:
                time.setStartTime(year + "01-01");
                time.setEndTime(year + "02-01");
                break;
            case 2:
                time.setStartTime(year + "02-01");
                time.setEndTime(year + "03-01");
                break;
            case 3:
                time.setStartTime(year + "03-01");
                time.setEndTime(year + "04-01");
                break;
            case 4:
                time.setStartTime(year + "04-01");
                time.setEndTime(year + "05-01");
                break;
            case 5:
                time.setStartTime(year + "05-01");
                time.setEndTime(year + "06-01");
                break;
            case 6:
                time.setStartTime(year + "06-01");
                time.setEndTime(year + "07-01");
                break;
            case 7:
                time.setStartTime(year + "07-01");
                time.setEndTime(year + "08-01");
                break;
            case 8:
                time.setStartTime(year + "08-01");
                time.setEndTime(year + "09-01");
                break;
            case 9:
                time.setStartTime(year + "09-01");
                time.setEndTime(year + "10-01");
                break;
            case 10:
                time.setStartTime(year + "10-01");
                time.setEndTime(year + "11-01");
                break;
            case 11:
                time.setStartTime(year + "11-01");
                time.setEndTime(year + "12-01");
                break;
            case 12:
                time.setStartTime(year + "12-01");
                time.setEndTime(year + "12-31");
                break;
        }
        return time;
    }

    /**
     * @param list
     * @param year
     * @param addValue
     * @param judgmentValue
     */
    /**
     * @param list
     * @param year
     * @param addValue
     * @param judgmentValue
     */
    public static void dateMonthHandle(List<String> list, int year, int addValue, int judgmentValue) {
        if (judgmentValue < 10) {
            String date = (year + addValue) + "-0" + judgmentValue;
            list.add(date);
        } else {
            String date = (year + addValue) + "-" + judgmentValue;
            list.add(date);
        }
    }


    /**
     * 根据时间制定时间段，按照月份分割指定时间段
     *
     * @param startTime 格式如： 2020-01-04
     * @param endTime
     * @return List<String>  子元素为：[2021年1季度, 2021年2季度 2021年3季度]
     */
    public static List<String> seasonGroup(String startTime, String endTime) {
        List<String> dateList = new ArrayList<>();

        Date startDate = DateUtil.parseDate(startTime);
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        int startYear = startCal.get(Calendar.YEAR);//获取年份
        int startMonth = startCal.get(Calendar.MONTH) + 1;//获取月份

        Date endDate = DateUtil.parseDate(endTime);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        int endYear = endCal.get(Calendar.YEAR);//获取年份
        int endMonth = endCal.get(Calendar.MONTH) + 1;//获取月份

        //开始时间和结束时间，年份差值
        int isSameYear = endYear - startYear;
        int startSeasson = getSeasson(startMonth);
        int endSeasson = getSeasson(endMonth);
        //逻辑处理 -- 如：返回格式为 2020年1季度
        if (isSameYear == 0) {
            // 相同年
            int isSameSeasson = endSeasson - startSeasson;
            for (int i = 0; i < isSameSeasson + 1; i++) {
                dateSeasonHandle(dateList, startYear, 0, (startSeasson + i));
            }
            return dateList;
        } else {
            //不同年份：分为三种情况，开始日期那一年，中间这些年，结束日期那一年
            for (int i = 0; i < isSameYear + 1; i++) {
                if (i == 0) {
                    for (int i1 = startSeasson; i1 <= 4; i1++) {
                        dateSeasonHandle(dateList, startYear, i, i1);
                    }
                } else if (0 < i && i < isSameYear) {
                    for (int i1 = 1; i1 <= 4; i1++) {
                        dateSeasonHandle(dateList, startYear, i, i1);
                    }
                } else {
                    for (int i1 = 1; i1 <= endSeasson; i1++) {
                        dateSeasonHandle(dateList, startYear, i, i1);
                    }
                }
            }
            return dateList;
        }
    }

    /**
     * 根据月份获取 季度
     *
     * @param month
     * @return
     */
    public static int getSeasson(int month) {
        int quarterSeason = 0;
        if (month < 4) {
            quarterSeason = 1;
        }
        if (3 < month && month < 7) {
            quarterSeason = 2;
        }
        if (6 < month && month < 10) {
            quarterSeason = 3;
        }
        if (month > 9) {
            quarterSeason = 4;
        }
        return quarterSeason;
    }

    /**
     * 返回日期的字符串
     *
     * @param list
     * @param year
     * @param addValue
     * @param season
     */
    public static void dateSeasonHandle(List<String> list, int year, int addValue, int season) {
        String date = (year + addValue) + "年" + season + "季度";
        list.add(date);
    }


    /**
     * @param startTime
     * @param endTime
     * @return
     */
    public static Map<String, StartAndEndTime> monthGrouptoMap(String startTime, String endTime) {

        Map<String, StartAndEndTime> map = new HashMap<>();

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        Date startDate = DateUtil.parseDate(startTime);
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        int startYear = startCal.get(Calendar.YEAR);//获取年份
        int startMonth = startCal.get(Calendar.MONTH) + 1;//获取月份

        Date endDate = DateUtil.parseDate(endTime);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        int endYear = endCal.get(Calendar.YEAR);//获取年份
        int endMonth = endCal.get(Calendar.MONTH) + 1;//获取月份

        //开始时间和结束时间，年份差值
        int isSameYear = endYear - startYear;
        int startSeasson = getSeasson(startMonth);
        int endSeasson = getSeasson(endMonth);
        //逻辑处理 -- 如：返回格式为 2020年1季度
        //逻辑开始
        if (isSameYear == 0) {
            for (int i = startMonth; i < endMonth + 1; i++) {
                dateMonthHandle(map,startYear,0,i);
            }
            return map;
        } else {
            //外循环
            for (int i = 0; i < isSameYear + 1; i++) {
                if (i == 0) {
                    //第一次赋值
                    for (int i1 = startMonth; i1 <= 12; i1++) {
                        dateMonthHandle(map, startYear, i, i1);
                    }
                } else if (0 < i && i < isSameYear) {
                    //中间赋值
                    for (int i1 = 1; i1 <= 12; i1++) {
                        dateMonthHandle(map, startYear, i, i1);
                    }
                } else {
                    //最后一次赋值
                    for (int i1 = 1; i1 <= endMonth; i1++) {
                        dateMonthHandle(map, startYear, i, i1);
                    }
                }
            }
            return map;
        }


    }

    /**
     * 主方法 用于测试
     *
     * @param args
     */
    public static void main(String[] args) {
        /*System.out.println(weekStart());
        System.out.println(weekEnd());*/

       /* List<String> strings2 = monthGroup("2019-06-10", "2021-07-10");
        System.out.println(strings2);

        System.out.println("-----------------------------------");*/

       /* List<String> strings = monthGroup("2020-06-10", "2021-07-10");
        System.out.println(strings);

        System.out.println("-----------------------------------");

        List<String> strings1 = monthGroup("2021-01-10", "2021-07-10");
        System.out.println(strings1);*/

        /*List<String> seasonGroup = seasonGroup("2020-06-10", "2021-07-10");
        System.out.println(seasonGroup);

        System.out.println("-----------------------------------");


        List<String> seasonGroup1 = seasonGroup("2021-06-10", "2021-07-10");
        System.out.println(seasonGroup1);

        System.out.println("-----------------------------------");

        List<String> seasonGroup2 = seasonGroup("2019-06-10", "2021-07-10");
        System.out.println(seasonGroup2);

        System.out.println("-----------------------------------");
*/

        Map<String, StartAndEndTime> map = monthGrouptoMap("2020-06-10", "2021-07-10");

        System.out.println(map);
    }
}

@Data
class StartAndEndTime {

    private String startTime;
    private String endTime;

}