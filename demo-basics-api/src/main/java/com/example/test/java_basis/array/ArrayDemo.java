package com.example.test.java_basis.array;

/**
 * lianmengliang
 * <p>
 * 2022-04-14 21:43
 */
@SuppressWarnings("all")
public class ArrayDemo {
    public static void main(String[] args) {
        array004();
    }

    /**
     * 冒泡排序，数组提升练习
     */
    private static void array004() {

        int[] arr = {35, 12, 45, 80, 65};

        // 初始赋值
        // 临时值
        int temp = 0;
        //外层控制 几轮排序
        for (int i = 1; i < arr.length; i++) {
            //内层控制 几轮比较并且交换
            for (int j = 0; j < arr.length - i; j++) {
                // 比较，如果后面的值大于前面的值，就交换，否则就不操作
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }


        for (int a : arr) {
            System.out.print(a + "\t");
        }
    }


    /**
     * 数组扩容：简单扩容 数组长度
     */
    private static void array003() {

        int[] arr = {1, 2, 3};

        // 新建一个数组
        int[] newArr = new int[arr.length + 1];
        newArr[newArr.length - 1] = 4;

        //遍历原数组，赋值给新数组
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        //赋值，这里赋值的是地址值
        arr = newArr;

        //遍历 校验
        for (int a : arr) {
            System.out.print(a + "\t");
        }

    }

    /**
     * 数组反转
     */
    private static void array002() {
        //第一种方法，不用新建array
        int[] array = {12, 31, 14, 36, 78, 34};

        /*int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            //中间临时值
            temp = array[array.length - 1 - i];
            // 重新赋值
            array[array.length - 1 - i] = array[i];
            array[i] = temp;
        }
        for (int arr : array) {
            System.out.print(arr+"\t");
        }*/
        System.out.println("");
        System.out.println("------------");

        //第二种方法： 反着遍历
        int temp;
        /*for (int i = array.length - 1, j = 0; i > j; i--, j++) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }*/
        for (int i = array.length - 1, j = 0; i > array.length / 2; i--, j++) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        for (int arr : array) {
            System.out.print(arr + "\t");
        }

        //第三种方式：数组反转-->赋值 （需要新建一个新的数组）
        /*int[] arr2 = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            arr2[array.length - 1 - i] = array[i];

        }
        for (int arr : arr2) {
            System.out.print(arr + "\t");
        }*/

    }

    private static void array001() {

        int[] arr = {1, 2, 42, 1};
        System.out.println(arr.length);

        arr[4] = 6;
        System.out.println(arr.length);
    }
}
