package com.example.test;

import com.example.practice.model.ScoreInfo;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author ： leo
 * @Date :2020/4/27 19:05
 */
public class testBeanToMap {


    private static void buildStuScoreList() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ScoreInfo score = new ScoreInfo("张三", 123, 122, 132);
        /*ScoreInfo score2 = new ScoreInfo("王二",123,90,129);
        ScoreInfo score3 = new ScoreInfo("李四",109,138,86);
        ScoreInfo score4 = new ScoreInfo("麻子",89,98,96);*/

        Map<String, String> keyValues = BeanUtils.describe(score);
        for (String in : keyValues.keySet()) {

            //map.keySet()返回的是所有key的值
            String str = keyValues.get(in);//得到每个key多对用value的值
            System.out.println(in + " = " + str);
        }

//        keyValues.forEach();

        System.out.println(keyValues);
    }


    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        buildStuScoreList();
    }
}
