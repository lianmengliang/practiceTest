package com.example.test.java_basis.array;


import java.util.Arrays;

/**
 * lianmengliang
 * <p>
 * 4/17/22 10:02 PM
 */
public class ArrayHomework {
    public static void main(String[] args) {

        arrayHomework001();
    }

    /**
     * 已知一个升序的数组，要求插入一个元素，该数组依然升序，
     * 比如： {10,12,45,90},插入数据 23
     * 最后结果就是： {10,12,23,45,90}
     */
    private static void arrayHomework001() {

        int[] arr = {10, 12, 45, 90};

        // 要插入的数据
        int num = 91;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            // 先比较，确定位置，然后再遍历添加
            if (num <= arr[i]) {
                System.out.println("插入数据的位置是：" + i);
                index = i;
                break;
            }
        }
        //判断是否进入if判断语句
        if (index == -1) {
            //说明没有找到要插入的位置，因此位置应该是arr.length

            //赋值
            index = arr.length;
        }


        // 遍历插入数据
        //new 一个新的数组用于赋值
        int[] arr1 = new int[arr.length + 1];

        // 遍历赋值
        for (int j = 0; j < arr1.length; j++) {
            if (j < index) {
                arr1[j] = arr[j];
            } else if (j == index) {
                arr1[j] = num;
            } else {
                arr1[j] = arr[j - 1];
            }
        }

        // 赋地址值
        arr = arr1;

        // 校验打印
        System.out.println(Arrays.toString(arr));

    }


}
