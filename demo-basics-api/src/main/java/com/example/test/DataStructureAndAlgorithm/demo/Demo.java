package com.example.test.DataStructureAndAlgorithm.demo;

import java.util.*;

@SuppressWarnings("all")
public class Demo {
    String s = "";
    static private String[] arr = {"A", "B", "C", "A", "B", "C", "A", "D", "qwe"};
    /**
     * 筛选出重复元素
     */
    public static String[] demo1(String[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        List<String> list = new ArrayList<String>();
        Map<String, Integer> map = new HashMap();
        for (String s : arr) {
            if (map.get(s) != null) {
                Integer num = map.get(s);
                num++;
                if (num == 2) {
                    list.add(s);
                }
                map.put(s, num);
            } else {
                map.put(s, 1);
            }
        }
        // return list;  list.forEach(System.out::println);
        String[] objects = (String[]) list.toArray();
        return objects;
    }

    /**
     * 原地删除重复元素
     */
    public static int demo3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 用于计数
        int count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index - 1]) {
                continue;
            }
            nums[index] = nums[i];
            index++;
            count++;
        }
        for (Integer num : nums) {
            System.out.println(num);
        }
        System.out.println(nums.length);
        System.out.println(count);
        return count;
    }

    /**
     * 求最长的回文字符串
     * "abaabbaccccc";  ---> ccccc
     */
    public static void demo4() {
        String s = "abaabbaccccc";
        int max = 0;
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isHwStr(temp)) {
                    if (temp.length() > max) {
                        max = temp.length();
                        maxStr = temp;
                    }
                }
            }
        }
        System.out.println(maxStr);// return maxStr;
    }
    //判断是否为回文字符串
    public static boolean isHwStr(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 查找字符串中不重复的最长子字符串
     * "abaabcrbacdehcccc"; --->rbacdeh
     */
    public static void demo5() {
        String s = "abaabcrbacdehcccc";
        int max = 0;
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isEqualsChar(temp)) {
                    if (temp.length() > max) {
                        max = temp.length();
                        maxStr = temp;
                    }
                }
            }
        }
        // return maxStr;
        System.out.println(maxStr);
    }

    //判断是否为不相等的char
    public static boolean isEqualsChar(String s) {
        char[] ch = s.toCharArray();
        Set set = new HashSet();
        for (char c : ch) {
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }

    /**
     * 请使用制定的字母数量数组，按字母表进行排序
     */
    public static void demo6() {
        String[] arr = {"f", "e", "a", "e", "c", "b"};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (isBig(arr[j], arr[j + 1])) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // return arr;
        System.out.println(Arrays.toString(arr));
    }

    // 判断前一个值是否大于后一个值
    static boolean isBig(String beforeStr, String afterStr) {
        char before = beforeStr.charAt(0);
        char after = afterStr.charAt(0);
        if (before > after) {
            return true;
        }
        return false;
    }

    /**
     * 二分算法
     */
    public static int demo7(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                // 需要向左边查找
                right = mid - 1;
            } else {
                // 向右查找
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 冒泡排序 (while循环)
     *
     * @param arr
     */
    public static void bubbleSortByWhile(int[] arr) {

        int temp = 0;
        // 时间复杂度：线性对数阶 O(nlogN)
        // while循环
        int i = 0;
        while (i < arr.length - 1) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            i++;
        }
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
     *
     */
    public static void demo8() {

    }

    /**
     *
     */
    public static void demo9() {

    }

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        demo1(arr);
    }
}
