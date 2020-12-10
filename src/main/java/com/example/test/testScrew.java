package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2020/9/23 17:59
 * @Desc: 螺旋遍历数组
 */
public class testScrew {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        //当二维数组是空或任何一个维度是0，直接返回
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        //m是矩阵的行数
        int m = matrix.length;
        //n是矩阵的列数
        int n = matrix[0].length;
        //大循环，从外向内逐层遍历矩阵
        for(int i=0; i<(Math.min(m, n)+1)/2; i++) {
            //从左到右遍历“上边”
            for (int j=i; j<n-i; j++) {
                list.add(matrix[i][j]);
            }
            //从上到下遍历“右边”
            for (int j=i+1; j<m-i; j++) {
                list.add(matrix[j][(n-1)-i]);
            }
            //从右到左遍历“下边”
            for (int j=i+1; j<n-i; j++) {
                list.add(matrix[(m-1)-i][(n-1)-j]);
            }
            //从下到上遍历“左边”
            for (int j=i+1; j<m-1-i; j++) {
                list.add(matrix[(m-1)-j][i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  2,  3,  4,  5  },
                { 6,  7,  8,  9,  10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 }
        };
        int[][] matrix2 = {
                { 1,  2,  3,  4,  5  },
                { 6,  7,  8,  9,  10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
        };
        List<Integer> resultList1 = spiralOrder(matrix);
        System.out.println(Arrays.toString(resultList1.toArray()));
        List<Integer> resultList2 = spiralOrder(matrix2);
        System.out.println(Arrays.toString(resultList2.toArray()));
    }
}
