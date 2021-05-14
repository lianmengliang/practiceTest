package com.example.test.DataStructureAndAlgorithm.datastructure.linkedlist;


import java.io.Serializable;

/**
 * @Author ： Leo
 * @Date : 2021/5/13 17:19
 * @Desc: 双向链表 -- 增删改  查(遍历)
 */
public class DoublyLinkedListDemo {
    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        // 创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(5, "行者", "武松");

        //添加
        doublyLinkedList.addByOrder(hero2);
        doublyLinkedList.addByOrder(hero3);
        doublyLinkedList.addByOrder(hero5);
        doublyLinkedList.addByOrder(hero4);
        doublyLinkedList.addByOrder(hero1);
        // 遍历
        doublyLinkedList.list();
        System.out.println("-----------------------------------------------------");

        //删除
//        doublyLinkedList.delete(1);
       /* doublyLinkedList.delete(5);

        // 遍历
        doublyLinkedList.list();
        System.out.println("-----------------------------------------------------");

        //修改
        doublyLinkedList.update(new HeroNode2(3, "花和尚", "鲁智深"));
        // 遍历
        doublyLinkedList.list();
        System.out.println("-----------------------------------------------------");*/
    }
}


class DoublyLinkedList {
    /**
     * 先初始化一个节点，头结点不要动，不存放具体的数据
     */
    private HeroNode2 head = new HeroNode2(0, "", "");

    /**
     * 返回头结点
     *
     * @return
     */
    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 修改双向链表
     *
     * @param heroNode
     */
    public void update(HeroNode2 heroNode) {
        HeroNode2 temp = head.next;
        // 判断链表是否为空
        checkLinkedList(temp);
        boolean flag = false;
        while (temp != null) {
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.printf("该链表中不存在编号为%d的节点", heroNode.no);
        }
    }

    /**
     * 删除操作
     *
     * @param index
     */
    public void delete(int index) {
        HeroNode2 temp = head.next;
        // 判断链表是否为空
        checkLinkedList(temp);
        boolean flag = false;

        while (temp != null) {
            if (temp.no == index) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            // 进行删除操作
            temp.pre.next = temp.next;
            //如果是最后一个节点，不需要下面这个操作
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("该链表中不存在编号为%d的节点\n", index);
        }

    }

    /**
     * 添加操作
     *
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // 添加
        temp.next = heroNode;
        heroNode.pre = temp;

    }

    /**
     * 按照顺序 添加操作
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        boolean flag = false;

        while (temp.next != null) {
            if (heroNode.no < temp.next.no) {

                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        // 添加
        if (flag) {
            System.out.printf("该英雄的编号%d已经存在,不能添加\n", heroNode.no);
        } else {
            // 插入到链表中，temp的后面
            // heroNode 指向temp节点的下一个节点
            heroNode.next = temp.next;
            // 判断是否是最后一个节点
            if (temp.next != null){
                temp.next.pre = heroNode;
            }

            // temp 节点指向heroNode节点
            temp.next = heroNode;
            heroNode.pre = temp;
        }


    }

    /**
     * 显示链表【遍历】
     */
    public void list() {

        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        // 判断链表是否为空
        checkLinkedList(temp);
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            //将temp后移，一定小心
            temp = temp.next;
        }
    }


    /**
     * 检查链表是否为空
     *
     * @param temp
     */
    public void checkLinkedList(HeroNode2 temp) {
        if (temp == null) {
            Exception exception = new Exception("链表为空");
            exception.printStackTrace();
        }
    }

}


class HeroNode2 implements Serializable {
    public int no;
    public String name;
    public String nickName;

    /**
     * 指向上一个节点
     */
    public HeroNode2 pre;
    /**
     * 指向下一个节点
     */
    public HeroNode2 next;


    /**
     * 构造器
     *
     * @param no
     * @param name
     * @param nickName
     */
    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';

    }
}