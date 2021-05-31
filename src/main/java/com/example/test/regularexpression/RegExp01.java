package com.example.test.regularexpression;

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
 * 符号：\\w -->匹配单个数字，大小写字母字符，相当于[0-9a-zA-Z]
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
    public static void main(String[] args) {

        test001();

    }

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
        patternGroup(content, regStr);

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
        regStr = "^((http|https)://)([\\w_]+\\.)+[\\w_]+(\\/[\\w-?=&/%.#]*)?$";
        patternBoolean(content, regStr);

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
            System.out.println("第一个分组：" + matcher.group("g1"));
            System.out.println("找到：" + matcher.group(2));
            System.out.println("第二个分组：" + matcher.group("g2"));
            System.out.println("找到：" + matcher.group(3));
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

}
