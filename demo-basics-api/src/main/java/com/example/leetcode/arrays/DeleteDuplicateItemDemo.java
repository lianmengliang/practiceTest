package com.example.leetcode.arrays;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author ： Leo
 * @Date : 2021/10/19 14:40
 * @Desc: /**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
 * 使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。
 * 不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。
 * 不需要考虑数组中超出新长度后面的元素。
 */
@SuppressWarnings("all")
public class DeleteDuplicateItemDemo {
    private static final int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    public static int deleteDuplicateItem(Integer[] nums) {
        //允许借助外援1
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.get(num) != null) {
                Integer value = map.get(num);
                value++;
                map.put(num, value);
            } else {
                map.put(num, 1);
            }
        }
        Integer[] results = new Integer[map.size()];
        int i = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            results[i] = iterator.next();
        }
        System.out.println(results.length);

        return results.length;
    }


    /**
     * 第一种解决方法
     *
     * @param nums
     * @return
     */
    public static int resolventOne(int[] nums) {
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

    public static int removeDuplicates(int[] A) {
        //边界条件判断
        if (A == null || A.length == 0)
            return 0;
        int left = 0;
       /* for (int right = 1; right < A.length; right++) {
            //如果左指针和右指针指向的值一样，说明有重复的，
            //这个时候，左指针不动，右指针继续往右移。如果他俩
            //指向的值不一样就把右指针指向的值往前挪
            if (A[left] != A[right]) {
                A[++left] = A[right];
            }
        }

        for (int i : A) {
            System.out.println(i);
        }
        return ++left;*/

        int count = 0;//重复的数字个数
        for (int right = 1; right < A.length; right++) {
            if (A[right] == A[right - 1]) {
                //如果有重复的，count要加1
                count++;
            } else {
                //如果没有重复，后面的就往前挪
                A[right - count] = A[right];
            }
        }
        for (int i : A) {
            System.out.print(i+"-");
        }
        System.out.println();
        //数组的长度减去重复的个数
        return A.length - count;

    }


    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
//        resolventOne(nums);
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
}
