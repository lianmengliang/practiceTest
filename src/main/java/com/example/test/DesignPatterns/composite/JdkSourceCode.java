package com.example.test.DesignPatterns.composite;

import java.util.HashMap;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 14:28
 * @Desc:
 */
public class JdkSourceCode {
    public static void main(String[] args) {

        /**
         * 说明：
         * 1.Map 就是一个抽象的构建（类似我们的Component）、
         * 2.HashMap是一个中间的构建（Composite），实现/继承了相关方法
         *      方法： put ，putAll
         * 3.Node是HashMap的静态内部类，类似Leaf叶子节点，这里就没有put，putAll方法
         *  static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V>
         */
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0,"西游记");
        System.out.println(map);

        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1,"红楼梦");
        map1.put(2,"水浒传");
        System.out.println(map1);

        map.putAll(map1);
        System.out.println(map);


    }
}
