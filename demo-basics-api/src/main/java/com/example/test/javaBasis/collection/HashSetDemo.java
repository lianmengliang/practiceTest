package com.example.test.javaBasis.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @Author ： Leo
 * @Date : 2021/8/10 18:01
 * @Desc: Set接口对象 HashSet的练习及说明
 */
@SuppressWarnings("all")
public class HashSetDemo {
    public static void main(String[] args) {


        basicPratices();
    }

    /**
     *
     * 源码解读
     */
    private static void debugHashsetCode() {

        Set set = new HashSet();
        // 添加
        set.add("leo");
        set.add("kevin");
        set.add(123);

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
        set.remove(123);


        System.out.println("set：" + set);

        ArrayList<String> list = new ArrayList<String>();
        Optional<String> first = list.stream().findFirst();
        first.isPresent();

        String s = first.get();

        list.isEmpty();

    }


}

class Dog{
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
}