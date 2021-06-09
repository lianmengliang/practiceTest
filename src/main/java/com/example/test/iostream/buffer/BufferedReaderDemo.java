package com.example.test.iostream.buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author ： Leo
 * @Date : 2021/6/9 12:14
 * @Desc:
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        bufferedReadFile();
    }

    public static void bufferedReadFile() throws IOException {
        String filePath = "G:\\testIO\\story.txt";

        BufferedReader br = null;

        br = new BufferedReader(new FileReader(filePath));

        // 读取
        String line;
        // 说明
        // 1.按行读取，表示
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        //关闭流，这里注意，只需要关闭BufferedReader，
        // 因为底层会自动去关闭 节点流
        br.close();
    }


}
