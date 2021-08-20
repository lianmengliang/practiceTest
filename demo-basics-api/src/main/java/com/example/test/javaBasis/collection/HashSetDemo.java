package com.example.test.javaBasis.collection;

import java.util.*;

/**
 * @Author ： Leo
 * @Date : 2021/8/10 18:01
 * @Desc: Set接口对象 HashSet的练习及说明
 */
@SuppressWarnings("all")
public class HashSetDemo {
    public static void main(String[] args) {


        debugHashsetCode001();
    }


    /**
     * 源码解读
     */
    private static void debugHashsetCode001() {
        Set set = new HashSet();

        /*for (int i = 1; i <= 100; i++) {
            set.add(i);
        }
        */
        LinkedHashSet<Object> objects = new LinkedHashSet<>();


        /**
         * 同一hash值下 向HashSet中 添加元素
         */
        for (int i = 1; i <= 63; i++) {
            set.add(new A(i));
        }


        for (int i = 0; i < 5; i++) {
            set.add(new A(i));
        }

        System.out.println(set);
    }

    /**
     * 源码解读
     */
    private static void debugHashsetCode() {

        Set set = new HashSet();
        // 添加
        set.add("leo");
        set.add("kevin");
        set.add(123);

        /*for (Object o : set) {
            System.out.println(o);
        }
*/
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /**
         * 1.
         * public HashSet() {
         *         map = new HashMap<>();
         *}
         * 2.
         * public boolean add(E e) {
         *    return map.put(e, PRESENT)==null;
         *}
         * 3.
         * public V put(K key, V value) {
         *    return putVal(hash(key), key, value, false, true);
         * }
         * 4.
         * final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
         *                    boolean evict) {
         *
         * }
         */
        System.out.println("set：" + set);


    }


    /**
     * final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
     boolean evict) {
     HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
     if ((tab = table) == null || (n = tab.length) == 0)
     n = (tab = resize()).length;
     if ((p = tab[i = (n - 1) & hash]) == null)
     tab[i] = newNode(hash, key, value, null);
     else {
     HashMap.Node<K,V> e; K k;
     if (p.hash == hash &&
     ((k = p.key) == key || (key != null && key.equals(k))))
     e = p;
     else if (p instanceof HashMap.TreeNode)
     e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
     else {
     for (int binCount = 0; ; ++binCount) {
     if ((e = p.next) == null) {
     p.next = newNode(hash, key, value, null);
     if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
     treeifyBin(tab, hash);
     break;
     }
     if (e.hash == hash &&
     ((k = e.key) == key || (key != null && key.equals(k))))
     break;
     p = e;
     }
     }
     if (e != null) { // existing mapping for key
     V oldValue = e.value;
     if (!onlyIfAbsent || oldValue == null)
     e.value = value;
     afterNodeAccess(e);
     return oldValue;
     }
     }
     ++modCount;
     if (++size > threshold)
     resize();
     afterNodeInsertion(evict);
     return null;
     }
     */
    /**
     * 基础练习
     */
    private static void basicPratices() {

        HashSet set = new HashSet();
        HashMap<String, Object> map = new HashMap<>();
        // 添加
        set.add(null);
        set.add("leo");
        set.add("kevin");
        set.add(123);
        System.out.println(set.add(888));
        set.add(666);
        System.out.println(set.add(888));

        System.out.println("set：" + set);

        set.add(new Dog("tom"));
        set.add(new Dog("tom"));


        // 删除
//        set.remove(123);

        System.out.println("set：" + set);

       /* ArrayList<String> list = new ArrayList<String>();
        Optional<String> first = list.stream().findFirst();
        first.isPresent();

        String s = first.get();

        list.isEmpty();
*/
        //  LinkedHashSet的练习
        LinkedHashSet<Integer> integers = new LinkedHashSet<>();

        integers.add(1);
        integers.remove(2);


        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * HashMap 设置初始 容量，如果不知道是多少就设置为默认容量 16
     *
     * @param expeectCapacity
     * @return
     */
    public static int getInitialCapacity(Integer expeectCapacity) {
        Double result = expeectCapacity / 0.75 + 1;
        return result.intValue();
    }


    public static void testHashMapInitialCapacity() {
        int aHundredMillion = 1000000;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map.put(i, i);
        }
        long s2 = System.currentTimeMillis();
        System.out.println("未初始化容量，耗时：" + (s2 - s1));

        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>(aHundredMillion / 2);
        long s3 = System.currentTimeMillis();
        for (int i = 0; i <aHundredMillion; i++) {
            map1.put(i, i);
        }
        long s4 = System.currentTimeMillis();
        System.out.println("初始化容量500000，耗时：" + (s4 - s3));

        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(aHundredMillion);
        long s5 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map2.put(i, i);
        }
        long s6 = System.currentTimeMillis();
        System.out.println("初始化容量1000000，耗时：" + (s6 - s5));

        int initialCapacity = getInitialCapacity(aHundredMillion);
        System.out.println(initialCapacity);
        Map<Integer, Integer> map3 = new HashMap<Integer, Integer>(initialCapacity);
        long s7 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map2.put(i, i);
        }
        long s8 = System.currentTimeMillis();
        System.out.println("初始化容量1000000，耗时：" + (s8 - s7));
    }

}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    /* 重写hashCode和equals方法 可以进行Dog对象去重

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        return name != null ? name.equals(dog.name) : dog.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }*/


    /*@Override
    public int hashCode() {
        return 0;
    }*/
}

class A {
    private int num;


    public A(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}