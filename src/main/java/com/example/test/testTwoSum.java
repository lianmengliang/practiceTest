package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ： leo
 * @Date :2020/6/16 11:05
 * <p>
 * 需求：
 * 给定一个数组，给定一个数字。
 * 返回的数组中可以相加得到指定数字的两个索引
 * <p>
 * 需求变形：
 * 给定一个数组，给定一个数字
 * 返回数组中可以相减得到指定数字的两个索引
 */
public class testTwoSum {

    public static void main(String[] args) throws IllegalAccessException {
//        int[] nums = new Arr[2,7]
        int[] nums = {2, 7, 11, 15, 18, 1};

        int target = 3;

        /*int[] result = twoSum(nums, target);

        for (int i : result) {
            System.out.println(i);
        }*/


        int[] numsOne = {1, 2, 5, 8, 10};

        /*int[] resultDemo = twoSumDemo(numsOne, target);
        for (int i : resultDemo) {
            System.out.println(i);
        }*/


        ArrayList list = twoSumDemo02(numsOne, target);

//        System.out.println(list);
        System.out.println(list.size());

        for (Object o : list) {
            int[] result = (int[]) o ;
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }

        }


    }


    public static int[] twoSum(int[] nums, int target) throws IllegalAccessException {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalAccessException("NO two sum solution");

    }

    public static int[] twoSumDemo(int[] nums, int target) {

        /*
         * 假如已知 a = 5 和 target = 3， 求b
         * |a-b| = target
         *
         * 两种情况：
         * 1: a-b = target       b = a - target  2 = 5-3
         * 2: b-a = target       b = a + target  8 = 5+3
         *
         * 加判断：
         *
         * 得出   1：  a = 5 ,b = 2
         *        2:  a = 5, b = 8
         *
         * 假如 new int[]{1,2,5,8,9}
         *
         * 答案就是：1:  {2,5} --> {1,2} 索引
         *          2:  {5,8} --> {2,3}
         *
         *
         *
         *
         * */



        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > target) {
                int num = nums[i] - target;
                if (map.containsKey(num)) {
                    return new int[]{map.get(num), i};
                }
                map.put(nums[i], i);
            } else {
                int num = nums[i] + target;
                if (map.containsKey(num)) {
                    return new int[]{map.get(num), i};
                }
                map.put(nums[i], i);
            }

        }

        return null;
    }

    public static ArrayList twoSumDemo01(int[] nums, int target) {


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] > target) {
                int num = nums[i] - target;
                if (map.containsKey(num)) {
                    list.add(new int[]{map.get(num), i});
                }
            } else {
                int num = nums[i] + target;
                if (map.containsKey(num)) {
                    list.add(new int[]{map.get(num), i});
                }
            }


        }

        return list ;
    }

    public static ArrayList twoSumDemo02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                int num = nums[i] - target;
                if (map.containsKey(num)) {
                    list.add(new int[]{map.get(num), i});
                }
            } else {
                int num = nums[i] + target;
                if (map.containsKey(num)) {
                    list.add(new int[]{map.get(num), i});
                }
            }
        }




        return list;
    }
}
