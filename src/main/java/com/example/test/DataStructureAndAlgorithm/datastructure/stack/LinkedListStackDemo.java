package com.example.test.DataStructureAndAlgorithm.datastructure.stack;

/**
 * @Author ： Leo
 * @Date : 2021/5/17 10:49
 * @Desc: 用单链表（头插法-先进后出） 模拟栈
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        // 测试
        LinkedListStack listStack = new LinkedListStack();

        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        listStack.push(person2);
        listStack.push(person1);
        listStack.push(person4);
        listStack.push(person3);

        listStack.pop();

        listStack.show();

    }
}


class LinkedListStack {

    private Person head = new Person(-1);

    public LinkedListStack() {
        this.head = head;
    }

    /**
     * 判断是都栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return head.getNext().getNo() == -1;
    }

    /**
     * 进栈  （新增）
     * 采用 单链表的 头插法，新增
     * @param person
     */
    public void push(Person person) {

        if (head.getNext() == null) {
            head.setNext(person);
            return;
        }
        // 头插法
        Person cur = head.getNext();
        head.setNext(person);
        person.setNext(cur);
    }

    /**
     * 出栈   （删除）
     * @return
     */
    public Person pop(){
        Person person = head.getNext();
        System.out.printf("节点%d出栈\n",person.getNo());
        head = head.getNext();
        return person;
    }

    /**
     * 遍历
     */
    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }

        while (head.getNext() != null){
            System.out.printf("出栈的节点为%d\n",head.getNext().getNo());
            head = head.getNext();
        }

    }

}


class Person {

    private int no;

    private Person next;

    public Person(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Person{" +
                "no=" + no +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }
}