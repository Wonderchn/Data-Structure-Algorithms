package com.hongna.demo.LinkedList;

public class SinglyLinkedList {
    private Node head = null;

    public Node findByValue(int value){
        Node p = head;
        while(p != null && p.data != value){
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while( p!=null && pos!=index){
            p = p.next;
            ++pos;
        }
        return p;
    }

    //无头结点
    //表头部插入
    public void insertToHead(int value){
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }


    public void insertToHead(Node node){
        if (head == null){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
    }

    //顺序插入
    //链表尾部插入
    public void insertTail(int value){
        Node newNode = new Node(value,null);
        // 空链表，可以插入新节点作为head，也可以不操作
        if (head == null){
            head = newNode;
        }else {
            Node q = head;
            while (q.next != null){
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public void insertAfter(Node p, int value){
        Node node = new Node(value ,null);
        insertAfter(p,node);
    }


    public void insertAfter(Node p, Node newNode){
        if (p == null){
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p ,int value){
        Node newNode = new Node(value ,null);
        insertBefore(p,newNode);
    }

    public void insertBefore(Node p , Node newNode){
        if (p == null)return;
        if (head == p){
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while(q!=null && q.next != p){
            q = q.next;
        }

        if (q == null){
            return;
        }

        newNode.next = q;
        q.next = newNode;
    }


    public void deleteByNode(Node p){
        if (p == null || head == null)return;
        if (p == head){
            head = head.next;
            return;
        }
        Node q = head;
        while(q != null && q.next !=p){
            q = q.next;
        }
        if ( q == null){
            return;
        }
        q.next = q.next.next;
    }

    public void deleteByValue(int value){
        if (head == null) return;
        Node p = head;
        Node q = null;
        while(q != null && q.data != value){
            q = p;
            p = p.next;
        }
        if (p == null)return;
        if (q == null){
            head = head.next;
        }else {
            q.next = q.next.next;
        }
    }

    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.println(p.data + "");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node {
        private int data ;
        private Node next;

        public Node(int data , Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }
}