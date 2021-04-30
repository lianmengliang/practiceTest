package com.example.test.DataStructureAndAlgorithm.datastructure.linkedlist;

import java.util.LinkedList;

/**
 * @Author ： Leo
 * @Date : 2021/4/29 15:13
 * @Desc:
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        /*singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);*/

        // 按照编号加入
        singleLinkedList.addByOreder(hero1);
        singleLinkedList.addByOreder(hero2);
        singleLinkedList.addByOreder(hero4);
        singleLinkedList.addByOreder(hero3);
        singleLinkedList.list();
        singleLinkedList.update(new HeroNode(4,"花和尚","鲁智深"));

        System.out.println("修改后");
        singleLinkedList.list();

        System.out.println("删除后");
        singleLinkedList.del(2);
        singleLinkedList.list();

    }
}

/**
 * 单链表 类 ：
 * 用于管理我们的英雄
 */
class SingleLinkedList {
    /**
     * 先初始化一个节点，头结点不要动，不存放具体的数据
     */
    private HeroNode head = new HeroNode(0, "", "");


    /**
     * //添加节点到单向链表
     * //思路：当不考虑编号顺序时
     * //1.找到当前链表的最后节点
     * //2.将最后这个节点的next指向 新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向 新的节点
        temp.next = heroNode;
    }


    /**
     * 第二种方式在添加影响时，根据排名名将英雄插入到指定位置
     * <p>
     * 如果有这个排名，则添加失败，并给出提示
     *
     * @param heroNode
     */
    public void addByOreder(HeroNode heroNode) {
        //因为节点不能动，因此我们仍通过一个辅助指针（变量）来帮助好啊到添加的位置
        //因为单链表，我们找的temp是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        // 标志添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                // 说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                // 说明希望添加的heroNode的编号已经存在
                flag = true;
                break;
            }
            // 后移，遍历当前链表
            temp = temp.next;
        }
        // 判断
        if (flag) {
            //不能添加，说明编号已经存在
            System.out.printf("准备插入的英雄编号%d已经存在了，不能加入\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    /**
     * 显示链表【遍历】
     */
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
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
     * 根据no编号 来更新 其中一个节点的信息
     * 注意： no编号不能更改
     *
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号更改
        // 定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                // 已经遍历完链表 ，跳出
                break;
            }
            //判断编号是否存在
            if (temp.no == newHeroNode.no) {
                //存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            // 没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 删除
     * 根据编号来进行删除节点
     *
     * @param no
     */
    public void del(int no) {
        //首先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 定义辅助变量
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //判断是否遍历完链表
                break;
            }
            //判断是否存在
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d,不存在\n", no);
        }
    }

    public int getLength(){
        if (head.next==null){
            return 0;
        }

        int length = 0;
        HeroNode cur = head.next;
        while (true){
            length++;
            cur = cur.next;
        }
    }

}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    /**
     * 指向下一个节点
     */
    public HeroNode next;

    /**
     * 构造器
     *
     * @param no
     * @param name
     * @param nickName
     */
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}