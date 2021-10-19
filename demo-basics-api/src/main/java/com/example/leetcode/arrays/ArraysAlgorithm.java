package com.example.leetcode.arrays;

import io.swagger.models.auth.In;

import java.util.*;

/**
 * @Author ： Leo
 * @Date : 2021/10/19 11:41
 * @Desc:
 */
@SuppressWarnings("all")
public class ArraysAlgorithm {

    private static final Integer[] nums = new Integer[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    /**
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



        /**
         * 思路分析：
         * nums = [1,1,2,2]
         * 正向遍历：
         * 外层 索引 0 ，值 1 ，内层索引1，值1  此时相等，
         * 应nums[0] = nums[1], nums[1] = nums[2], 此时nums = [1,2,2]
         */
        //正向遍历
       /* for (int i = 0; i < nums.length; i++) {
            System.out.println("i--->" + nums[i]);
            for (int x = i + 1; x < nums.length; x++) {
                if (nums[i] == nums[x]) {
                    nums[i] = nums[x];
                    nums[x] = nums[x + 1];

                }
            }
        }*/

        //反向遍历
       /* for (int j = nums.length - 1; j > 0; j--) {
//            System.out.println("J--->" + nums[j]);
            for (int g = j+1; g<nums.length; g++){
                if (nums[j] == nums[g]){
                    nums[j] = nums[g];
                }
            }
        }*/

        return results.length;
    }




    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        // 原地删除数组重复项，返回数组新长度
        deleteDuplicateItem(nums);
    }
}
