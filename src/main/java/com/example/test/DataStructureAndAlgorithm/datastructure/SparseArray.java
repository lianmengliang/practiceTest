package com.example.test.DataStructureAndAlgorithm.datastructure;

import java.io.*;

/**
 * @Author ： Leo
 * @Date : 2021/4/25 12:14
 * @Desc: 原始复杂数组 转化为 稀疏数组 ，然后存储到本地，最后再从本地中读取，恢复到原数组
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {


        // 创建一个原始的二维数组 11*11
        //0：表示没有棋子，1表示黑，2表示蓝子
        int chessArr1[][] = new int[11][11];
        // 赋值
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 3;

        //输出原始的二维数组
        System.out.println("原始的二维数组。。。。");

        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 二维数组 转化给稀疏数组
        int[][] sparseArr = getSparseArr(chessArr1);

        // 将稀疏数组存储到本地磁盘中
        storageArrayToDisk(sparseArr);

        // 从稀疏数组 恢复到 原二维数组
        restoreTheOriginalArray(sparseArr);
    }


    /**
     * 二维数组 转化给稀疏数组
     *
     * @param chessArr1
     * @return
     */
    public static int[][] getSparseArr(int[][] chessArr1) {
        // 将二维数组 转 稀疏 数组的思想
        // 1.先遍历二维数组，得到非0的数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 2. 创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非0的值存放到sparseArr中

        // count用于记录是第几个非0数据
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    // i,j 相当于原数组的坐标， chessArr1[i][j]是指坐标的值
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为。。。");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
        }
        System.out.println();
        return sparseArr;
    }

    /**
     * 恢复到原数组
     * 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的 chessArr2 = int [11][11]
     * 2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
     *
     * @param array
     */
    public static int[][] restoreTheOriginalArray(int[][] array) {

        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] originalArray = new int[array[0][0]][array[0][1]];
//2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
        for (int i = 1; i < array.length; i++) {
            originalArray[array[i][0]][array[i][1]] = array[i][2];
        }

        for (int[] row : originalArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        return originalArray;

    }

    /**
     * 将数组存到本地磁盘中
     *
     * @param array
     */
    public static void storageArrayToDisk(int[][] array) throws IOException {
        // 创建一个存储的地址
        File file = new File("D:/map.data");
        if (file.exists()) {
            try {
                // 不存在则创建文件
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream os = new FileOutputStream(file);

        for (int i = 0; i < array.length; i++) {
            String msg = array[i][0] + "\t" + array[i][1] + "\t" + array[i][2];
            os.write(msg.getBytes("utf-8"));
            os.flush();
        }


        // 从磁盘中读取
        BufferedReader reader = new BufferedReader(new FileReader(file));
        // 准备要恢复的二维数组
        int[][] chessArr2 = null;
        // 计数器
        int count = 0;
        String msg = "";

        while ((msg = reader.readLine()) != null) {
            String[] str = msg.split("\t");

            Integer row = Integer.valueOf(str[0]);
            Integer col = Integer.valueOf(str[1]);
            Integer value = Integer.valueOf(str[2]);

            if (count == 0) {
                chessArr2 = new int[row][col];
            } else {
                chessArr2[row][col] = value;
            }
            count++;
        }

        System.out.println("恢复后的二维数组chessArr2--");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("\t",data);
            }
        }


    }


}
