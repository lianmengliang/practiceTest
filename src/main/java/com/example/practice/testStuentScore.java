package com.example.practice;

import com.example.practice.model.ScoreInfo;
import com.example.practice.model.StudentScore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ： leo
 * @Date :2020/4/26 10:47
 *
 * 求各同学的 总分
 */
public class testStuentScore {

    public static void main(String[] args) throws JsonProcessingException {
        testScoreInfo();
//        getScoreBymethod1();
       // getScoreBymethod2();

        Map<String, String> map = new HashMap<>();
        map.put("c", "ccccc");
        map.put("a", "ddddd");
        map.put("b", "bbbbb");
        map.put("d", "aaaaa");

        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }
        //升序排序
        //Collections.sort(list, Comparator.comparing(Map.Entry::getValue));

        Comparator<Map.Entry<String, String>> cmp = (arg0, arg1) -> arg1.getValue().compareTo(arg0.getValue());

        Collections.sort(list,cmp);

        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }


    }


    private static List<StudentScore> buildATestList() {
        List<StudentScore> studentScoreList = new ArrayList<>();
        StudentScore studentScore1 = new StudentScore() {{
            setStuName("张三");
            setSubject("语文");
            setScore(70);
        }};
        StudentScore studentScore2 = new StudentScore() {{
            setStuName("张三");
            setSubject("数学");
            setScore(80);
        }};
        StudentScore studentScore3 = new StudentScore() {{
            setStuName("张三");
            setSubject("英语");
            setScore(65);
        }};
        StudentScore studentScore4 = new StudentScore() {{
            setStuName("李四");
            setSubject("语文");
            setScore(68);
        }};
        StudentScore studentScore5 = new StudentScore() {{
            setStuName("李四");
            setSubject("数学");
            setScore(70);
        }};
        StudentScore studentScore6 = new StudentScore() {{
            setStuName("李四");
            setSubject("英语");
            setScore(90);
        }};
        StudentScore studentScore7 = new StudentScore() {{
            setStuName("王五");
            setSubject("语文");
            setScore(80);
        }};
        StudentScore studentScore8 = new StudentScore() {{
            setStuName("王五");
            setSubject("数学");
            setScore(85);
        }};
        StudentScore studentScore9 = new StudentScore() {{
            setStuName("王五");
            setSubject("英语");
            setScore(70);
        }};

        studentScoreList.add(studentScore1);
        studentScoreList.add(studentScore2);
        studentScoreList.add(studentScore3);
        studentScoreList.add(studentScore4);
        studentScoreList.add(studentScore5);
        studentScoreList.add(studentScore6);
        studentScoreList.add(studentScore7);
        studentScoreList.add(studentScore8);
        studentScoreList.add(studentScore9);

        return studentScoreList;
    }

    public static void getScoreBymethod1() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        List<StudentScore> studentScores = buildATestList();

        Map<String, Integer> studentScoreMap = new HashMap<>();

        /*studentScores.stream()
                .filter(studentScore ->
                studentScoreMap.containsKey(studentScore.getStuName()))
                .forEach(studentScore ->
                        studentScoreMap.put(studentScore.getStuName(),
                studentScoreMap.get(studentScore.getStuName()) + studentScore.getScore()));*/
        studentScores.forEach(studentScore -> {
            if (!studentScoreMap.containsKey(studentScore.getStuName())) {
                studentScoreMap.put(studentScore.getStuName(), studentScore.getScore());
            } else {
                studentScoreMap.put(studentScore.getStuName(),
                        studentScoreMap.get(studentScore.getStuName())+studentScore.getScore());
            }
        });
        List<Map.Entry<String,Integer>> studentScoresList = new ArrayList<>(studentScoreMap.entrySet());
        //按照key 进行排序
        Collections.sort(studentScoresList, Comparator.comparing(Map.Entry::getKey));
        System.out.println("method1"+objectMapper.writeValueAsString(studentScoreMap));
    }

    public static void getScoreBymethod2(){
        List<StudentScore> studentScores = buildATestList();

        Map<String, Integer> studentScoreMap;

        ObjectMapper objectMapper = new ObjectMapper();


        try {
            /*studentScores.forEach(studentScore ->
                studentScoreMap.merge(
                        studentScore.getStuName(),
                        studentScore.getScore(),
                        Integer::sum
                )
            );*/
            studentScoreMap = studentScores.stream()
                    .collect(Collectors
                            .toMap(
                                    StudentScore::getStuName,
                                    StudentScore::getScore,
                                    Integer::sum)
                    );
            System.out.println("method2"+ objectMapper.writeValueAsString(studentScoreMap));
            List<Map.Entry<String,Integer>> studentScoresList = new ArrayList<>(studentScoreMap.entrySet());
            //按照key 进行排序
//            Collections.sort(studentScoresList, Comparator.comparing(Map.Entry::getKey));
            Collections.sort(studentScoresList, (o1, o2) -> o2.getKey().compareTo(o1.getKey()));


//            Collections.sort(studentScoresList, (o1, o2) -> - o1.getValue()-o2.getValue());
            //Collections.sort(studentScoresList,Comparator.comparing(Map.Entry::getValue));



            System.out.println("method2"+ objectMapper.writeValueAsString(studentScoreMap));
            for (Map.Entry<String, Integer> mapping : studentScoresList) {
                System.out.println(mapping.getKey() + ":" + mapping.getValue());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 需求：
     * 计算这个四个同学的总分，并且分别按照 分数排序 和 名字升序排序
     * @return
     */
    private static List<ScoreInfo> buildStuScoreList() {
        ScoreInfo score1 = new ScoreInfo("张三", 123, 122, 132);
        ScoreInfo score2 = new ScoreInfo("王二",123,90,129);
        ScoreInfo score3 = new ScoreInfo("李四",109,138,86);
        ScoreInfo score4 = new ScoreInfo("麻子",89,98,96);

        /**
         * 把实体类 转化为 集合
         */
        List<ScoreInfo> scoreInfoList = Arrays.asList(score1,score2,score3,score4);

        return scoreInfoList;
    }


    public static void testScoreInfo(){

        List<ScoreInfo> scoreInfoList = buildStuScoreList();

        //Map 用于存放计算总分后的 学生姓名 和 总分数
        Map<String, Integer> studentScoreMap = new HashMap<>();

        //计算学生总分，再放到Map集合中
        /*for (ScoreInfo scoreInfo : scoreInfoList) {
            studentScoreMap.put(scoreInfo.getName(),
                    scoreInfo.getChinese()+scoreInfo.getChinese()+scoreInfo.getMath());
        }*/

        //计算学生总分，再放到Map集合中
        scoreInfoList.forEach(scoreInfo ->
                studentScoreMap.merge(
                        scoreInfo.getName(),
                        scoreInfo.getMath()+scoreInfo.getChinese()+scoreInfo.getEnglish(),
                        Integer::sum

                ));

        List<Map.Entry<String,Integer>> studentScoresList = new ArrayList<>(studentScoreMap.entrySet());
        for (Map.Entry<String, Integer> mapping : studentScoresList) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }

        System.out.println("---------------------------------------------------------------------");

        //根据总分 升序排列
        Collections.sort(studentScoresList, Comparator.comparingInt(Map.Entry::getValue));
        //根据总分 降序排列
        Collections.sort(studentScoresList,(o1,o2)-> o2.getValue()-o1.getValue());

        //根据名字 升序排列
        Collections.sort(studentScoresList, Comparator.comparing(Map.Entry::getKey));
        //根据名字 降序排列
        Collections.sort(studentScoresList,(o1,o2)->o2.getKey().compareTo(o1.getKey()));

        //遍历 输出
        for (Map.Entry<String, Integer> mapping : studentScoresList) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }

    }
}
