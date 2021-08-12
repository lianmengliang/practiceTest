package com.example.test.javaBasis.thread.concurrent;

import com.example.test.javaBasis.thread.api.WebDownloader;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.*;

/**
 * @Author ： Leo
 * @Date : 2021/6/29 17:20
 * @Desc:
 *
 * 参考：
 * 图片地址
 * http://img3.cache.netease.com/news/2016/7/21/20160721131401d35e2.jpg
 * http://img3.cache.netease.com/news/2016/7/21/201607211319466e84e.jpg
 * http://img5.cache.netease.com/news/2016/7/21/20160721132119ef59b.jpg
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1. 创建目标对象
        JPGDownloader j1 = new JPGDownloader("http://static.ws.126.net/f2e/news/res/img/cloudapp_8.png", "j1");
        JPGDownloader j2 = new JPGDownloader("http://static.ws.126.net/f2e/news/index2015/img/newsapp.png", "j2");
        JPGDownloader j3 = new JPGDownloader("http://static.ws.126.net/f2e/news/res/img/cloudapp.png", "j3");

        // 2.创建执行服务
        ExecutorService ser = newFixedThreadPool(3);

        // 3.提交执行
        Future<Boolean> submit1 = ser.submit(j1);
        Future<Boolean> submit2 = ser.submit(j2);
        Future<Boolean> submit3 = ser.submit(j3);

        // 4.获取结果
        Boolean result1 = submit1.get();
        Boolean result2 = submit2.get();
        Boolean result3 = submit3.get();
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        // 5.关闭服务
        ser.shutdownNow();

    }
}


/**
 * 3-5年
 * 高级并发课程：JUC 的并发编程的一部分
 */
class JPGDownloader implements Callable<Boolean>{

    private String jpgUrl;

    private String jpgName;

    public JPGDownloader(String jpgUrl, String jpgName) {
        this.jpgUrl = jpgUrl;
        this.jpgName = jpgName;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(jpgUrl,jpgName);
        return true;
    }
}
