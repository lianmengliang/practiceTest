package com.example.test.test_demo;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * @Author ： Leo
 * @Date : 2021/10/14 11:36
 * @Desc: 用于临时测试 或 间接通过这里去学习源码
 */
public class TestDemo001 {
    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("10 *(2+1)*1+66");
        int result = (int) expression.getValue();
        System.out.println(result);

        demo001();
    }


    /**
     * 測試 字符串
     */
    public static void demo001() {

        // StringBuffer reverse
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("abcdefg");
        System.out.println(stringBuffer.reverse()); // gfedcba
// StringBuilder reverse
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abcdefg");
        System.out.println(stringBuilder.reverse()); // gfedcba


        String value = " ";
        boolean blank = StringUtils.isBlank(value);
        System.out.println(blank);

        String trim = value.trim();

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


}


abstract class ABC {

    abstract  void getR();

    public void getResult(){

    }
}