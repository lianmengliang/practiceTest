package com.example.test.java_basis.array;

/**
 * lianmengliang
 * <p>
 * 2022-04-14 21:43
 */
@SuppressWarnings("all")
public class ArrayDemo {
    public static void main(String[] args) {
        array008();
    }

    /**
     * 杨辉三角
     */
    private static void array008() {


        int[][] arr = new int[5][];


        for (int i = 0; i < arr.length; i++) {

            arr[i] = new int[i+1];

            for (int j = 0; j < arr[i].length; j++) {
                if (j ==0 || j == arr[i].length-1){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
            }
        }


        // 遍历校验
        for (int[] arr1 : arr) {
            for (int arr2 : arr1) {
                System.out.print(arr2 + "\t");
            }
            System.out.println("");
        }



    }

    /**
     * 动态二维数组:赋值
     */
    private static void array007() {

        int[][] arr = new int[3][];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = new int[i + 1];

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                System.out.print(arr[i][i1] +"\t");
            }
            System.out.println();
        }

    }


    /**
     * 二维数组
     */
    private static void array006() {

        //二维数组
        int[][] arr = {{1, 2, 4, 5}, {1, 1, 4, 5}, {1, 2, 1, 1}, {0, 2, 4, 0}};

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }

    }

    /**
     * 二分查询法
     */
    private static int array005() {


        int[] arr = {12, 35, 45, 56, 65};

        int left = 0;
        int right = arr.length - 1;

        int num = 45;
        //使用二分法查询
        while (left <= right) {
            /*int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                // 需要向左边查找
                right = mid - 1;
            } else {
                // 向右查找
                left = mid + 1;
            }*/
            int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                //需要向左边查询
                right = mid - 1;
            } else {
                //向右查询
                left = mid + 1;
            }
        }

        return -1;
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
