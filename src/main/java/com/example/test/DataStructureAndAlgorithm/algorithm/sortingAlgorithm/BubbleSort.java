package com.example.test.DataStructureAndAlgorithm.algorithm.sortingAlgorithm;


import java.util.Arrays;

/**
 * @Author ： Leo
 * @Date : 2021/5/17 17:39
 * @Desc: 冒泡排序
 * （1）一共进行 数组的大小-1 次 大的循环
 * (2)每一趟排序的次数在逐渐的减少
 * (3) 如果我们发现在某趟排序中，没有发生一次交换， 可以提前结束冒泡排序。这个就是优化
 *
 *
 * 通过测试
 * 1.for循环比while循环速度更快，用时更短
 * 2.优化后冒泡排序 运行时间根据数组中的交换次数而定，有可能更少，有可能更多
 * 3.使用Arrays工具类排序用时最短（且数组的的长度越长，优势越明显）
 */
public class BubbleSort {
    public static void main(String[] args) {


        /*int[] arr = {-2, -1, 9, 8, 10};
        int[] arr1 = {-2, -1, 9, 8, 10};
        bubbleSort(arr);
        System.out.println("-------------------------------------");
        bubbleSortByFlag(arr1);*/

        //获取一个固定长度的数组
        int[] random1 = getArrayByRandom(10000);

        int[] random2 = getArrayByRandom(10000);

        int[] random3 = getArrayByRandom(10000);

        int[] random4 = getArrayByRandom(10000);

        int[] random5 = getArrayByRandom(10000);

        // 测试程序运行时间长短

        long start4 = System.currentTimeMillis();
        Arrays.sort(random5);
        long end4 = System.currentTimeMillis();
        System.out.println("Arrays工具类排序运行的时间为："+(end4-start4)+"ms");
        System.out.println("----------------------------------");

        long start = System.currentTimeMillis();
        bubbleSort(random1);
        long end = System.currentTimeMillis();
        System.out.println("for循环运行的时间为："+(end-start)+"ms");

        System.out.println("----------------------------------");

        long start1 = System.currentTimeMillis();
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





    }

    /**
     * 冒泡排序
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
           /* System.out.printf("第%d趟排序后的数组：\n", (i + 1));
            System.out.println(Arrays.toString(arr));*/
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
     * 随机生成长度为 length的数组
     *
     * @param length
     * @return
     */
    public static int[] getArrayByRandom(int length) {

        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        return arr;
    }

}
