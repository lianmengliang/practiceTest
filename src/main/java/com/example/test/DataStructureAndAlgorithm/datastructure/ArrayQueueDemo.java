package com.example.test.DataStructureAndAlgorithm.datastructure;

/**
 * @Author ： Leo
 * @Date : 2021/4/25 18:44
 * @Desc:
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

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

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
}