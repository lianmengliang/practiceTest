package com.example.test.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ： Leo
 * @Date : 2021/5/28 15:49
 * @Desc: 正则表达式 的操作
 * <p>
 * 正则表达式的原理
 */
public class RegTheory {
    public static void main(String[] args) {
//        test(CONTENT);
        test001();
    }


    private static final String CONTENT = "1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、单调的静态网页能够“灵活”起来，急需一种软件技术来开发一种程序，这种程序可以通过网络传播并且能够跨平台运行。于是，世界各大IT企业为此纷纷投入了大量的人力、物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，并且重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结构进行编写的，所以非常小，特别适用于网络上的传输系统，而Oak也是一种精简的语言，程序非常小，适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以随同网页在网络上传输的Applet（Applet是一种将小程序嵌入到网页中进行执行的技术），并将Oak更名为Java（在申请注册商标时，发现Oak已经被人使用了，再想了一系列名字之后，最终，使用了提议者在喝一杯Java咖啡时无意提到的Java词语）。5月23日，Sun公司在Sun world会议上正式发布Java和HotJava浏览器。IBM、Apple、DEC、Adobe、HP、Oracle、Netscape和微软等各大公司都纷纷停止了自己的相关开发项目，竞相购买了Java使用许可证，并为自己的产品开发了相应的Java平台.47.110.250.155\n" +
            "139.224.165.158\n" +
            "47.110.137.43++898912342";
    /*匹配单词**/
    private static final Pattern Pattern_LETTER = Pattern.compile("[a-zA-Z]+");


    /**
     * 正则表达式的使用
     * 括号的使用：（） 括号就代表分组。一个小括号就代表一个分组
     *
     * @param str
     */
    public static void test(String str) {
        //1.
        String regStr = "\\d\\d\\d\\d";
        String regStr1 = "\\d\\d\\d\\d";
        Pattern pattern = Pattern.compile(regStr1);

        Matcher matcher = pattern.matcher(CONTENT);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
           /* System.out.println("第1组："+matcher.group(1));
            System.out.println("第2组："+matcher.group(2));
            System.out.println("第3组："+matcher.group(3));*/
        }
    }


    /**
     * 测试
     */
    public static void test001() {
        /**
         * 示例：
         * <a href="https://sh.house.163.com">上海房产</a>
         * <a href="http://news.163.com/photo">图片</a>
         * <a href="https://reg.163.com/" class="ntes-nav-login-title" id="js_N_nav_login_title">登录</a>
         * <a href="https://vip.open.163.com/#ftopnav5"> <span>付费精品课程</span>   </a>
         * <a href="https://you.163.com/item/recommend?from=out_ynzy_xinrukou_5"> <span>人气好物</span>
         * <a href="https://mail.163.com/dashi/dlpro.html?from=mail46"> <span>客户端下载</span> </a>
         */

        String content = " <a href=\"https://sh.house.163.com\">上海房产</a>" +
                "          <a href=\"http://news.163.com/photo\">图片</a>" +
                "          <a href=\"https://reg.163.com/\" class=\"ntes-nav-login-title\" id=\"js_N_nav_login_title\">登录</a>" +
                "          <a href=\"https://vip.open.163.com/#ftopnav5\"> <span>付费精品课程</span>   </a>" +
                "          <a href=\"https://you.163.com/item/recommend?from=out_ynzy_xinrukou_5\"> <span>人气好物</span></a>" +
                "          <a href=\"https://mail.163.com/dashi/dlpro.html?from=mail46\"> <span>客户端下载</span> </a>";
        String regStr = "<a[\\w\\s\\S]+?</a>";

        regStr = "\\d{4}-\\d{7}|\\d{3}-\\d{8}";
        regStr ="\\d{4}-\\d{7}|\\d{3}-\\d{8}";

        /*regStr = "<a[\\s]href=\"((https|http)://[\\w\\s\\S]+?)>([\\w\\s\\S]+)*(.)*([\\u0391-\\uffe5]+)(.{7,11})*</a>";*/


        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
           /* System.out.println("group1--->"+matcher.group(1));
            System.out.println("group2--->"+matcher.group(2));
            System.out.println("group3--->"+matcher.group(3));
            System.out.println("group4--->"+matcher.group(4));
            System.out.println("group5--->"+matcher.group(5));
            System.out.println("group6--->"+matcher.group(6));*/
        }
    }


}
