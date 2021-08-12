package com.example.test.DataStructureAndAlgorithm.datastructure.linkedlist;


import java.util.Stack;

/**
 * @Author ： Leo
 * @Date : 2021/5/14 14:47
 * @Desc: 约瑟夫问题 分析 ：代码实现
 * Josephu 问题为： 设编号为 1， 2， … n 的 n 个人围坐一圈， 约定编号为 k（1<=k<=n） 的人从 1 *开始报数， 数到 m 的那个人出列， 它的下一位又从 1 开始报数， 数到 m 的那个人又出列， 依次类推， *直到所有人出列为止， 由此产生一个出队编号的序列。
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {

        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.addBoy(5);
        linkedList.showBoys();
        System.out.println("-------------------------------------------------");
        linkedList.countBoy(1,2,3);


    }
}

/**
 * 环形的单向链表
 */
class CircleSingleLinkedList {
    /*** 创建一个首节点，当前没有编号*/
    private Boy first = new Boy(-1);

    /**
     * 添加 boy方法
     *
     * @param nums
     */
    public void addBoy(int nums) {
        // nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                // 构成环状
                first.setNext(first);
                curBoy = first;  // 指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历展示 boy
     */
    public void showBoys() {
        //判断链表是都为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号为" + curBoy.getNo());
            //判断什么时候 跳出循环
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 根据要求：计算出小孩出圈的顺序
     *
     * @param startNo  ： 标识第几个小孩开始数数
     * @param countNum ： 表示数几下
     * @param nums     ： 表示最初有多少个小孩在 圈内
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 校验参数
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误,请重新输入！");
            return;
        }
        // 创建要给辅助指针，帮助完成小孩出圈
        Boy helper = first;
        // 辅助指针（变量），事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        // 小孩报数前，先让first和helper 移动 k-1 次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        // 当小孩报数，让first和helper指针同时移动 m-1次，然后出圈
        // 这里是一个循环操作，知道圈中只有一个节点
        while (true) {
            if (helper == first){
                // 说明只有一个节点 （一个小孩）
                break;
            }
            //让first和helper指针同时移动 countNum-1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            // 这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号为%d\n",first.getNo());
    }

}

class Boy {

    private int no;

    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
