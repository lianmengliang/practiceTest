package com.example.test.DataStructureAndAlgorithm.algorithm.sortingAlgorithm;


import com.example.utils.RandomGenerationUtil;

import java.util.Arrays;

/**
 * @Author ： Leo
 * @Date : 2021/5/17 17:39
 * @Desc: 冒泡排序
 * （1）一共进行 数组的大小-1 次 大的循环
 * (2)每一趟排序的次数在逐渐的减少
 * (3) 如果我们发现在某趟排序中，没有发生一次交换， 可以提前结束冒泡排序。这个就是优化
 * <p>
 * <p>
 * 通过测试
 * 1.for循环比while循环速度更快，用时更短
 * 2.优化后冒泡排序 运行时间根据数组中的交换次数而定，有可能更少，有可能更多
 * 3.使用Arrays工具类排序用时最短（且数组的的长度越长，优势越明显）
 *
 *
 *
 * 简单理解就是：经过嵌套循环，把某个数组中素的最大值一个一个的从后面最后一个索引(arr.length-1)往前排序
 */
public class BubbleSort {
    public static void main(String[] args) {


        /*int[] arr = {-2, -1, 9, 8, 10};
        int[] arr1 = {-2, -1, 9, 8, 10};
        bubbleSort(arr);
        System.out.println("-------------------------------------");
        bubbleSortByFlag(arr1);*/

        //获取一个固定长度的数组
        int[] random1 = RandomGenerationUtil.getArrayByRandom(5);

       /* int[] random2 = RandomGenerationUtil.getArrayByRandom(50000);

        int[] random3 = RandomGenerationUtil.getArrayByRandom(50000);

        int[] random4 = RandomGenerationUtil.getArrayByRandom(50000);*/

        int[] random5 = RandomGenerationUtil.getArrayByRandom(5);

        // 测试程序运行时间长短

       /* long start4 = System.currentTimeMillis();
        Arrays.toString(random5);
        long end4 = System.currentTimeMillis();
        System.out.println("Arrays工具类排序运行的时间为："+(end4-start4)+"ms");
        System.out.println("----------------------------------");*/

        long start = System.currentTimeMillis();
        bubbleSort(random1);
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序运行的时间为：" + (end - start) + "ms");

        System.out.println("----------------------------------");

       /* long start1 = System.currentTimeMillis();
        bubbleSortByWhile(random2);
        long end1 = System.currentTimeMillis();
        System.out.println("while循环运行的时间为："+(end1-start1)+"ms");

        System.out.println("----------------------------------");

        long start2 = System.currentTimeMillis();
        bubbleSortByFlag(random3);
        long end2 = System.currentTimeMillis();
        System.out.println("for循环优化后的运行时间为："+(end2-start2)+"ms");

        System.out.println("----------------------------------");

        long start3 = System.currentTimeMillis();
        bubbleSortByFlagandWhile(random4);
        long end3 = System.currentTimeMillis();
        System.out.println("while循环优化后的运行的时间为："+(end3-start3)+"ms");

        System.out.println("----------------------------------");
*/

        // 测试
        System.out.println("测试前" + Arrays.toString(random5));
        test(random5);
        System.out.println("排序后" + Arrays.toString(random5));


    }

    /**
     * 冒泡排序
     * 外for循环决定 几轮内部循环比较替换
     * 内for循环决定比较替换
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {

        int temp = 0;
        // 时间复杂度：O(n^2)
        // 使用for循环
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.printf("第%d趟排序后的数组：\n", (i + 1));
            System.out.println(Arrays.toString(arr));
        }

        // while循环
        /*int i = 0;
        while (i < arr.length - 1) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.printf("第%d趟排序后的数组：\n", (i + 1));
            System.out.println(Arrays.toString(arr));
            i++;
        }*/

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
           /* System.out.printf("第%d趟排序后的数组：\n", (i + 1));
            System.out.println(Arrays.toString(arr));*/
            i++;
        }

    }

    /**
     * 冒泡排序 (优化代码：如果哪一次没有进行交换)
     * 使用flag 参数判断
     *
     * @param arr
     */
    public static void bubbleSortByFlag(int[] arr) {

        int temp = 0;
        // 时间复杂度：O(n^2)
        // 使用for循环
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            /*System.out.printf("第%d趟排序后的数组：\n", (i + 1));
            System.out.println(Arrays.toString(arr));*/

            // 判断这次循环是否交换元素
            if (!flag) {
                // 说明没有交换，顺序已经排好
                break;
            } else {
                // 重新赋值
                flag = false;
            }
        }
    }

    /**
     * 冒泡排序 (优化代码：如果哪一次没有进行交换)
     * 使用flag 参数判断
     *
     * @param arr
     */
    public static void bubbleSortByFlagandWhile(int[] arr) {

        int temp = 0;
        // 时间复杂度：O(n^2)
        boolean flag = false;
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
                    flag = true;
                }
            }
            // 判断这次循环是否交换元素
            if (!flag) {
                // 说明没有交换，顺序已经排好
                break;
            } else {
                // 重新赋值
                flag = false;
            }
           /* System.out.printf("第%d趟排序后的数组：\n", (i + 1));
            System.out.println(Arrays.toString(arr));*/
            i++;
        }
    }


    /**
     * * 用于练习排序 :冒泡排序
     *
     * @param arr
     */
    public static void test(int[] arr) {

       /* // 设置一个中专值
        int temp = 0;

        // 外部for循环，几轮比较
        for (int i = 1; i < arr.length ; i++) {
            // 内部for循环
            for (int j = 0; j < arr.length -i; j++) {
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;

                }

            }
        }*/

        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


    }

}
