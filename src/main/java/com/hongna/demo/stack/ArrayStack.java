package com.hongna.demo.stack;

public class ArrayStack {
    //数组
    private String[] items;
    //数组元素个数
    private int count;
    //栈的大小
    private int n;

    // 初始化数组，申请一个大小为 n 的数组空间
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    //入栈操作
    public boolean push(String item){
        if (count == n ){
            return false;
        }
        items[count] = item;
        ++count;
        return false;
    }

    public String pop(){
        if (count == 0){
            return null;
        }
        String tmp =items[count - 1];
        --count;
        return tmp;
    }
}
