package com.example.test.iostream.properties;

import java.io.*;
import java.util.Properties;

/**
 * @Author ： Leo
 * <p>顺序：14
 * @Date : 2021/6/10 17:10
 * @Desc: properties文件的读取 的 写入
 * <p>
 *
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
//        traditionalRead();

        propertiesRead1();
    }

    /**
     * 传统方法读取文件
     *
     * 需求：
     *  * 一个配置文件：mysql.properties
     *  * ip=192.168.10.13
     *  * user=leo
     *  * pwd=12345
     *  * <p>
     *  * 请问读取ip,user,pwd的值是多少？
     */
    private static void traditionalRead() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/mysql.properties"));

        String readLine = null;
        while ((readLine = reader.readLine()) != null) {
            System.out.println(readLine);

            String[] split = readLine.split("=");
            System.out.println(split[0] + "的值是：" + split[1]);
        }
        reader.close();
    }

    /**
     * 使用Properties类 获取文件信息
     */
    private static void propertiesRead() throws IOException {
        // 使用Properties类Laura读取mysql。properties文件
        //1.创建Properties对象
        Properties properties = new Properties();
        //2.加载配置文件
        properties.load(new FileReader("src/mysql.properties"));
        //3.把k-v显示在控制台上
        properties.list(System.out);

        // 4.根据key获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名:"+user);
        System.out.println("密码:"+pwd);


    }

    /**
     * 使用Properties类 创建 配置文件，修改文件内容
     * @throws {}IOException
     */
    private static void propertiesRead1() throws IOException {
        Properties properties = new Properties();

        //创建
        //1.如果改文件没有key，就是新建
        //2.如果该文件有key，就是修改
        properties.setProperty("charset","utf8");
        properties.setProperty("user","Leo");
        properties.setProperty("pwd","123456888");

        //public void store(OutputStream out, String comments)方法
        // comments是指 properties文件注释
        // 将k-v 存储文件中即可
        /*properties.store(new FileOutputStream("src\\mysql2.properties"),"userAndpwd");*/

        // 將文件保存成 XML格式
        properties.storeToXML(new FileOutputStream("src\\mysql3.xml"),"userAndpwd");





        System.out.println("保存成功");
    }
}
