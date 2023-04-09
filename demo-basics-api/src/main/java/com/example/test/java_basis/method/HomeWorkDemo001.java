package com.example.test.java_basis.method;

import java.util.Arrays;
import java.util.Scanner;

/**
 * lianmengliang
 * <p>
 * 5/6/22 10:48 PM
 */
@SuppressWarnings("all")
public class HomeWorkDemo001 {
    public static void main(String[] args) {
        testResult();

    }


    public static void testResult() {
        //1.用户输入三个数
        Scanner scanner = new Scanner(System.in);

        //记录用户输入的数值
        int[] userNum = new int[3];
        //记录电脑输入的数值
        int[] computerNum = new int[3];


        //记录用户赢的次数
        int winNum = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("请在0-2之间输入一个数字：");
            int num1 = scanner.nextInt();
            userNum[i] = num1;
            //0-2之间 电脑随机生成一个数
            int num2 = (int) (Math.random() * 3);
            computerNum[i] = num2;
            //如何判断用户赢呢？  逻辑
            if (num1 <= 1) {
                if ((num1 - num2) == -1) {
                    winNum++;
                }
            } else {
                if ((num1 - num2) == 2) {
                    winNum++;
                }
            }
        }

        System.out.println("Tom赢的次数为：" + winNum + "次");

        System.out.println("用户输入的数值：" + Arrays.toString(userNum));
        System.out.println("电脑自动生成的数值：" + Arrays.toString(computerNum));
    }


    /*public static void testResult1() {
        //1.用户输入三个数
        Scanner scanner = new Scanner(System.in);

        //记录用户输入的数值
        int[] userNum = new int[3];
        //记录电脑输入的数值
        int[] computerNum = new int[3];


        //记录用户赢的次数
        int winNum = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("请在0-2之间输入一个数字：");
            int num1 = scanner.nextInt();
            userNum[i] = num1;
            //0-2之间 电脑随机生成一个数
            int num2 = (int) (Math.random() * 3);
            computerNum[i] = num2;
            //如何判断用户赢呢？  逻辑
            if (num1 <= 1) {
                if ((num1 - num2) == -1) {
                    winNum++;
                }
            } else {
                if ((num1 - num2) == 2) {
                    winNum++;
                }
            }
        }

    }*/
}
@SuppressWarnings("all")
class UserVsComputer {

    int userNum;

    int comNum;

//    int winNum;

    public int handNum(int winNum) {
        if (userNum <= 1) {
            if ((userNum - comNum) == -1) {
                winNum++;
            }
        } else {
            if ((userNum - comNum) == 2) {
                winNum++;
            }
        }
        return winNum;
    }
}