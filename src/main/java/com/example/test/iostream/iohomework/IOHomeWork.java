package com.example.test.iostream.iohomework;

import java.io.File;
import java.io.IOException;

/**
 * @Author ： Leo
 * <p>顺序：15
 * @Date : 2021/6/10 18:23
 * @Desc: IO流的作业 （练习）
 */
public class IOHomeWork {
    public static void main(String[] args) throws IOException {
        homework01();
    }

    /**
     * 作业要求：
     */
    private static void homework01() throws IOException {
        String filePath = "E:\\mytemp";
        File file = new File(filePath);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("成功创建文件");
            }
        }
        boolean newFile = file.createNewFile();

    }

    private static void homework02() {
    }

    private static void homework03() {
    }
}
