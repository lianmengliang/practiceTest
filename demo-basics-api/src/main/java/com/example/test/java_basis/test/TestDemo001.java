package com.example.test.java_basis.test;

import java.util.Scanner;

/**
 * lianmengliang
 * <p>
 * 2022-04-10 11:19
 */
public class TestDemo001 {
    public static void main(String[] args) {


        test006();
    }

    private static void test001() {
        //for循环练习
        int i = 0;
        int j = 8;
        for (; i < j; i++) {
            System.out.println(i + " + " + (j - i) + " = " + j);
        }

    }


    public static void test002() {
        int i = 1;
        while (i <= 100) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
            i++;
        }
        System.out.println("结束循环1...");


        int j = 1;
        while (j <= 100) {
            if (j % 2 == 0) {
                System.out.println(j);
            }
            j++;
        }


        System.out.println("结束循环2....");

    }

    /**
     * 练习多重循环：输入班级分数
     */
    public static void test003() {
        Scanner scanner = new Scanner(System.in);

        // 初始化数据：
        // 初始化总分
        double totalScore = 0;
        //初始化几个班级
        int classNum = 3;
        // 初始化每个班级的人数，暂定每班人数都一样
        int stuNum = 5;
        // 初始化及格人数
        int passNum = 0;

        for (int i = 1; i <= classNum; i++) {
            double sumScore = 0.0;
            for (int i1 = 1; i1 <= stuNum; i1++) {
                System.out.println("请输入第" + i + "班的第" + i1 + "个学生的成绩: ");
                double score = scanner.nextDouble();

                // 判断学生是否及格
                if (score > 60.0) {
                    passNum++;
                }
                System.out.println("第" + i1 + "个学生的成绩为:" + score);
                sumScore += score;
            }
            System.out.println("第" + i + "个班的总分为：" + sumScore + ",平均分为：" + (sumScore / 5));
            totalScore += sumScore;
        }
        System.out.println("班级的总分为：" + totalScore +
                ",平均分为：" + (totalScore / (classNum * stuNum)) +
                ",及格人数为：" + passNum);

    }

    /**
     * 打印 九九 乘法口诀
     */
    public static void test004() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }


    /**
     * 打印空心金字塔
     */
    public static void test005() {

        // 初始化层数
        int totalLevel = 5;
        //假设5层
        for (int i = 1; i <= totalLevel; i++) {

            // 打印空格
            for (int g = 1; g <= totalLevel - i; g++) {
                System.out.print(" ");
            }

            // 打印星
            for (int j = 1; j <= 2 * i - 1; j++) {

                if (j == 1 || j == 2 * i - 1 || i == totalLevel) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

    }

    /**
     * 作业打印出 空心菱形
     */
    public static void test006() {


        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
