package com.example.test;

/**
 * @Author ： Leo
 * @Date : 2020/9/11 14:31
 * @Desc:
 */
public class test0001 {

    public static void main(String[] args) {


        for (int i = 0; i < 1; i++) {
            System.out.println("跳过了");
            System.out.println("没跳过");
            for1:
            for (int j = 0; j < 3; j++) {
                for2:
                for (int m = 0; m < 3; m++) {
                    for3:
                    if (m == 1) {
                        break for1;
                    }
                    System.out.println(i + "--" + j + "--" + m);
                }
//                System.out.println(i + "--" + j + "--");

            }
        }


    }
}
/*

0--0--
0--1--
0--2--
1--0--
1--1--
1--2--*/
