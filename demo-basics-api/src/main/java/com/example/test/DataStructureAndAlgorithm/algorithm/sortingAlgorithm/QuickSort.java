package com.example.test.DataStructureAndAlgorithm.algorithm.sortingAlgorithm;

import com.example.utils.RandomGenerationUtil;


/**
 * @Author ： Leo
 * @Date : 2021/5/21 11:45
 * @Desc:
 * 快速排序介绍：
 * 1.快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序 n 个项目要 Ο(nlogn) 次比较。在最坏状况下则需要 Ο(n2) 次比较，但这种状况并不常见。事实上，快速排序通常明显比其他 Ο(nlogn) 算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来。
 * 2.快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
 * 3.快速排序又是一种分而治之思想在排序算法上的典型应用。本质上来看，快速排序应该算是在冒泡排序基础上的递归分治法。
 * 4.快速排序的名字起的是简单粗暴，因为一听到这个名字你就知道它存在的意义，就是快，而且效率高！它是处理大数据最快的排序算法之一了。
 * 虽然 Worst Case 的时间复杂度达到了 O(n²)，但是人家就是优秀，在大多数情况下都比平均时间复杂度为 O(n logn) 的排序算法表现要更好，可是这是为什么呢，我也不知道。好在我的强迫症又犯了，查了 N 多资料终于在《算法艺术与信息学竞赛》上找到了满意的答案：
 * 5.快速排序的最坏运行情况是 O(n²)，比如说顺序数列的快排。但它的平摊期望时间是 O(nlogn)，且 O(nlogn) 记号中隐含的常数因子很小，比复杂度稳定等于 O(nlogn) 的归并排序要小很多。所以，对绝大多数顺序性较弱的随机数列而言，快速排序总是优于归并排序。
 *
 * */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, -7, 2, 3, 5, 4, -6, 0};

        /*int[] array = RandomGenerationUtil.getArrayByRandom(100000000);

       *//* quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));*//*

        long start = System.currentTimeMillis();
        quickSort(array, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("排序运行的时间为：" + (end - start) + "ms");

        int[] array1 = RandomGenerationUtil.getArrayByRandom(100000000);
        long start1 = System.currentTimeMillis();
        Arrays.sort(array1);
        long end1 = System.currentTimeMillis();
        System.out.println("排序运行的时间为：" + (end1 - start1) + "ms");*/

        int[] array2 = RandomGenerationUtil.getArrayByRandom(100000000);
        long start2 = System.currentTimeMillis();
        sort(arr, 0, arr.length - 1);
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
            // 在pivot的左边一直找，找到小于等于pivot值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            // 在pivot的右边一直找，找到大于等于pivot值，才退出
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
        // 临时变量，作为交换使用
        int pivot = arr[left];

        // 终止while循环以后left和right一定相等的，
        // while循环的目的是让比pivot值小放到左边，大放到右边
        while (left < right) {
            // 在pivot的右边一直找，找到大于等于pivot值，才退出
            while (left < right && arr[right] >= pivot) {
                --right;
            }
            arr[left] = arr[right];

            // 在pivot的左边一直找，找到小于等于pivot值，才退出
            while (left < right && arr[left] <= pivot) {
                ++left;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }


}
