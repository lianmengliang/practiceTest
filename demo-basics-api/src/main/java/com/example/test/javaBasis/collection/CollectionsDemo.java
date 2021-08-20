package com.example.test.javaBasis.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/8/20 16:51
 * @Desc: Collections  集合工具类的使用
 */
@SuppressWarnings("all")
public class CollectionsDemo {
    public static void main(String[] args) {
        test002();
    }


    /**
     * 第一组 ： 排序
     */
    public static void test001() {

        List<String> list = new ArrayList<>();

        //打乱顺序
        Collections.shuffle(list);
        //反转顺序
        Collections.reverse(list);
        // 指定两个索引交换
        Collections.swap(list, 0, 1);

        //自然排序
        Collections.sort(list);

        // 自定义 比较器 排序 (比如按照字符串的长度大小进行排序)
        // 普通格式
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        // lambda格式
        Collections.sort(list, (o1, o2) -> o1.length() - o2.length());
        // 升级后lambda格式
        Collections.sort(list, Comparator.comparingInt(String::length));
    }

    /**
     * 第二组： 查询，操作
     */
    private static void test002() {

        // 自然顺序最大元素
        List<String> list = new ArrayList<>();
        list.add("Kevin");
        list.add("Jane");
        list.add("Leo");
        list.add("Alice");
        list.add("Jelena");
        list.add("Leo");
        list.add("JelenaPlus");
        list.add("Plus");

        System.out.println("list:" + list);
        // 自然排序后
        list.sort(Comparator.naturalOrder());
        System.out.println("自然排序后的list:" + list);
        // 按条件筛选出（比如字符串长度）最大的一个元素，
        String max = Collections.max(list, String::compareTo);  // 字符串按自然排序，求最大的一个
//        String max = Collections.max(list, Comparator.naturalOrder());    // 自然排序，升序
//        String max = Collections.max(list, Comparator.reverseOrder());    // 自然排序的反过来，降序
//        String max = Collections.max(list, Comparator.comparingInt(String::length));          //按字符串长度进行排序，升序
        System.out.println(max);
        String max1 = Collections.max(list);
        // 不添加比较器时，按默认的排序格式排序
//        System.out.println(max1);


        //求最小值
        String min = Collections.min(list);
        System.out.println("min：" + min);

        // 计算某一元素出现的次数
        int leoNum = Collections.frequency(list, "Leo");
        System.out.println("Leo出现的次数：" + leoNum);

        //复制集合
        List<String> newList = new ArrayList<>();
        //为了避免异常IndexOutOfBoundsException: Source does not fit in dest
        //需要先给新的集合随便赋值，赋值的数量与旧集合的长度相同
        for (int i = 0; i < list.size(); i++) {
            newList.add(i+"");
        }
        Collections.copy(newList, list);
        System.out.println("newList：" + newList);

        List<String> newList1 = new ArrayList<>();

//        list.forEach(item -> newList1.add(item));

        for (String s : list) {
            newList1.add(s);
        }
        System.out.println("newList1：" + newList1);

        // 替换,
        Collections.replaceAll(list, "Plus", "Tom");
    }
}
