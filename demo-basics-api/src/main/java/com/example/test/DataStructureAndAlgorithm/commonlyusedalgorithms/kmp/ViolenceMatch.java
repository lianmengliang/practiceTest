package com.example.test.DataStructureAndAlgorithm.commonlyusedalgorithms.kmp;

import java.util.Arrays;

/**
 * @Author ： Leo
 * @Date : 2021/5/25 17:47
 * @Desc: KMP 算法  ---  双指针
 * 先来个暴力匹配：
 * 字符串匹配问题：
 * 有一个字符串 str1= ““硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好””，和一个子串 str2=“尚硅谷你尚硅你”
 * 现在要判断 str1 是否含有 str2，如果存在，就返回第一次出现的位置，如果没有，则返回-1
 *
 *
 * KMP算法详解：（参考链接）https://blog.csdn.net/v_july_v/article/details/7041827#t9
 */
@SuppressWarnings("all")
public class ViolenceMatch {
    public static void main(String[] args) {
        // 测试暴力匹配算法
       /* String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";

        int i = violenceMatch(str1, str2);
        System.out.println(i);*/


            String str1 = "BBC ABCDAB ABCDABCDABDE";
            String str2 = "ABCDABD";
            // String str2 = "BBC";A
//            int[] next = kmpNext("ABCDABD"); //next=[0, 0, 0, 0, 1, 2, 0]
//            int[] next = kmpNext("ABCDABA"); //next=[0, 0, 0, 0, 1, 2, 1]
           /* int[] next = kmpNext("ABCDABABCBACD"); //[0,0,0,0,1,2,1,3,1,1,2,1,2]


            System.out.println("next=" + Arrays.toString(next));*/

            /*int index = kmpSearch(str1, str2);
            System.out.println("index=" + index); // 15*/

        int i = violenceMatch(str1, str2);
        System.out.println(i);


    }

    /**
     * 暴力匹配算法实现
     *
     * @param str
     * @param targetStr : 目标字符串
     * @return
     */
    public static int violenceMatch(String str, String targetStr) {
        char[] s1 = str.toCharArray();
        char[] s2 = targetStr.toCharArray();

        // 索引指向s1
        int i = 0;
        // 索引指向s2
        int j = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                // 没有匹配成功
                // 如果失配（即str1[i]! = str2[j]），令i = i - (j - 1)，j = 0。
                i = i - (j - 1);
                j = 0;
            }
        }

        // 判断是否匹配成功
        if (j == s2.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * 获取一个字符串（子串）的部分匹配表
     *
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        // 创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        // 如果字符串是长度为1的，部分匹配值就是0
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            // 当dest.charAt(i)!=dest.charAt(j),我们需要从next[j-1]获取新的j
            // 知道我们发现 有dest.charAt(i)==dest.charAt(j)成立才退出
            // 这是kmp算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            // 当dest.charAt(i) == dest.charAt( j) 满足时，部分匹配值就是+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * kmp搜索算法
     *
     * @param str1： 源字符串
     * @param str2： 子串
     *
     * next： 部分匹配表，是子串对应的部分匹配表
     *
     * @return 没有就返回-1
     */
    public static int kmpSearch(String str1, String str2) {


        int[] next = kmpNext(str2);
        // 遍历
        for (int i = 0, j = 0; i < str1.length(); i++) {
            // 需要处理 str1.charAt(i) ！= str2.charAt(j), 去调整j的大小
            // KMP算法核心点, 可以验证...
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }


    /*public static int getIntee(String str1, String str2) {

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int i = 0; // 指向1的索引
        int j = 0;
        while (j < s2.length && i < s1.length) {
            // 121232 -- 123
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }

        if (j == s2.length) {
            System.out.println("匹配成功");
            return i - j;
        }else{
            return -1;
        }

    }*/

}
