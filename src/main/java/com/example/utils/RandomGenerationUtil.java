package com.example.utils;

/**
 * @Author ： Leo
 * @Date : 2021/5/18 14:20
 * @Desc:
 */
public class RandomGenerationUtil {

    /**
     * 随机生成 长度为length的数组
     * @param length
     * @return
     */
    public static int[] getArrayByRandom(int length) {

        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
        return arr;
    }
}
