package com.example.test.DataStructureAndAlgorithm.algorithm.sortingAlgorithm;

import com.example.utils.RandomGenerationUtil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ： Leo
 * @Date : 2021/5/18 14:19
 * @Desc: 选择排序：
 *
 * 简单理解就是：
 *  经过嵌套循环，把某个数组中素的最小值一个一个的从前面第一个索引0往后排序
 */
@SuppressWarnings("all")
public class SelectSort {
    public static void main(String[] args) {

        int[] array = RandomGenerationUtil.getArrayByRandom(5000);
        int[] array1 = RandomGenerationUtil.getArrayByRandom(15);
        int[] array2 = RandomGenerationUtil.getArrayByRandom(5000);

       /* long start4 = System.currentTimeMillis();
        Arrays.sort(array2);
        long end4 = System.currentTimeMillis();
        System.out.println("Arrays工具类排序运行的时间为：" + (end4 - start4) + "ms");
        System.out.println("----------------------------------");

        long start = System.currentTimeMillis();
        sort(array);
        long end = System.currentTimeMillis();
        System.out.println("选择排序运行的时间为：" + (end - start) + "ms");
        System.out.println("----------------------------------");

        System.out.println(Arrays.toString(array1));
        long start1 = System.currentTimeMillis();
        sortByFlag(array1);
        long end1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(array1));
        System.out.println("for循环byflag排序运行的时间为：" + (end1 - start1) + "ms");
        System.out.println("----------------------------------");*/

        // 测试
        System.out.println("测试前：" + Arrays.toString(array1));
        test(array1);
        System.out.println("排序后：" + Arrays.toString(array1));


    }


    /**
     * 选择排序
     * 1.第i轮挑出最小的和前面arr[i-1]替换
     * 2.共进行(arr.length-1)轮替换
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        // 决定进行（arr.length-1）轮选择
        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            int min = arr[i];
            // 循环筛选最最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            // 选出最小值 和 前面第i个值交换
            if (minIndex != i) {
                //最小值的index和前面第i个位置替换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        /*// 第一轮
        int minIndex = arr[0];

        for (int j = 1; j < arr.length - 1; j++) {
            if (arr[j] < minIndex) {
                minIndex = arr[j];
            }
        }
        // 选出最小值
        arr[0] = minIndex;


        // 第二轮
        int minIndex1 = arr[1];
        for (int j = 2; j < arr.length - 1; j++) {
            if (arr[j] < minIndex) {
                minIndex = arr[j];
            }
        }
        // 选出最小值
        arr[1] = minIndex;
*/


    }


    // 选择排序
    public static void selectSort(int[] arr) {

        // 在推导的过程，我们发现了规律，因此，可以使用for来解决
        // 选择排序时间复杂度是 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j]; // 重置min
                    minIndex = j; // 重置minIndex
                }
            }

            // 将最小值，放在arr[0], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

           /* System.out.println("第" + (i + 1) + "轮后~~");
            System.out.println(Arrays.toString(arr));*/
        }

    }


    /**
     * 根据flag 判断本轮是否进行交换，如果不交换说明顺序已经排好，直接跳出循环
     *
     * @param arr
     */
    public static void sortByFlag(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }


    }


    /**
     * 用于测试
     * 内部for循环筛序出最小值，然后和前面的值替换
     * 外部for循环 决定筛选赋值次数
     *
     * @param arr
     */
    public static void test(int[] arr) {

        /*for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;

            // 从i+1索引 开始循环
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }*/

        for (int i = 0; i < arr.length - 1; i++) {
            // 设置交换值
            int min = arr[i];
            int minIndex = i;

            //从i+1索引开始循环,筛选出最小值，用于下面和min替换
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min){
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }


        }


    }
}
