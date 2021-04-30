package com.example.test.DataStructureAndAlgorithm.datastructure.queue;



import java.util.Scanner;

/**
 * @Author ： Leo
 * @Date : 2021/4/25 18:44
 * @Desc:
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {



        // 创建一个队列
        ArrayQueue1 queue = new ArrayQueue1(3);
        Scanner scanner = new Scanner(System.in);
        //接收用户输入
        char key = ' ';
        boolean loop = true;
        //输入一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int data = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int data = queue.headQueue();
                        System.out.printf("获取的头部数据是%d\n", data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~");

    }
}


class ArrayQueue1 {
    /**
     * 数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     * /front 变量的含义做一个调整：
     * front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
     * /front 的初始值 = 0
     */
    private int front;
    /**
     * 队列尾
     * /rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
     * /rear 的初始值 = 0
     */
    private int rear;
    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;



    public ArrayQueue1(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;  // 指向队列头部，分析出 front 是指向队列头的前一个位置
        rear = -1;  // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    }

    /**
     * 判断是否满了
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列中
     *
     * @param n
     */
    public void addQueue(int n) {
        //判断是否满了
        if (isFull()) {
            System.out.println("队列已满...");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    /**
     * 获取队列数据
     *
     * @return
     */
    public int getQueue() {
        //判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        front++; // front后移
        return arr[front];
    }

    /**
     * 显示队列的所有数据
     *
     * @return
     */
    public void showQueue() {
        //判断是否为空
        if (isEmpty()) {
            System.out.println("队列为空,不能取数据");
        }
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 显示队列的头数据，注意不是取数据
     *
     * @return
     */
    public int headQueue() {
        //判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        return arr[front + 1];
    }

}