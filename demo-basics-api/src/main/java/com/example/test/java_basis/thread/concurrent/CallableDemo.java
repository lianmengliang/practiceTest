package com.example.test.java_basis.thread.concurrent;

import com.example.test.java_basis.thread.api.WebDownloader;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.*;

/**
 * @Author ： Leo
 * @Date : 2021/6/29 17:20
 * @Desc: 参考：
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

        ExecutorService service = newFixedThreadPool(2);
        Future<?> submit = service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("创建线程池哦");
            }
        });



    }

    /**
     * 1.  4种 创建线程池的方法
     * 2. 线程池有5种状态：Running、ShutDown、Stop、Tidying、Terminated。
     * 3. 线程池中 submit()和 execute()方法有什么区别？
     *      a). 接收的参数不一样
     *      b). submit有返回值，而execute没有
     *      c). submit方便Exception处理
     */
    public static void createTeadPoll() {

        /**
         * 创建一个固定长度的线程池，每当提交一个任务就创建一个线程，直到达到线程池的最大数量，
         * 这时线程规模将不再变化，当线程发生未预期的错误而结束时，线程池会补充一个新的线程。
         */
        ExecutorService service1 = newFixedThreadPool(3);

        /**
         * 创建一个可缓存的线程池，如果线程池的规模超过了处理需求，将自动回收空闲线程，
         * 而当需求增加时，则可以自动添加新线程，线程池的规模不存在任何限制。
         */
        ExecutorService service2 = newCachedThreadPool();


        /**
         * 这是一个单线程的Executor，它创建单个工作线程来执行任务，
         * 如果这个线程异常结束，会创建一个新的来替代它；它的特点是能确保依照任务在队列中的顺序来串行执行。
         */
        ExecutorService service3 = newSingleThreadExecutor();

        /**
         * 创建了一个固定长度的线程池，而且以延迟或定时的方式来执行任务，类似于Timer
         */
        ScheduledExecutorService service4 = Executors.newScheduledThreadPool(3);

        ThreadPoolExecutor th = new ThreadPoolExecutor(1, 2, 1000, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        // 1. 创建目标对象
        JPGDownloader j1 = new JPGDownloader("http://static.ws.126.net/f2e/news/res/img/cloudapp_8.png", "j1");
        Future<Boolean> submit = th.submit(j1);
        try {
            Boolean aBoolean = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}


/**
 * 3-5年
 * 高级并发课程：JUC 的并发编程的一部分
 */
class JPGDownloader implements Callable<Boolean> {

    private String jpgUrl;

    private String jpgName;

    public JPGDownloader(String jpgUrl, String jpgName) {
        this.jpgUrl = jpgUrl;
        this.jpgName = jpgName;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(jpgUrl, jpgName);
        return true;
    }
}
