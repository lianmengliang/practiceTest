package com.example.test.DataStructureAndAlgorithm.datastructure.linkedlist;

import com.example.test.designpatterns.status.orderprocessing.PublishState;

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
        HeroNode hero5 = new HeroNode(5, "行者", "武松");

        // 创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        // 按照编号加入
      /*  singleLinkedList.addByOreder(hero1);
        singleLinkedList.addByOreder(hero2);
        singleLinkedList.addByOreder(hero4);
        singleLinkedList.addByOreder(hero3);
        singleLinkedList.addByOreder(hero5);*/
        singleLinkedList.list();
//        singleLinkedList.update(new HeroNode(4, "花和尚", "鲁智深"));

       /* System.out.println("修改后");
        singleLinkedList.list();*/

       /* System.out.println("删除后");
        singleLinkedList.del(2);
        singleLinkedList.list();*/

       /* int length = getLength(singleLinkedList.getHead());
        System.out.println("单链表的有效个数：" + length);

        HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 1);
        System.out.println("倒数第k个节点：" + lastIndexNode);
*/
        System.out.println("反转后");
        reversetList(singleLinkedList.getHead());
        singleLinkedList.list();
    }
    /**
     * 求单链表的有效个数
     * 获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
     *
     * @return
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            // 空链表
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 查找单链表中倒数第k节点
     *
     * @param index
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head,int index) {
        if (head.next == null) {
            // 空链表
            return null;
        }
        // 第一次遍历：获取有效节点的个数
        int size = getLength(head);
        // 第二次遍历 size-index位置就是我们倒数的第K个节点
        // 校验index
        if (index <= 0 || index > size) {
            return null;
        }
        // 定义辅助变量，for循环定位倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        // 第二种方法while循环
       /* int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
            if (length == (size - index)) {
                break;
            }
        }*/
        return cur;
    }

    /**
     * 反转链表
     *
     * @return
     */
    public static void reversetList(HeroNode head) {
        // 如果当前链表为空，或只要一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针（变量），帮助我们遍历原来的链表
        HeroNode cur = head.next;
        // 指向当前节点【cur】的下一个
        HeroNode next = null;

        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放到新的链表中reverseHead
        while (cur != null) {
            // 先保存下一个节点，因为后面需要使用
            next = cur.next;
            // 将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            // 将cur连接到新的链表上
            reverseHead.next = cur;
            System.out.println(reverseHead);
            System.out.println(reverseHead.next);
            System.out.println(reverseHead.next.next);
            System.out.println();
            // cur后移
            cur = next;
        }
        head.next = reverseHead.next;
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
    private static HeroNode head = new HeroNode(0, "", "");

    public  HeroNode getHead() {
        return head;
    }

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