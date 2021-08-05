package com.example.test.javaBasis.thread.api;


import cn.hutool.core.io.FileUtil;
import com.mchange.v2.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author ： Leo
 * @Date : 2021/6/29 16:37
 * @Desc:
 */
public class WebDownloader {

    @Test
    public void testDownload() throws MalformedURLException {
        download("https://img-home.csdnimg.cn/images/20210414021151.jpg", "3");
    }

    /**
     * 根据图片地址，下载保存到本地
     * @param urlStr：图片url地址
     * @param name： 重新命名
     * @throws MalformedURLException
     */
    public  void download(String urlStr, String name) throws MalformedURLException {

        URL url = new URL(urlStr);
        String targetPath = "src/" + name + ".jpg";
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            inputStream = url.openStream();
            fos = new FileOutputStream(targetPath);
            byte[] bytes = new byte[1024];
            int readLen = 0;
            while ((readLen = inputStream.read(bytes)) != -1) {
                fos.write(bytes, 0, readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                fos.close();
                System.out.println("下载文件成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
