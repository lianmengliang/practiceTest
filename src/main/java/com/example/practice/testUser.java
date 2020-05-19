package com.example.practice;

import com.example.practice.model.ScoreInfo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ： leo
 * @Date :2020/5/19 11:27
 */
public class testUser {



    private static void getResult(){
        ScoreInfo score1 = new ScoreInfo("张三", 1, 122, 132);
        ScoreInfo score2 = new ScoreInfo("王二",2,90,129);
        ScoreInfo score3 = new ScoreInfo("李四",null,138,86);
        ScoreInfo score4 = new ScoreInfo("麻子",3,98,96);
        ScoreInfo score5 = new ScoreInfo("麻子",4,98,96);
        ScoreInfo score6 = new ScoreInfo("麻子",3,98,96);
        ScoreInfo score7 = new ScoreInfo("麻子",null,98,96);
        ScoreInfo score8 = new ScoreInfo("麻子",21,98,96);

        /**
         * 把实体类 转化为 集合
         */
        List<ScoreInfo> scoreInfoList = Arrays.asList(score1,score2,score3,score4,score5,score6,score7,score8);

        List<ScoreInfo> list = new ArrayList<>();

        for (ScoreInfo scoreInfo : scoreInfoList) {
            if (scoreInfo.getChinese()!=null){
                list.add(scoreInfo);
            }
        }

        System.out.println(list);

        List<ScoreInfo> collect = list.stream()
                .filter(item -> item.getChinese() == 1 || item.getChinese() == 2 || item.getChinese() == 3)
                .collect(Collectors.toList());
        System.out.println(collect);
        /*List<ScoreInfo> result = scoreInfoList.stream()
                .filter(item ->item.getChinese() == 1 || item.getChinese() == 2 || item.getChinese() == 3 )
                .collect(Collectors.toList());

        System.out.println(result);*/

    }



    public static void main(String[] args) {

        getResult();

        Map<String, String> map = new HashMap<>();

        int a = 2 ;


    }
}
