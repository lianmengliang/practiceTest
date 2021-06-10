package com.example.test.iostream.transformation;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author ： Leo
 * <p>顺序：12
 * @Date : 2021/6/10 15:01
 * @Desc:
 *
 * 转换流的练习： InputStreamReader 和 OutputStreamWriter
 *
 * 指定编码格式
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {

//        readFile();

//        readFileByTransformation();

        writeFileByTransformation();

    }
    /**
     * 转换流实现文件的读取：
     *
     * 1.转换为字符输出流，并指定编码格式
     * 2.根据字符输出流，创建缓冲输出流
     * StandardCharsets.UTF_8
     * */
    private static void writeFileByTransformation() throws IOException{
        String filePath = "G:\\testIO\\s.txt";
        // 1.转换为字符输出流，并指定编码格式
        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8);
        // 2.根据字符输出流，创建缓冲输出流
        BufferedWriter bw = new BufferedWriter(os);
        bw.write("hello,Leo打怪兽");
        bw.close();
        System.out.println("保存文件成功");

    }

    /**
     * 转换流实现文件的读取：
     * 1.使用InputStreamReader 转换为字符输入流，并指定编码为“gbk”
     * 2.根据InputStreamReader创建BufferedReader，缓冲输入流
     *
     *  BufferedReader 处理文本文件 效率更高
     * @throws {IOException}
     */
    private static void readFileByTransformation() throws IOException {
        String filePath = "G:\\testIO\\s.txt";

        // 1.转换为字符输入流，并指定编码格式
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), "gbk");
        // 2.根据字符输入流，创建缓冲输入流
        BufferedReader bufferedReader = new BufferedReader(reader);
        String readLine = null;
        while ((readLine = bufferedReader.readLine()) != null) {
            System.out.println(readLine);
        }
        bufferedReader.close();

    }




    /**
     * 使用BufferedReader 【处理流】
     * <p>
     * 为了引出下面的 字节流 转码问题 （指定编码格式）
     */
    private static void readFile() throws IOException {

        String filePath = "G:\\testIO\\story.txt";

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String readLine = null;
        while ((readLine = br.readLine()) != null) {

            System.out.println(readLine);
        }

        br.close();
    }


}
