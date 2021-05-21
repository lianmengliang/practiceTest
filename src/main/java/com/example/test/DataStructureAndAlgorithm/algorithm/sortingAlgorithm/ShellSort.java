package com.example.test.DataStructureAndAlgorithm.algorithm.sortingAlgorithm;

import com.example.utils.RandomGenerationUtil;

import java.util.Arrays;

/**
 * @Author ： Leo
 * @Date : 2021/5/19 15:25
 * @Desc: 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0, 8, 9, 1, 7, 2, 3, 5, 4, 6, 0, 8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        /*System.out.println("希尔排序前" + Arrays.toString(arr));
        sortByInsert(arr);
        System.out.println("------------------------------------------------------------");
        System.out.println("希尔排序前" + Arrays.toString(arr));*/
//        test(arr);
        System.out.println(Arrays.toString(arr));

        sortByInsert(arr);
        System.out.println(Arrays.toString(arr));


        int[] array = RandomGenerationUtil.getArrayByRandom(60);
        long start = System.currentTimeMillis();
        sortByExchange(array);
        long end = System.currentTimeMillis();
        System.out.println("希尔排序运行的时间为：" + (end - start) + "ms");

        int[] array1 = RandomGenerationUtil.getArrayByRandom(60);

        long start1 = System.currentTimeMillis();
        Arrays.sort(array1);
        long end1 = System.currentTimeMillis();
        System.out.println("Array工具类排序运行的时间为：" + (end1 - start1) + "ms");


    }

    /**
     * 固定分组值
     */
    private static final int NUM = 2;

    /**
     * 希尔排序： 交换法
     *
     * @param arr
     */
    public static void sortByExchange(int[] arr) {

        int temp = 0;
        int count = 0;
        // 确定分组条件
        for (int gap = arr.length / NUM; gap > 0; gap /= NUM) {
            // 第几轮循环，以gap进行循环分组，
            for (int i = gap; i < arr.length; i++) {
                //以gap值，循环比较--符合条件--替换
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
           /* System.out.println("gap" + gap);
            System.out.println("希尔第"+ (++count) +"轮排序后："+ Arrays.toString(arr));*/
        }

    }

    /**
     * 希尔排序：
     * <p>
     * 对交换式的希尔排序进行优化->移位法
     * // 使用逐步推导的方式来编写希尔排序
     * // 希尔排序时， 对有序序列在插入时采用插入法,
     * // 思路(算法) ===> 代码
     *
     * @param arr
     */
    public static void sortByInsert(int[] arr) {

        // 增量gap，并逐步的缩小增量
        for (int gap = arr.length / NUM; gap > 0; gap /= NUM) {
            //从第gap元素，逐个对某所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    // temp比arr[j - gap]大，所以需要插入j的位置
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 希尔排序： 推导过程
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        // 定义交换值
        int temp = 0;
        // 第一轮：10个数据分成5组
        for (int i = 5; i < arr.length; i++) {
            // 共5组，每组2个元素，步长5
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加上步长后的那个元素，说明符合交换条件
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }

            }
        }
        System.out.println("希尔第一轮排序后" + Arrays.toString(arr));

        // 第二轮：10数据分成5组，5/2=2组
        for (int i = 2; i < arr.length; i++) {
            // 遍历
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔第二轮排序后" + Arrays.toString(arr));


        // 第三轮：2/2 = 1
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔第三轮排序后" + Arrays.toString(arr));

    }


    public static void test(int[] arr) {
        // 增量gap，并逐步的缩小增量
        /*for (int gap = arr.length / NUM; gap > 0; gap /= NUM) {
            //从第gap元素，逐个对某所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    // temp比arr[j - gap]大，所以需要插入j的位置
                    arr[j] = temp;
                }
            }
        }*/

        //循环分组
        for (int gap = arr.length / NUM; gap > 0; gap /= NUM) {
            // 从第gap元素，逐个对某所在组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp <arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }

                }
                arr[j] = temp;
            }
        }
    }

}