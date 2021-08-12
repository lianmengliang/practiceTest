package com.example.utils;

/**
 * @Author ： Leo
 * @Date : 2021/8/11 10:34
 * @Desc: 字符串IP 和Long数据类型的转换工具
 * <p>
 * 使用场景：
 * 可以把IP地址转换为整数类型long，然后存放到数据库中，节省数据库空间大小
 * ===>建议当存储IPv4地址时，应该使用32位的无符号整数（UNSIGNED INT）来存储IP地址，而不是使用字符串
 * 优点：
 * 相对字符串存储，使用无符号整数来存储有如下的好处：
 * 1.节省空间，不管是数据存储空间，还是索引存储空间
 * 2.便于使用范围查询（BETWEEN...AND），且效率更高
 * <p>
 * 比如Mysql 提供了
 * MySQL提供了相应的函数来把字符串格式的IP转换成整数INET_ATON，以及把整数格式的IP转换成字符串的 INET_NTOA
 * 对于IPv6来说，使用VARBINARY同样可获得相同的好处，同时MySQL也提供了相应的转换函数，即INET6_ATON和INET6_NTOA。
 * <p>
 * -- IPv4 转换为整数
 * select INET_ATON('192.168.0.1')      ===> 3232235521
 * <p>
 * -- 整数转 IPv4
 * select INET_NTOA(3232235521)         ===> 192.168.0.1
 * <p>
 * -- IPv6转换为整数
 * select INET6_ATON('fe80::f183:a50:ff8b:dcff%5')
 * <p>
 * -- 整数转 IPv6
 * select INET6_NTOA('整数类型')
 */
public class IpAndLongExchangeUtil {


    /**
     * 字符串IP转换为long类型
     *
     * @param ipStr
     * @return
     */
    public static long ipStrConvertToLong(String ipStr) {

        String[] ipArray = ipStr.split("\\.");

        long ipInteger = (Long.valueOf(ipArray[0]) << 24)
                + (Long.valueOf(ipArray[1]) << 16)
                + (Long.valueOf(ipArray[2]) << 8)
                + Long.valueOf(ipArray[3]);

        return ipInteger;
    }

    /**
     * 整数类型的IP地址 转换为字符串类型IP
     *
     * @param ipLong
     * @return
     */
    public static String ipLongConvertToStr(long ipLong) {

        StringBuilder ipBuilder = new StringBuilder();
        ipBuilder.append(ipLong >>> 24).append(".")
                .append((ipLong >>> 16) & 0xFF).append(".")
                .append((ipLong >>> 8) & 0xFF).append(".")
                .append(ipLong & 0xFF);
        return ipBuilder.toString();

    }


    /**
     * 主方法 用于测试
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(ipStrConvertToLong("192.168.0.1"));
        System.out.println(ipLongConvertToStr(3232235521L));
        System.out.println(ipStrConvertToLong("192.168.175.1"));

    }
}

