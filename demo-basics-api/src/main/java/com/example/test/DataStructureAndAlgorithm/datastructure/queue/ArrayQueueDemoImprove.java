package com.example.test.DataStructureAndAlgorithm.datastructure.queue;


import java.util.Scanner;

/**
 * @Author ： Leo
 * @Date : 2021/4/25 18:44
 * @Desc:  环形队列
 */
public class ArrayQueueDemoImprove {
    public static void main(String[] args) {


        // 创建一个队列
        ArrayQueue queue = new ArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        char key = ' '; //接收用户输入
        boolean loop = true;
        //输入一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符

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


class ArrayQueue {
    /**
     * 数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        // 指向队列头部，分析出 front 是指向队列头的前一个位置
        front = 0;
        // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        rear = 0;
    }

    /**
     * 判断是否满了
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        //直接将数据加入
        arr[rear] = n;
        // 将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;

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
//    这里需要分析出 front 是指向队列的第一个元素
//      1. 先把 front 对应的值保留到一个临时变量
//      2. 将 front 后移, 考虑取模
//      3. 将临时保存的变量返回
        int value = arr[front];
        // front后移
        front = (front + 1) % maxSize;
        return value;
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
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 求出当前队列有效数据的个数
     *
     * @return
     */
    private int size() {
        return (rear + maxSize - front) % maxSize;
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
        return arr[front];
    }
}