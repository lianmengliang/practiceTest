package com.example.test.regularexpression;

import jdk.nashorn.internal.ir.IfNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ： Leo
 * @Date : 2021/6/3 17:03
 * @Desc: 从网上爬取网页内容，然后使用正则表达式筛选自己所需要的内容
 */
public class InternetWormDemo {

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {

        test();
    }


    /**
     * 测试
     */
    public static void test() {
        // 获取爬取内容
        String content = getStringByURL(URL, GBK_FORMAT);

        // 筛选爬取内容

        /**
         * 示例：
         * <a href="https://sh.house.163.com">上海房产</a>
         * <a href="https://reg.163.com/" class="ntes-nav-login-title" id="js_N_nav_login_title">登录</a>
         * <a href="https://vip.open.163.com/#ftopnav5"> <span>付费精品课程</span>   </a>
         * <a href="https://you.163.com/item/recommend?from=out_ynzy_xinrukou_5"> <span>人气好物</span>
         * <a href="https://mail.163.com/dashi/dlpro.html?from=mail46"> <span>客户端下载</span> </a>
         */
//        String regStr = "<a[\\w\\s\\S]+?</a>";

        /**
         * href="https://jiankang.163.com/21/0526/11/GATU99FO0038804U.html"
         * href="https://jiankang.163.com/photoview/5S400038/10433.html"
         * href="<%=newrow.relatedActionLinks[0].url%>"
         * href="<%=newrow.relatedActionLinks[0].url%>"
         */
//        regStr = "href=\"(.+?)\"";
        // regStr = "href=\"(https:[\\w\\s./]+?)\"";
        /*content = "213444";
        PATTERN = "[a-z]{3}";*/
        // 纯汉字"^[\\u0391-\\uffe5]+$"
//        PATTERN = "<a[\\w\\s\\S]+?(herf=\"(http|https)\\w\\.)[\\w\\s\\S]+?([\\u0391-\\uffe5]+)[\\w\\s\\S]+?</a>";

        /**
         * <a ne-role="feedBackLink" ne-click="handleFeedBackLinkClick()"
         * href="http://www.163.com/special/0077450P/feedback_window.html"
         * class="ne_foot_feedback_link">
         * 意见反馈
         * </a>
         * url 分析：
         *
         */
//        PATTERN = "<a[\\w\\s\\S]+?</a>";
        PATTERN = "href=\"((https|http):[\\w\\s./]+?)\"";

        List<String> list = getResultByPattern(content, PATTERN);
        for (String url : list) {
            System.out.println(url);
        }

    }


    /**
     * 正则表达式
     */
    private static String PATTERN = "<a[\\w\\s\\S]+?</a>";

    /**
     * 要爬取的网址
     */
    private static String URL = "https://news.163.com/";

    /**
     * 编码格式
     */
    private static String GBK_FORMAT = "gbk";
    private static String UTF_FORMAT = "utf";

    /**
     * 一些常见网址后缀
     */
    private static final String COM_SUFFIX = ".com";
    private static final String CN_SUFFIX = ".cn";
    private static final String HTML_SUFFIX = ".html";
    private static final String HTM_SUFFIX = ".htm";
    private static final String NET_SUFFIX = ".net";
    /**
     * 图片后缀
     */
    private static final String PNG_SUFFIX = ".png";
    private static final String JPG_SUFFIX = ".jpg";


    /**
     * 获取中文
     */
    public static void getChinese(){
        // 获取爬取内容
        String content = getStringByURL(URL, GBK_FORMAT);
        PATTERN = "([\\u0391-\\uffe5]+)";
        List<String> list = getResultByPattern(content, PATTERN);

        list.forEach(System.out::println);
    }

    /**
     * 获取各种格式网址
     */
    public static void getAllKindsURLList() {
        // 获取爬取内容
        String content = getStringByURL(URL, GBK_FORMAT);
        PATTERN = "(http|https)://[\\w+\\.?/?]+\\.[a-zA-Z]+";
        List<String> list = getResultByPattern(content, PATTERN);
        ArrayList<String> cnList = new ArrayList<>();
        ArrayList<String> comList = new ArrayList<>();
        ArrayList<String> pictureList = new ArrayList<>();
        ArrayList<String> htmlList = new ArrayList<>();
        ArrayList<String> otherList = new ArrayList<>();
        list.forEach(e -> {
            if (e.endsWith(COM_SUFFIX)) {
                comList.add(e);
            } else if (e.endsWith(CN_SUFFIX)) {
                cnList.add(e);
            } else if (e.endsWith(JPG_SUFFIX) || e.endsWith(PNG_SUFFIX)) {
                pictureList.add(e);
            } else if (e.endsWith(HTML_SUFFIX) || e.endsWith(HTM_SUFFIX)) {
                htmlList.add(e);
            } else {
                otherList.add(e);
            }
        });


        System.out.println("cnList------------------------------------------------------------");
        cnList.forEach(System.out::println);
        System.out.println("comList------------------------------------------------------------");
        comList.forEach(System.out::println);
        System.out.println("pictureList--------------------------------------------------------");
        pictureList.forEach(System.out::println);
        System.out.println("htmlList--------------------------------------------------------");
        htmlList.forEach(System.out::println);
        System.out.println("otherList-----------------------------------------------------------");
        otherList.forEach(System.out::println);

    }


    /**
     * 根据 目标字符串 和 正则表达式 获取匹配的内容，以集合的方式返回
     *
     * @param targetStr
     * @param regStr
     * @return
     */
    public static List<String> getResultByPattern(String targetStr, String regStr) {
        ArrayList<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(targetStr);
        while (matcher.find()) {
            list.add(matcher.group(0));
        }
        return list;
    }

    /**
     * 根据网址 和 编码格式 来获取网页内容 （这个操作必须联网）
     *
     * @param urlStr
     * @param codingFormat
     * @return
     */
    public static String getStringByURL(String urlStr, String codingFormat) {
        // 用于存取内容
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(codingFormat)));
            // 临时变量
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                sb.append(temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void getList(String e){

    }
}
