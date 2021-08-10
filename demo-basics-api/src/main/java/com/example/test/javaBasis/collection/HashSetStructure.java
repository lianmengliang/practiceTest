package com.example.test.javaBasis.collection;


import java.util.Arrays;

/**
 * @Author ： Leo
 * @Date : 2021/8/10 18:34
 * @Desc:
 */
public class HashSetStructure {
    public static void main(String[] args) {

        //有人把Node[]数组 称为表,每个索引 都可以存一条链表数据
        Node[] table = new Node[16];

        Node john = new Node("john", null);
        table[2] = john;

        Node tom = new Node("tom", null);
        john.next = tom;

        Node kevin = new Node("kevin", null);
        tom.next = kevin;


        Node leo = new Node("Leo", null);
        table[3] = leo;

        Node node = table[2];
        System.out.println(node);
        System.out.println(Arrays.toString(table));


    }
}


class Node {

    Object item;

    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}