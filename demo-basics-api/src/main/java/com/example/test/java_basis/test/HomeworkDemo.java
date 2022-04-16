package com.example.test.java_basis.test;

/**
 * lianmengliang
 * <p>
 * 2022-04-13 20:58
 */
@SuppressWarnings("all")
public class HomeworkDemo {
    public static void main(String[] args) {


        homeworkDemo004();
    }

    private static void homeworkDemo004() {


        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
        }
        System.out.println("最终求和值：" + sum);

        int[] array = {1,2,3,1};


    }

    /**
     * 输出1-100的不能被5整除的数，且每5个一行
     */
    private static void homeworkDemo003() {

        int num = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 5 != 0) {
                System.out.print(i + " ");
                num++;
                if (num >= 5) {
                    num = 0;
                    System.out.println("");
                }
                //换行另一种方式 取模
                /*if (num % 5 == 0) {
                    System.out.println("");
                }*/
            }
        }

    }

    /**
     * 计算水仙花数
     */
    private static void homeworkDemo002() {

        //第一种方法，也是常用的方法
        for (int j = 100; j < 1000; j++) {
            int n1 = j / 100;   //百位
            int n2 = j % 100 / 10; //十位
            int n3 = j % 10; //个位
            if (j == (n1 * n1 * n1 + n2 * n2 * n2 + n3 * n3 * n3)) {
                System.out.println("方法1--->水仙花数：" + j);
            }
        }

        // 第二种方法
        for (int i = 100; i < 1000; i++) {
            String num = i + "";
            char[] chars = num.toCharArray();
            int oldNum = 0;
            for (char c : chars) {
                int num1 = (int) c - (int) ('0');
                oldNum += num1 * num1 * num1;
            }
            if (i == oldNum) {
                System.out.println("方法2--->水仙花数：" + i);
            }
        }

    }

    private static void homeworkDemo001() {
        Double money = 100000.0;
        int num = 0;
        while (money >= 1000) {
            if (money > 50000) {
                money *= 0.95;
            } else if (money <= 50000) {
                money -= 1000;
            }
            num++;
        }
        System.out.println(num);
    }


}
