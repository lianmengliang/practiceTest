package com.example.test.DataStructureAndAlgorithm.algorithm.sortingAlgorithm;

import com.example.utils.RandomGenerationUtil;

import java.util.Arrays;

/**
 * @Author ： Leo
 * @Date : 2021/5/24 16:35
 * @Desc: 归并排序：
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, -1, 7, 2, 3, 5, -4, 6, 0};

        int[] temp = new int[arr.length];
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println(Arrays.toString(arr));

        int[] array = RandomGenerationUtil.getArrayByRandom(100000000);
        int[] temp1 = new int[array.length];
        long start2 = System.currentTimeMillis();
        mergeSort(array, 0, arr.length - 1, temp1);
        long end2 = System.currentTimeMillis();
        System.out.println("排序运行的时间为：" + (end2 - start2) + "ms");

    }

    /**
     * 分 + 合的方法
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     * 合并过程：
     *
     * @param arr：原始数组
     * @param left：左边有序序列的初始索引
     * @param mid：中间索引
     * @param right：右边索引
     * @param temp：中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 初始化i， 左边有序序列的初始索引
        int i = left;
        // 初始化j，右边有序序列的初始索引
        int j = mid + 1;
        // 指向temp数组的当前索引
        int t = 0;

        // (一)
        // 先把左右两边（有序）的数据按照规则填充到temp数组
        // 直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            // 如果左边的有序序列的当前元素小于等于右边有序序列的当前元素
            // 即将左边的当前元素，填充到temp数组，然后t++,i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                // 反之，将右边的有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //（二）
        // 把剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {
            // 左边的有序序列还有剩余的元素，全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {
            // 右边的有序序列还有剩余的元素，全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }


        //（三）
        // 将temp数组的元素拷贝到arr
        // 注意： 并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        // 第一次合并 tempLeft = 0 , right = 1
        // 第二次： tempLeft = 2 right = 3
        // 第三次： tL=0 ri=3
        // 最后一次 tempLeft = 0 right = 7

        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }


}
