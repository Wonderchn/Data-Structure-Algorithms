package com.hongna.demo.LinkedList;

/**
 * 1) 单链表的插入、删除、查找操作
 * 2) 链表中存储的是int 类型的数据
 */
public class SinglyLinkedList {
    //这里没有哨兵模式，也就是无头结点链表
    private Node head = null;


}



class Node{
    private int data;
    private Node next;

    public Node(int data,Node next){
        this.data = data;
        this.next = next;
    }

    public int getData(){
        return data;
    }
}