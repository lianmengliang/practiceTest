package com.example.test.DataStructureAndAlgorithm.algorithm.sortingAlgorithm;

import com.example.utils.RandomGenerationUtil;
import org.springframework.data.domain.Sort;

import java.util.Arrays;

/**
 * @Author ： Leo
 * @Date : 2021/5/21 11:45
 * @Desc:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        int[] array = RandomGenerationUtil.getArrayByRandom(100000000);

       /* quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));*/

        long start = System.currentTimeMillis();
        quickSort(array, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("排序运行的时间为：" + (end - start) + "ms");

        int[] array1 = RandomGenerationUtil.getArrayByRandom(100000000);
        long start1 = System.currentTimeMillis();
        Arrays.sort(array1);
        long end1 = System.currentTimeMillis();
        System.out.println("排序运行的时间为：" + (end1 - start1) + "ms");

        int[] array2 = RandomGenerationUtil.getArrayByRandom(100000000);
        long start2 = System.currentTimeMillis();
        sort(array2, 0, arr.length - 1);
        long end2 = System.currentTimeMillis();
        System.out.println("排序运行的时间为：" + (end2 - start2) + "ms");

    }


    /**
     * 排序逻辑：
     *
     * @param arr
     */
    public static void quickSort(int[] arr, int left, int right) {

        int l = left;
        int r = right;
        //中轴值
        int pivot = arr[(left + right) / 2];
        // 临时变量，作为交换使用
        int temp = 0;
        // while循环的目的是让比pivot值小放到左边，大放到右边
        while (l < r) {
            // 在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            // 在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            // 如果了 l>=r 说明pivot的左右两的值，已经按照左边全都是
            // 小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换玩，发现这个arr[l] == pivot相等 r--, 前移
            if (arr[l] == pivot) {
                r--;
            }
            //如果交换玩，发现这个arr[r] == povit 相等，l++, 后移
            if (arr[r] == pivot) {
                l++;
            }

        }
        // 如果l =r，必须l++,r--,否则出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    public static void sort(int[] arr, int left, int right) {

        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            sort(arr, left, partitionIndex - 1);
            sort(arr, partitionIndex + 1, right);
        }

    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        // 终止while循环以后left和right一定相等的
        while (left < right) {

            while (left < right && arr[right] >= pivot) {
                --right;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                ++left;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }


}
