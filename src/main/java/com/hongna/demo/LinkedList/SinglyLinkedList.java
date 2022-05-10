package com.hongna.demo.LinkedList;

/**
 * 单链表
 *
 */
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


    //判断true or false
    public boolean TFResult(Node left, Node right){
        Node l = left;
        Node r = right;

        boolean flag=true;
        System.out.println("left_:"+l.data);
        System.out.println("right_:"+r.data);
        while(l != null && r != null){
            if (l.data == r.data){
                l = l.next;
                r = r.next;
                continue;
            }else{
                flag=false;
                break;
            }

        }

        System.out.println("什么结果");
        return flag;
       /* if (l==null && r==null){
           System.out.println("什么结果");
           return true;
        }else{
           return false;
        }*/
    }

    //判断是否为回文
    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            System.out.println("开始找到中间节点");
            Node p = head;
            Node q = head;
            if (p.next == null) {
                System.out.println("只有一个元素");
                return false;
            }
            while( q.next != null && q.next.next != null){
                p = p.next;
                q = q.next.next;

            }

            System.out.println("中间节点" + p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            if(q.next == null){
                //　p 一定为整个链表的中点，且节点数目为奇数
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
                System.out.println("左边第一个节点"+leftLink.data);
                System.out.println("右边第一个节点"+rightLink.data);

            }else{
                //p q　均为中点
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return TFResult(leftLink, rightLink);

        }
    }

    //带结点的链表翻转
    public Node inverseLinkList_head(Node p){
        //Head 为新建的一个头结点
        Node Head = new Node(9999,null);
        // p 为原来链表的头结点，现在Head指向整个链表
        Head.next = p;
        /**
         * 带头结点的链表翻转等价于
         * 从第二个元素开始重新头插法建立链表
         */
        Node cur = p.next;
        p.next = null;
        Node next = null;

        while(cur != null){
            next = cur.next;
            cur.next = head.next;
            Head.next = cur;
            System.out.println("first " + head.data);
            cur = next;
        }
        return Head;
    }


    //无头结点的链表翻转
    public Node inverseLinkList(Node p){
        Node pre = null;
        Node r = head;
        System.out.println("z---" + r.data);
        Node next = null;
        while (r != p){
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }
        r.next = pre;
        return r;
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