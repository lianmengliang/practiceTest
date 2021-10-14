package com.example.test.java_basis.regularexpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ： Leo
 * @Date : 2021/5/28 17:27
 * @Desc: 演练转义字符的使用: 两个斜杠 \\ 代表转移
 * \\ 符号说明：在我们使用正则表达式去检索某些特殊字符的时候，
 * 需要用到转义，否则检索不到结果，甚至会会报错。 如：用$ 去匹配 "abc$(" 会怎样？
 * <p>
 * 再次提示：
 * 在Java的正则表达式中，两个 \\代表其他语言中的一个
 * 元字符-转义符：
 * 需要用到的转义符号的有以下：.*+()[]{}$%^/\?
 * <p>
 * <p>
 * ? : 代表 0到 1
 * 符号：[] -->可接受的字符列表。示例：[efgh] -->e,f,g,h中的任意一个字符
 * 符号：[^] -->不接受的字符列表。示例：[^abc] -->除a,b,c之外的任一1个字符，包括数字和特殊符号
 * 符号：- -->连字符。示例：A-Z -->任意单个大写字母
 * <p>
 * <p>
 * 符号：. -->匹配除\n，以外的任何字符。
 * 示例：a..b  ---> aaab, aefb ,a21b
 * 说明：以a开头，b结尾，中间包含2个任一字符的长度为4的字符串
 * 符号：\\d -->匹配单个数字字符，相当于[0-9]。
 * 示例：\\d{3}(\\d)  ---> 123, 9876 ,a21b
 * 说明：包含3个或4个数字的字符串
 * 符号：\\D -->匹配单个非数字字符，相当于[^0-9]
 * 示例：\\d{3}(\\d)  ---> 123, 9876 ,a21b
 * 说明：包含3个或4个数字的字符串
 * 符号：\\w -->匹配单个数字，大小写字母字符和下划线_，相当于[0-9a-zA-Z_]
 * <p>
 * 符号：\\W -->匹配单个非数字，大小写字母字符，相当于[^0-9a-zA-Z] (相当于匹配特殊符号)
 * <p>
 * 符号：\\s -->匹配任何空白字符
 * <p>
 * 符号：\\S -->匹配任何非空白字符
 * <p>
 * <p>
 * 符号：
 * 示例：\\d{3}(\\d)  ---> 123, 9876 ,a21b
 * 说明：包含3个或4个数字的字符串
 */
public class RegExp01 {


    /**
     * 用于测试
     */
    public static void test001() {
        content = "a11c8";
        regStr = "[A-Z]";
        pattern(content, regStr);

        // 测试贪婪匹配
        content = "a111111aaaa1helloLeo";
        regStr = "1{2,4}";
        pattern(content, regStr);

        // 演示?的使用，遵守贪婪匹配
        // 匹配a 或 a1, 因此首先去匹配a1 ，其次是匹配a
        regStr = "a1?";
        pattern(content, regStr);

        // 演示下 \\b:匹配目标字符串的边界 （指后边界，如符合条件的以空格结尾或是最后一个）
        // 这里说的字符串的边界是子串间有空格，或者是目标字符串的结束为止
        // 如：shan nnhan  , han\\b -->两个han都会匹配到
        content = " hanshun pingshan nnhan";
        regStr = "han\\b";
        pattern(content, regStr);

        // \\B :匹配目标字符串的非边界（指前边界，如符合条件的以空格开头的或是第一个的）
        // 如：hanshun hanp ，han\\B -->两个han都会匹配到
        regStr = "han\\B";
        pattern(content, regStr);


        // 测试起始和结束 字符
        content = "3-abbbb";
        regStr = "^[0-9]+[a-z]*$";
        pattern(content, regStr);

        regStr = "^[0-9]\\-[a-z]+$";
        pattern(content, regStr);

        // 常用分组：(pattren)
        content = "16789781";
       /* regStr = "(\\d(\\d))(\\d(\\d))(\\d)";
        patternGroup(content,regStr);*/

        // 命名分组 （<?name> patttren）
        regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)(\\d)";
        //patternGroup(content, regStr);

        //特别分组：非捕获分组
        // (?:pattren), 细节： 这里面的括号不是分组，不能mather.group(1);
        // 和 或 | 的功能类似
        content = "Leo同学ae1 Leo老师 helloLeo帅哥 Leo教育Leo";
        regStr = "Leo同学|Leo老师|Leo帅哥";
        regStr = "Leo(?:同学|老师|帅哥)";
        pattern(content, regStr);

        // (?=pattren) 找到Leo这个关键词，但是要求是查找Leo同学和Leo老师中含有的Leo
        // 简单理解为：查找满足 ?=后(同学|老师)的 Leo
        regStr = "Leo(?=同学|老师)";
        pattern(content, regStr);

        // (?!pattren)
        // 简单理解：查找满足除?=后(同学|老师)的以外 Leo 和(?=pattern)的意思相反
        regStr = "Leo(?!同学|老师)";
        pattern(content, regStr);

        //? 当此字符紧随任何其他限定符（*、+、?、{n}、{n,}、{n,m}）之后时，
        // 匹配模式是"非贪心的 ,即尽可能匹配少的
        content = "12221";
        regStr = "\\d+?";
        pattern(content, regStr);

        // 举例：
        // 1. 验证是否为汉字   ^[\u0391-\uffe5]+$
        // 2.验证邮政编码    ^[1-9]$\\d{5}$   开头是1-9的开头的6位数
        // 3。验证QQ号：1-9开头的5位数-10位数   ^[1-9]\\d{4,9]$
        // 4.验证手机号：要求：必须是13，14，15，18开头的11位数  ^1[3|4|5|8]\\d{9}$
        // 5.验证URL： 如：https://www.bilibili.com/video/BV1qq4y1E7tp?spm_id_from=333.851.b_7265636f6d6d656e64.1
        // 分析： http或https开头

        // 验证汉字 （字符串是否为 纯汉字）
        content = "正则表达式的验证";
        regStr = "^[\u0391-\uffe5]+$";
        patternBoolean(content, regStr);

        // 验证邮政编码:开头是1-9的开头的6位数
        content = "425233";
        regStr = "^[1-9]\\d{5}$";
        patternBoolean(content, regStr);

        // 验证QQ号： 开头是1-9的开头的5-10位的数字
        content = "123212789";
        regStr = "^[1-9]\\d{4,9}$";
        patternBoolean(content, regStr);

        // 验证手机号: 13,14,15,18开头的11位数
        content = "15036808604";
        regStr = "^1(?:3|4|5|8)\\d{9}$";
        regStr = "^1[3|4|5|8]\\d{9}$";
        patternBoolean(content, regStr);

        //"0?1\\d{10}";
        content = "https://www.bilibili.com/video/BV1qq4y1E7tp?spm_id_from=333.851.b_7265636f6d6d656e64.1";
        regStr = "^((http|https)://)([\\w]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$";
//        regStr = "^(https|http)://([\\w]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$";
        /**
         * 思路分析：
         * 1.先确定url的开始部分 http|https ://
         */
        patternBoolean(content, regStr);


        content = "92814,9101,8689,8431,8164,7975,7832,7625,7441,8906";
        content = "92842";
        // 需要考虑的情况是： 假如只有一个广告id  8721,  或者最后一个广告id 3892
        regStr = "^([1-9]\\d{3,4},)*([1-9]\\d{3,4})$";
        boolean matches = content.matches(regStr);
        System.out.println("----------->" + matches);
        patternBoolean(content, regStr);

        Pattern.matches(regStr, content);
        content.matches(regStr);

        // 分组： 有几对小括号就有几个分组，分组用matcher.group(0)获得
        content = "126668882121299jkl";
        regStr = "((\\d{2})(\\d{3}))(\\d)";

        patternGroup(content, regStr);
        /**
         *
         * strA.contains(strB)
         * strA.indexOf(strB)
         * strA.matches(strB)
         * 测试结果发现，
         * 1.如果strA中不包括strB，使用strA.Contains(strB)更优；
         * 2.反之，如果strA中包括strB，使用strA.IndexOf(strB)更优。
         * 3.(Regex.Match在此方法中貌似没有体现出任何优势，它更适用于模糊匹配)
         */

        /*content = "hello2131321hello333332";
        regStr = "hello";
        String leo = content.replaceAll(regStr, "Leo");
        System.out.println(leo);*/

        // 反向引用：内部反向引用\\分组号，外部反向引用$分组号
        content = "21334488480660";
        // 匹配2个连续相同的数字  (\\d)\\1
        regStr = "(\\d)\\1";
        pattern(content, regStr);
        // 匹配5个连续相同的数字  (\\d)\\1{4}
        regStr = "(\\d)\\1{4}";
        pattern(content, regStr);
        // 匹配个位与千位，十位与百位相同的数字 (\\d)(\\d)\\2\\1
        regStr = "(\\d)(\\d)\\2\\1";
        pattern(content, regStr);

        /**
         * 请在字符串中检索商品编号，形式如：12321-333666888这样的号码
         * 要求满足前面是一个五位数，然后一个 - 特殊符号，后面是一个9位数，连续三位要相同
         */
        content = "45682-222666888";
//        regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
        regStr = "(\\d){5}-(\\d)\\2{2}(\\d)\\3{2}(\\d)\\4{2}";
        pattern(content, regStr);

        // 我...我我....要要要学...编编编程...java  -->我要学编程java
        // 1.去掉...
        content = "我...我我....要要要学学学...编程...java";
        regStr = "\\.";
        content = content.replaceAll(regStr, "");  // 我我我要要要学学学编程java
        System.out.println(content);
        // 2.找到重复的   (.)\\1
        regStr = "(.)\\1+";
        pattern(content, regStr);


    }


    private static String content = "abc.$ee(abc.(123\n(";

    private static String regStr = "\\d";

    /**
     * 根据字符串 和 匹配规则，来执行正则表达式过程
     *
     * @param content
     * @param regStr
     */
    public static void pattern(String content, String regStr) {
        Pattern pattern = Pattern.compile(regStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        int n = 0;
        while (matcher.find()) {
            System.out.println("找到：" + (++n) + "--> " + matcher.group(0));
        }
        System.out.println("-------------------------------------------------------");
    }

    /**
     * 匹配那些特殊的匹配 规则：如分组，
     *
     * @param content
     * @param regStr
     */
    public static void patternGroup(String content, String regStr) {
        Pattern pattern = Pattern.compile(regStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
            System.out.println("找到：" + matcher.group(1));
//            System.out.println("第一个分组：" + matcher.group("g1"));
            System.out.println("找到：" + matcher.group(2));
//            System.out.println("第二个分组：" + matcher.group("g2"));
            System.out.println("找到：" + matcher.group(3));
            System.out.println("找到：" + matcher.group(4));
//            System.out.println("找到：" + matcher.group(5));
            System.out.println("++++++++++++++++++++++++++");
            System.out.println(matcher.start() + "--->" + matcher.end() + "=" + content.substring(matcher.start(), matcher.end()));
        }
        System.out.println("-------------------------------------------------------");
    }


    public static void patternBoolean(String content, String regStr) {
        Pattern pattern = Pattern.compile(regStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            System.out.println("满足格式：true");
        } else {
            System.out.println("不满足格式：false");
        }
        System.out.println("-------------------------------------------------------");
    }

    /**
     *
     */
    public static void test002() {

        String con = "hop@souhu.com";
        String reg = "^[\\w]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        con = "lian@shen.liang.com";
        // 匹配163邮箱或者qq邮箱    18238691710@163.com   17123700499@qq.com
        reg = "^\\d+@[a-zA-Z0-9]+\\.[a-z]+$";
        con = "18238691710@163.com";


        // 要求验证是不是整数或者小数
        // 提示：这个题要考虑正数和负数 如： 123，-123，0.9，34.23 ,-2.4
        // 思路分析： 1.先写简单的正则表达式  2.再逐步完善【根据各种情况修改完善】
        con = "-0.1230";
        reg = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";

        if (con.matches(reg)) {
            System.out.println("匹配成功");
        } else {
            System.out.println("匹配失败");
        }
        /**
         * 对一个url进行解析： 如：https://www.sohu.com:8080/abc/index.html
         * a)要求得到的协议是什么？  http
         * b)域名？  www.sohu.com
         * c)端口？  8080
         * d)文件名？ index.html
         */
        con = "https://www.sohu.com:8080/abc/index.html";
//        reg = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";
        reg = "^([a-z]+)://([a-z.]+):(\\d+)/[\\w/]+/([\\w.]+)$";

        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(con);

        if (matcher.matches()) {
            System.out.println("匹配成功");
            System.out.println("匹配内容：" + matcher.group(0));
            System.out.println("协议：" + matcher.group(1));
            System.out.println("域名：" + matcher.group(2));
            System.out.println("端口：" + matcher.group(3));
            System.out.println("文件名：" + matcher.group(4));
        } else {
            System.out.println("匹配失败");

        }


    }

    public static void test003() {
        // 我...我我....要要要学...编编编程...java  -->我要学编程java
        // 1.去掉...
        content = "我...我我....要要要学学学...编程...java";
        content = content.replaceAll("\\.", "");  // 我我我要要要学学学编程java
        System.out.println(content);
        // 2.找到重复的   (.)\\1
        regStr = "(.)\\1+";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("$1");
//        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println(content);

        // 总结一句话
      /*  content = "我...我我....要要要学学学...编程...java";
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");
        System.out.println("content=" + content);
       *//* pattern = Pattern.compile("(.)\\1+");
        matcher = pattern.matcher(content);
        content = matcher.replaceAll("$1");*//*
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");*/

    }

    /**
     * 正则表达式 零宽断言
     */
    public static void test004() {

        String str = "abcdLeo同学ILoveLeo老师javaLeo帅哥";

        // 零宽度 正向先行断言
        // 匹配 后面是Leo的4个字符 （或：匹配Leo前的4个字符）
        String regStr = ".{4}(?=Leo)";
        pattern(str, regStr);
        /** 结果:
         * 找到：1--> abcd
         * 找到：2--> Love
         * 找到：3--> java
         */

        // 零宽度 正向后行断言
        // 匹配 前面是Leo的 2个字符 （或：匹配Leo后的两个字符）
        regStr = "(?<=Leo).{2}";
        pattern(str, regStr);
        /** 结果:
         * 找到：1--> 同学
         * 找到：2--> 老师
         * 找到：3--> 帅哥
         */


        str = "Leo34同学Leo56老师Leo88帅哥java66Leo教育99Leo";
        // 零宽度 正向后行断言
        // 匹配后面不是Leo的2个数字
        regStr = "\\d{2}(?!Leo)";
        pattern(str, regStr);
        /** 结果:
         * 找到：1--> 34
         * 找到：2--> 56
         * 找到：3--> 88
         */

        // 零宽度 负向后行断言
        // 匹配前面不是Leo的2个数字
        regStr = "(?<!Leo)\\d{2}";
        pattern(str, regStr);
        /** 结果:
         * 找到：1--> 66
         * 找到：2--> 99
         */
    }

    /**
     * 网络爬虫 :Internet worm
     */
    public static void test005() {

        String url = getURL("https://news.163.com/", "gbk");
        System.out.println(url);
        /**
         * 示例：
         * <a href="https://sh.house.163.com">上海房产</a>
         * <a href="https://reg.163.com/" class="ntes-nav-login-title" id="js_N_nav_login_title">登录</a>
         * <a href="https://vip.open.163.com/#ftopnav5"> <span>付费精品课程</span>   </a>
         * <a href="https://you.163.com/item/recommend?from=out_ynzy_xinrukou_5"> <span>人气好物</span></a>
         * <a href="javascript:;" target="_self" class="ad_hover_href"></a>
         * <a href="https://news.163.com/special/2021chj/"><img ne-lazy="effect:fadeIn;slideIndex:0;" data-original="https://cms-bucket.ws.12.net/2021/0205/e87fdd44j00qo12ch001nc0008c002ic.jpg?imageView&thumbnail=300y90" width="300" height="90" alt="2021年春节春运"></a>
         */
        String regStr = "<a[\\w\\s\\S]+?>([\\w\\s\\S]+?)</a>";

        regStr = "<a[\\w\\s\\S]+?]>[\\u0391-\\uffe5]+</a>";
        /**
         * href="https://jiankang.163.com/21/0526/11/GATU99FO0038804U.html"
         * href="https://jiankang.163.com/photoview/5S400038/10433.html"
         * href="<%=newrow.relatedActionLinks[0].url%>"
         * href="<%=newrow.relatedActionLinks[0].url%>"
         */
        /**
         *group(0): href="https://jiankang.163.com/21/0602/23/GBH9BMI00038804U.html"
         *  或： href="javascript:;"
         *      href="<%=vhouse.houselink%>"
         *         href="javascript:void(0);"
         *
         */
        regStr = "href=\"(.+?)\"";

        regStr = "(http|https)://[\\w+\\.?/?]+\\.[a-zA-Z]+";
        /**
         * group(0):href="https://corp.163.com/gb/job/job.html"
         * group(1):https://corp.163.com/gb/job/job.html
         */
//        regStr = "href=\"(https:[\\w\\s./]+?)\"";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(url);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
        }


        // 分组 或  零宽断言
    }

    /**
     * 获取url的 网页内容
     *
     * @param urlStr
     * @return
     */
    public static String getURL(String urlStr, String codingFormat) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(codingFormat)));
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                sb.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 测试 老用户激活接口 的老用户id 格式
     */
    public static void testOldAdids() {
        content = "9861,9720,9720,9405,09281";
        regStr = "^([0-9]\\d{3,4},)*([0-9]\\d{3,4})$";
        pattern(content, regStr);


        regStr = "^([1-9]\\d{3,4},)*([1-9]\\d{3,4})$";
        pattern(content, regStr);

        boolean matches = content.matches(regStr);
        System.out.println("匹配结果" + matches);

    }

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {
        testOldAdids();
    }
}
