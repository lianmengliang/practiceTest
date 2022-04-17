package com.example.test.DataStructureAndAlgorithm.commonlyusedalgorithms;

import com.example.utils.RandomGenerationUtil;

import java.util.Arrays;

/**
 * @Author ： Leo
 * @Date : 2021/5/19 20:09
 * @Desc: 二分算法
 */
@SuppressWarnings("all")
public class DichotomousAgorithm {
    public static void main(String[] args) {
        int[] array = RandomGenerationUtil.getArrayByRandom(15);

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        Arrays.sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
        int index = BinarySearchNoRecur(arr, 6);
        System.out.println("目标的索引：" + index);

    }


    /**
     * 二分查找算法：
     * 方式：非递归方式实现
     *
     * @param arr    待查找的数组, arr是升序排序
     * @param target 需要查找的数
     * @return
     */
    public static int BinarySearchNoRecur(int[] arr, int target) {
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
}
