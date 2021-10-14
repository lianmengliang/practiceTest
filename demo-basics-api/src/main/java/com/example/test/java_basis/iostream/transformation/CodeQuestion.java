package com.example.test.java_basis.iostream.transformation;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author ： Leo
 * <p>顺序：12
 * @Date : 2021/6/10 15:01
 * @Desc: 字符转换流:
 * 转换流的练习： InputStreamReader 和 OutputStreamWriter
 * <p>
 * 指定编码格式
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {

        copyFile();

//        readFileByTransformation();

//        writeFileByTransformation();

    }

    /**
     * 转换流实现文件的写入：
     * <p>
     * 1.转换为字符输出流，并指定编码格式
     * 2.根据字符输出流，创建缓冲输出流
     * StandardCharsets.UTF_8
     */
    private static void writeFileByTransformation() throws IOException {
        String filePath = "G:\\testIO\\s1.txt";
        // 1.转换为字符输出流，并指定编码格式
        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8);

        os.write("hello,LEO打怪兽");
        os.close();

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
     * <p>
     * BufferedReader 处理文本文件 效率更高
     *
     * @throws {IOException}
     */
    private static void readFileByTransformation() throws IOException {
        String filePath = "G:\\testIO\\s.txt";

        // 1.转换为字符输入流，并指定编码格式
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), "gbk");
        /*char[] chars = new char[1024];
        int data = 0;
        while ((data = reader.read(chars)) != -1) {
            System.out.println((char)data);
        }
*/

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
     * 为了引出下面的 字符流 转码问题 （指定编码格式）
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


    /**
     * 使用BufferedWriter和BufferedReader进行拷贝文件
     */
    private static void copyFile() throws IOException {

        String filePath = "G:\\testIO\\story.txt";
        String targetPath = "E:\\sss.txt";

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetPath), StandardCharsets.UTF_8));
        String line = null;
        // 按行读取
        while ((line = br.readLine()) != null) {
            // 每读取一行，就写入
            bw.write(line, 0, line.length());
            // 每读一行就换行
            bw.newLine();
        }
        System.out.println("拷贝完毕~~");
        // 关闭流
        br.close();
        bw.close();
    }

}
