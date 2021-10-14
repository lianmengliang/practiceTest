package com.example.test.java_basis.collection;

import java.util.*;

/**
 * @Author ： Leo
 * @Date : 2021/8/20 16:51
 * @Desc: Collections  集合工具类的使用
 *
 * 集合使用一般规则：
 * "在开发中，选择什么集合实现类。主要取决于业务操作特点，然后根据集合实现类特性进行选择,分析如下:
 * 1) 先判断存储的类型(一组对象[单或一组键值对[双列)
 * 2) 一组对象[单列:Collection接口
 *   允许重复:List                                  --------------->{重复效率高}
 *    增删多:LinkedList[底层维护了一个双向链表]         --------------->{重复增删效率高}
 *    改查多:ArrayList [底层维护Object类型的可变数组   --------------->{重复改查效率高}
 *   不允许重复:Set
 *    无序: HashSet[底层是HashMap，维护了一个哈希表即(数组+链表+红黑树)  ------->{无序且唯一}
 *    排序: TreeSet[底层是：TreeMap]                                ------->{有序且唯一： 默认按hash值进行排序，升序排列}
 *    插入和取出顺序一致:LinkedHashSet,维护数组+双向链表             -----{有序且唯一： 按插入顺序进行排序}
 * 3) 一组键值对[双列]:Map接口
 *   键无序:HashMap [底层是:哈希表 jdk7:数组+链表，jdk8:数组+链表+红黑树]  ------->{无序且唯一}
 *   键排序: TreeMap                                                    ------->{有序且唯一：默认按键的hash值进行排序，升序排列}
 *   键插入和取出顺序一致: LinkedHashMap读取文件Properties"           -----{LinkedHashMap有序且唯一： 按插入顺序进行排序}
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

        //打乱顺序: 可用于无序操作
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

        // iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
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

        // 计算某一元素出现的次数：
        int leoNum = Collections.frequency(list, "Leo");
        System.out.println("Leo出现的次数：" + leoNum);

        //
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(221);
        integers.add(21);
        integers.add(22);
        integers.add(23);
        integers.add(23);
        integers.add(231);

        System.out.println("测试int类型集合出现某一元素的次数："+Collections.frequency(integers,23));



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
