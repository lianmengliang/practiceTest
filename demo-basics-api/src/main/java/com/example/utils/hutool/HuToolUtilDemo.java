package com.example.utils.hutool;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

import java.util.UUID;

/**
 * @Author ： Leo
 * @Date : 2021/9/16 15:17
 * @Desc: HuTool  工具依赖的Demo练习
 */

@SuppressWarnings("all")
public class HuToolUtilDemo {


    /**
     * 唯一id
     */
    public static void IdUtilDemo(){

        /**
         * UUID全称通用唯一识别码（universally unique identifier），
         * JDK通过java.util.UUID提供了 Leach-Salz 变体的封装
         */
        //生成的UUID是带-的字符串，如：a5c8a5e8-df2b-4706-bea4-08d0939410e3
        String randomUUID = IdUtil.randomUUID();
        System.out.println(randomUUID);

        //生成的是不带-的字符串，如：b17f24ff026d40949c85a24f4f375d42
        String simpleUUID  = IdUtil.simpleUUID();
        System.out.println(simpleUUID);

        // jdk自帶的生成的UUID： e4f6ac24-6f35-43fe-9707-2d7d9c2768ce
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid.toString());




        /**
         * ObjectId是MongoDB数据库的一种唯一ID生成策略，是UUID version1的变种
         */

        // 6142f1a2d058c623d9268a5d
        String id = ObjectId.next();
        System.out.println(id);

        // 6142f1a2d058c623d9268a5e
        String id1 = IdUtil.objectId();
        System.out.println(id1);


        /**
         * Sonwflake
         *
         * 分布式系统中，有一些需要使用全局唯一ID的场景，有些时候我们希望能使用一种简单一些的ID，并且希望ID能够按照时间有序生成。Twitter的Snowflake 算法就是这种生成器。
         */
        //参数1为终端ID
//参数2为数据中心ID
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        long id2 = snowflake.nextId();
        long id3 = snowflake.nextId();

        System.out.println(snowflake
                    + "\n" + "id2:" + id2
                    + "\n" + "id3:" + id3 );


    }


    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        IdUtilDemo();
    }
}
