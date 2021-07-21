package com.test.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明: Date工具类<br>
 *
 * @author ReveeWu
 */
@Slf4j
public abstract class DateUtil extends DateUtils {
    public static final String DAY = "yyyyMMdd";
    public static final String DATE_DAY = "MMdd";
    public static final String DRAW_SECOND_FORMAT = "yyyy-MM";
    public static final String DATE_FORMAT_SPRT = "yyyy.MM.dd";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_NO_DELIMITER = "yyyyMMdd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String TIME_FORMAT_NO_SEC = "HH:mm";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
    public static final String DATE_TIME_FORMAT_NO_SEC = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT_NO_DELIMITER = "yyyyMMddHHmmss";
    public static final String DATE_PRECISE_TO_MINUTE = "yyyyMMddHHmm";
    public static final String MONTH_DAY_AND_TIME = "MMdd HH:mm";
    public static final String[] WEEKS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public static final String[] DEFAULT_FORMATS = {TIMESTAMP_FORMAT, DATE_TIME_FORMAT, DATE_FORMAT, TIME_FORMAT, DATE_PRECISE_TO_MINUTE};

    public static void main(String[] args) {
        System.out.println(weekStart());
        System.out.println(weekEnd());
    }

    /**
     * 时间计算
     *
     * @param date
     * @param value
     * @param timeUnit
     * @return
     */
    public static Date add(Date date, long value, TimeUnit timeUnit) {
        return new Date(date.getTime() + timeUnit.toMillis(value));
    }

    /**
     * 获取日期开始时间
     *
     * @param date
     * @return
     */
    public static Date dayStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static Date dayEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public static Date todayStart() {
        return dayStart(new Date());
    }

    public static Date tomorrowStart() {
        return add(todayStart(), 1, TimeUnit.DAYS);
    }

    public static Date yesterdayStart() {
        return add(todayStart(), -1, TimeUnit.DAYS);
    }

    public static Date todayEnd() {
        return dayEnd(new Date());
    }

    public static Date tomorrowEnd() {
        return add(todayEnd(), 1, TimeUnit.DAYS);
    }

    public static Date yesterdayEnd() {
        return add(todayEnd(), -1, TimeUnit.DAYS);
    }

    public static Date parse(String dateString, String... dateFormat) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }

        try {
            if (dateFormat == null || dateFormat.length == 0) {
                return DateUtils.parseDate(dateString, DEFAULT_FORMATS);
            } else {
                return DateUtils.parseDate(dateString, dateFormat);
            }
        } catch (ParseException e) {
            log.error("转换为日期出错", e);
            return null;
        }
    }

    public static Date parseDate(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }

        return parse(dateString, DATE_FORMAT);
    }

    /**
     * 取指定格式的当前时间字符串
     *
     * @param dateFormat
     * @return
     */
    public static String getCurrentTime(String dateFormat) {
        Date date = new Date();
        return format(date, dateFormat);
    }

    /**
     * 将字符串转换成Date类型
     *
     * @param dateString
     * @param dateFormat
     * @return
     */
    public static Date parse(String dateString, String dateFormat) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        try {
            return DateUtils.parseDate(dateString, dateFormat);
        } catch (ParseException e) {
            log.error("日期格式化异常", e);
            return null;
        }
    }

    /**
     * 将Date类型转化成字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String format(Date date, String dateFormat) {
        if (date == null) {
            return "";
        } else {
            return DateFormatUtils.format(date, dateFormat);
        }
    }

    public static String formatDateTime(Date date) {
        return format(date, DATE_TIME_FORMAT);
    }

    public static String formatDate(Date date) {
        return format(date, DATE_FORMAT);
    }

    public static String formatDatePure(Date date) {
        return format(date, DAY);
    }

    /**
     * 在传入的日期基础上往后加n天
     *
     * @param date
     * @param n    要加的天数
     * @return
     */
    public static Date addDay(Date date, int n) {
        return DateUtils.addDays(date, n);
    }

    /**
     * 判断当前时间是否在开始时间与结束时间之间
     *
     * @param time  当前时间
     * @param begin 开始时间
     * @param end   结束时间
     * @return boolen类型，true表示在两者间，false表示不在两者之间
     */
    public static boolean isTimeIn(Date time, Date begin, Date end) {
        return time.getTime() >= begin.getTime() && time.getTime() <= end.getTime();
    }

    /**
     * 判断指定日期是星期几
     *
     * @param time   要判断的日期
     * @param format 输入的日期格式
     * @return 返回数字[1:星期一，2：星期二，....，7：星期日]
     * @throws ParseException
     */
    public static int getWeek(String time, String format) throws ParseException {
        return getWeek(DateUtils.parseDate(time, format));
    }

    /**
     * 判断指定日期是星期几
     *
     * @param date 要判断的日期
     * @return 返回数字[1:星期一，2：星期二，....，7：星期日]
     * @throws ParseException
     */
    public static int getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int week = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            week = 7;
        } else {
            week = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return week;
    }

    /**
     * 获取当前周的第一天(周一)
     *
     * @return
     */
    public static Date weekStart() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, 2);
        return dayStart(cal.getTime());
    }

    /**
     * 获取当前周的最后一天(周日)
     *
     * @return
     */
    public static Date weekEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, 7);
        cal.add(Calendar.DATE, 1);
        return dayEnd(cal.getTime());
    }

    /**
     * 判断传入的字符串dateStr是否是日期格式patternStr的字符串 @author yejg
     *
     * @param dateStr
     * @param patternStr
     * @return
     */
    public static boolean isDateFormat(String dateStr, String patternStr) {
        Date date = null;
        try {
            date = parse(dateStr, patternStr);
        } catch (Exception e) {
        }

        return date == null ? false : true;
    }

    /**
     * 将字符串日期转成Timestamp类型
     *
     * @param dateString 字符串类型的时间
     * @param format     字符串类型的时间要转换的格式
     * @return Timestamp类型的时间戳
     * @throws ParseException
     */
    public static java.sql.Timestamp parse2Timestamp(String dateString, String format) throws ParseException {
        return new java.sql.Timestamp(DateUtils.parseDate(dateString, format).getTime());
    }

    /**
     * 获取量时间之间的毫秒数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getIntervalMills(Date startTime, Date endTime) {
        if (null != startTime && null != endTime) {
            long end = endTime.getTime();
            long start = startTime.getTime();
            return end - start;
        }
        return 0;
    }

    /**
     * 获取两个日期之间间隔的秒数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long getIntervalSeconds(Date startTime, Date endTime) {
        return getIntervalMills(startTime, endTime) / 1000;
    }

    /**
     * 获取两个日期之间间隔的分钟数
     *
     * @param startDate
     * @param endDate
     * @return
     * @author zhougz
     */
    public static long getIntervalMinutes(Date startDate, Date endDate) {
        return getIntervalSeconds(startDate, endDate) / 60;
    }

    /**
     * 获取两个日期之间间隔的小时数
     *
     * @param startDate
     * @param endDate
     * @return
     * @author zhougz
     */
    public static long getIntervalHours(Date startDate, Date endDate) {
        return getIntervalMinutes(startDate, endDate) / 60;
    }

    /**
     * 获取两个日期之间间隔的天数
     *
     * @param startTime
     * @param endTime
     * @return
     * @author sunyy
     */
    public static int getIntervalDay(Date startTime, Date endTime) {
        return (int) getIntervalHours(dayStart(startTime), dayStart(endTime)) / 24;
    }

    /**
     * 时间点是否在区间内
     *
     * @param time
     * @param start
     * @param end
     * @return
     */
    public static boolean between(Date time, Date start, Date end) {
        if (null == time || null == start || null == end) {
            throw new IllegalArgumentException("参数不能为null");
        }
        return time.after(start) && time.before(end);
    }

    /**
     * 比较日期是否在区间内
     *
     * @param time
     * @param start
     * @param end
     * @return
     */
    public static boolean dateBetween(Date time, Date start, Date end) {
        if (null == time || null == start || null == end) {
            throw new IllegalArgumentException("参数不能为null");
        }
        return between(DateUtil.dayStart(time), DateUtil.dayStart(start), DateUtil.dayEnd(end));
    }

    /**
     * 时间处理,只返回年月日
     */
    public static Date gyroActiveCreateTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        String sDate = simpleDateFormat.format(date);
        Date newDate = null;
        try {
            newDate = simpleDateFormat.parse(sDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newDate;
    }

    /**
     * 根据指定的单位计算到另一个日期时间的时间量
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long until(LocalDateTime d1, LocalDateTime d2) {
        return d1.until(d2, ChronoUnit.MILLIS);
    }

    /**
     * 判断时间是否相等
     */
    public static boolean timeEqual(Date time1, Date time2) {
        String day1 = format(time1, DAY);
        String day2 = format(time2, DAY);
        return day1.equals(day2);
    }

}
