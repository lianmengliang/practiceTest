package com.example.test.iostream.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author ： Leo
 * <p>顺序：8
 * @Date : 2021/6/9 12:14
 * @Desc:
 */
public class BufferedWriterDemo {
    public static void main(String[] args) {

        bufferedWriteFile();
    }

    /**
     * 把 “hello，Leo 看一看”写入到G:\testIO\hello.java中
     */
    private static void bufferedWriteFile() {

        String filePath = "G:\\testIO\\hello.txt";
        String str = "hello，Leo 来看一看";
        BufferedWriter bw = null;
        try {
            // 如果new FileWriter(filePath,true) 表示以追加的方式写入
            bw = new BufferedWriter(new FileWriter(filePath,true));
//            bw.write(str,0,str.length());
            bw.write("hello，Leo");
            // 换行
            bw.newLine();
            bw.write("hello，Leo1");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
