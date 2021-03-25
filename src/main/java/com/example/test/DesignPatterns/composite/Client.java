package com.example.test.DesignPatterns.composite;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 11:37
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {

        // 首先创建大学
        OrganizationComponent university = new University("北京大学", "中国顶级学府");

        // 创建学院
        OrganizationComponent computerCollege = new College("计算机学院", "计算机学院。。。");
        OrganizationComponent biologycollege = new College("生物工程学院", "生物技术创造美好生活");

        // 创建专业系
        // 计算机系
        OrganizationComponent computerDepartment1 = new Department("软件工程系", "开发有前途");
        OrganizationComponent computerDepartment2 = new Department("网络工程", "w网上冲浪速度杠杠滴");
        OrganizationComponent computerDepartment3= new Department("计算机科学与技术", " 计算机科学与技术是老牌的专业 ");
        // 生物系
        OrganizationComponent biologyDepartment1 =new Department("生物工程","主要是制药方向");
        OrganizationComponent biologyDepartment2 =new Department("农学","搞搞农作物啦");

        // 创建班级
        computerDepartment1.add(new Classes("软件工程1班","篮球爱好者"));
        computerDepartment1.add(new Classes("软件工程2班","音乐发烧友"));
        computerDepartment1.add(new Classes("软件工程3班","码农代表"));
        computerDepartment1.add(new Classes("软件工程4班","闷骚组合"));

        biologyDepartment1.add(new Classes("生物工程1班","活跃分子"));
        biologyDepartment1.add(new Classes("生物工程2班","调皮分子"));
        biologyDepartment1.add(new Classes("生物工程3班","捣蛋分子"));
        biologyDepartment1.add(new Classes("生物工程4班","温柔分子"));
        // 再创建系
       /* computerCollege.add(new Department("软件工程系", "开发有前途"));
        computerCollege.add(new Department("网络工程", "w网上冲浪速度杠杠滴"));
        computerCollege.add(new Department("计算机科学与技术", " 计算机科学与技术是老牌的专业 "));

        biologycollege.add(new Department("生物工程","主要是制药方向"));
        biologycollege.add(new Department("农学","搞搞农作物啦"));*/



        // 将学院加到学校中
        university.add(computerCollege);
        university.add(biologycollege);

        computerCollege.add(computerDepartment1);
        computerCollege.add(computerDepartment2);
        computerCollege.add(computerDepartment3);

        biologycollege.add(biologyDepartment1);
        biologycollege.add(biologyDepartment2);

        // 将班级加到专业中

        // 打印输出
        university.print();


        Map<Integer, String> map = new HashMap<>();

    }
}
