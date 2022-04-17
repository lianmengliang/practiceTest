package com.example.test.DataStructureAndAlgorithm.algorithm.sortingAlgorithm;

import com.example.utils.RandomGenerationUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author ： Leo
 * @Date : 2021/5/18 16:16
 * @Desc: 插入排序
 *
 * 简单理解就是：经过嵌套循环，判断，交换，循环
 */
@SuppressWarnings("all")
public class insertSort {
    public static void main(String[] args) {

      /*  int[] arr = RandomGenerationUtil.getArrayByRandom(5000);
        int[] arr1 = RandomGenerationUtil.getArrayByRandom(5000);

        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("插入排序运行的时间为：" + (end - start) + "ms");
        System.out.println("----------------------------------");

        long start1 = System.currentTimeMillis();
        Arrays.sort(arr1);
        long end1 = System.currentTimeMillis();
        System.out.println("Arrays工具类排序运行的时间为：" + (end1 - start1) + "ms");
        System.out.println("----------------------------------");*/

        int[] arr2 = RandomGenerationUtil.getArrayByRandom(10);
        test(arr2);
        System.out.println(Arrays.toString(arr2));

    }


    /**
     * 插入 排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {

/*
        // 第一轮
        // 定义待插入的数
        int insertValue = arr[1];
        // 即arr[1]的前面这个数的下标
        int insertIndex = 1 - 1;

        //给insertValue 找到插入的位置
        // 说明：
        //1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
        //2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        //3. 就需要将 arr[insertIndex] 后移
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        // 当退出while循环时，说明插入的位置找到, insertIndex + 1
        // 举例：理解不了，我们一会 debug
        arr[insertIndex + 1] = insertValue;

        // {13,9,5,25}
        // {9,13,5,25}

        //{5,9,13,25}
        //第二轮
        int insertVal = arr[2];  //5
        int insertIn = 1;     // 13index
        while (insertIn>=0 && insertVal<arr[insertIn]){ //5<13 --> 5<9
            arr[insertIn + 1] = arr[insertIn];  // arr[2]=13 --> arr[1]-->9
            insertIn--;
        }
        // arr[] = insertVal
        arr[insertIndex +1] = insertVal;*/

        // {13,9,5,25}      1
        // {9,13,5,25}      2
        //{5,9,13,25}       3
        for (int i = 0; i < arr.length - 1; i++) {
            // 定义待插入的数
            int insertValue = arr[i + 1];
            // 即arr[i+1]的前面这个数的下标
            int insertIndex = i;
            //给insertValue 找到插入的位置
            // 说明：
            //1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            //2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            //3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                // 给要插入值的位置 赋值
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 把要插入的值 赋值 到数组要插入的位置
            arr[insertIndex + 1] = insertValue;

        }
    }

    /**
     * 用于测试 练习
     *
     * @param arr
     */
    public static void test(int[] arr) {

       /* for (int i = 0; i < arr.length - 1; i++) {
            int insertValue = arr[i + 1];
            int insertIndex = i;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                // 符合 插入值 < 前面的值，就发生替换
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 把插入值 赋值给前面的值
            arr[insertIndex + 1] = insertValue;
        }*/

        for (int i = 0; i < arr.length - 1; i++) {
            // 设置插入值
            int insertValue = arr[i + 1];
            int insertIndex = i;
            // 若插入值小于前面索引所代表的值，就发生交换
            while(insertIndex>=0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertValue;

        }

    }
}
