package com.example.test.iostream.buffer;

import javax.persistence.Id;
import java.io.*;

/**
 * @Author ： Leo
 * <p>顺序：9
 * @Date : 2021/6/9 14:25
 * @Desc: 通过
 * BufferedWriter 和 BufferedReader
 * 以及
 * BufferedInputStream和BufferedOutputStream
 * 实现文件的拷贝
 * <p>
 * <p>
 * BufferedWriter和BufferedReader
 * 说明：一般进行 只含字符的文件进行拷贝，比如字符串，一篇文章等等
 * 如果对 音乐 ，视频等文件进行拷贝时，会出现拷贝后的文件 无法解析打开，实则拷贝无效。
 * <p>
 * <p>
 * <p>
 * BufferedInputStream和 BufferedOutputStream
 * 常用来 处理二进制文件 ，也就是字节文件，比如图片，音乐，视频等
 * 当然也可以来 操作字符文件，比如 .txt，.java文件
 * <p>
 * 一切文件 都可 以字节为单位存储的，二进制文件
 */
public class CopyFileByBuffer {
    public static void main(String[] args) throws IOException {

//        copyFile1();
        copyFileByBufferXXXStream();
    }

    /**
     * 使用
     */
    private static void copyFileByBufferXXXStream() throws IOException {
        // 拷贝字符文件
      /*  String srcFilePath = "G:\\testIO\\story.txt";
        String descFilePath = "E:\\story.txt";*/
        // 拷贝图片
        String srcFilePath = "G:\\testIO\\6.jpg";
        String descFilePath = "E:\\8.jpg";
        // 拷贝音乐
        /*String srcFilePath = "G:\\testIO\\8.mp3";
        String descFilePath = "E:\\8.mp3";*/
        // 拷贝视频
        /*String srcFilePath = "G:\\testIO\\h5.mp4";
        String descFilePath = "E:\\h5.mp4";*/

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFilePath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(descFilePath, true));

        byte[] buff = new byte[1024];
        int readLen = 0;
        // 当返回-1，即读取完毕
        while ((readLen = bis.read(buff)) != -1) {
            bos.write(buff, 0, readLen);
        }

        /*String str ="leo打怪兽";
        bos.write(str.getBytes());*/

        System.out.println("文件拷贝完毕~~");
        // 关闭流
        bis.close();
        bos.close();


    }

    /**
     * 使用BufferedWriter和BufferedReader进行拷贝文件
     */
    private static void copyFile() throws IOException {

        String filePath = "G:\\testIO\\story.txt";
        String targetPath = "E:\\s.txt";

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath));
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
