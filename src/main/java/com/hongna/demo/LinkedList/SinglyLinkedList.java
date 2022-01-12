package com.hongna.demo.LinkedList;

/**
 * 1) 单链表的插入、删除、查找操作
 * 2) 链表中存储的是int 类型的数据
 */
public class SinglyLinkedList {
    //这里没有哨兵模式，也就是无头结点链表
    private Node head = null;

    //根据VALUE值进链表节点进行查找
    public Node findByValue(int value) {
       //这里需要使用指针来进行链表的操作
        Node p = head;
        //此处比较巧妙，如果遍历到最后一个那个这时我们的p点就是Null，会不进入这个点，所以最后返回null
        while(p != null && p.getData() !=value){
            p = p.getNext();
        }
        return  p;
    }

    //根据索引对链表节点进行查找
    //根据index来进行查找、
    public Node findByIndex(int index) {
        Node p = head ;
        int pos = 0;
        while ( p != null && pos != index){
            p = p.getNext();
            pos ++;
        }
        return p;
    }

    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value) {
        Node newNode = createNode(value);
        insertToHead(newNode);
    }

    //插入头结点
    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }



    //顺序插入
    //链表尾部插入
    public void insertTail(int value){
        Node node = createNode(value);
        Node p = head;
        if (p == null){
            head = p ;
        }else {
            while (p.getNext()!=null){
                p = p.getNext();
            }
            p.setNext(node);
        }
    }

    //在某个值节点之后插入
    public void insertAfter(Node node,int value){
        //充当指针
        Node p = head;
        while (p!=null || p.getData()!=value){
            p = p.getNext();
        }
        if (p == null){
           return;
        }else{
            node.setNext(p.getNext());
            p.setNext(node);
        }
    }

    //在某个值的节点之前插入
    public void insertBefore(Node node ,int value){
        //在某个节点之前截取
        Node p = head;
        if (p == null){
            return;
        }
        //在某个节点前面
        while ( p.getNext() != null || p.getData() != value){
            if (p.getNext().getData() == value){
                node.setNext(p.getNext());
                p.setNext(node);
            }
        }
    }

    //在某个节点之前插入
    public void insertBefore(Node node ,Node newNode){


    }


    //删除某个节点
    public void  deleteByNode(Node p){

    }


    //删除某个值的节点
    public void deleteByValue(int value){

    }

    //展示链表全部结点
    public void printAll() {
        //指针
        Node p = head;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.getNext();
        }
        System.out.println();
    }

    public static  Node createNode(int value){
        return new Node(value,null);
    }
}



