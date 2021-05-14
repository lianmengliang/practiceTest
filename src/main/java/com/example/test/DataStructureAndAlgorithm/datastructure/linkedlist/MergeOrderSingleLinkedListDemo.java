package com.example.test.DataStructureAndAlgorithm.datastructure.linkedlist;

/**
 * @Author ： Leo
 * @Date : 2021/5/13 14:18
 * @Desc:
 */
public class MergeOrderSingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList1 list1 = new SingleLinkedList1();
        list1.add(new Node(1));
        list1.add(new Node(3));
        list1.add(new Node(5));
        list1.add(new Node(7));
        list1.add(new Node(9));
        list1.show();
        System.out.println("-----------------------");

        SingleLinkedList1 list2 = new SingleLinkedList1();
        list2.add(new Node(2));
       /* list2.add(new Node(4));
        list2.add(new Node(6));
        list2.add(new Node(6));
        list2.add(new Node(8));
        list2.add(new Node(10));
        list2.add(new Node(11));
        list2.add(new Node(12));*/
        list2.show();
        System.out.println("-----------------------");

        // 合并链表
        SingleLinkedList1 mergeList = merge(list1, list2);
        System.out.println("合并后的链表如下~~~");
        mergeList.show();
    }

    /**
     * 链表合并
     *
     * @param linkedList1
     * @param linkedList2
     * @return
     */
    public static SingleLinkedList1 merge(SingleLinkedList1 linkedList1, SingleLinkedList1 linkedList2) {
        // 新链表的头节点
        Node head = new Node(0);
        // preNode 指向当前待排序节点的前一个节点
        Node preNode = head;

        // 设置新链表的头结点
        SingleLinkedList1 mergeLinkedList = new SingleLinkedList1();
        mergeLinkedList.head = head;

        // node1初始值默认指向 likedlist1的首节点
        Node node1 = linkedList1.head.next;
        // node2初始值默认指向 likedlist2的首节点
        Node node2 = linkedList2.head.next;

        while (node1 != null && node2 != null) {
            //将值小的节点排在前面（升序排列），并且后移node1 或 node2指针
            if (node1.num < node2.num) {
                preNode.next = node1;
                node1 = node1.next;
            } else {
                preNode.next = node2;
                node2 = node2.next;
            }
            // proNode后移，为下一次排序做准备
            preNode = preNode.next;
        }

        //最后连上还有的剩余节点的链表
        preNode.next = (node1 == null) ? node2 : node1;

        return mergeLinkedList;
    }


}


class SingleLinkedList1 {
    public Node head = new Node(0);
    /**
     * 添加元素
     *
     * @param newNode
     */
    public void add(Node newNode) {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }

    /**
     * 链表遍历展示
     *
     */
    public void show() {
        Node cur = head.next;
        if (cur == null) {
            System.out.println("链表为空~");
        }
        while (cur != null) {
            System.out.print(cur.num + "--->");
            cur = cur.next;
        }
        System.out.println();
    }


}

class Node {

    public int num;

    public Node next;

    public Node(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", next=" + next +
                '}';
    }

}