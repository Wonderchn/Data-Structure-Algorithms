package com.hongna.demo.array;

/**
 * 一个普通数组的各类操作实现
 */
public class Array {
    //定义整型数组data保存数据
    public int data[];
    //定义数组长度
    public int n;
    //定义数组中实际个数
    public int count;

    //构造方法 定义数组大小
    public Array(int capacity){
        data = new int[capacity];
        n = capacity;
        count = 0;

    }
    //根据索引，找到数组中的元素并返回
    public int find(int index){
        if (index < 0 || index >= count ){
            return -1;
        }
        return data[index];
    }
    //插入元素：头部插入、尾部插入

    public boolean insert(int index, int value){
        //数组越界
        if ( index < 0 || index > count){
            return  false;
        }

        //位置合法
        //数据需要往后移动
        for (int i = index ; i < count ; i++){
            data[i+1] = data[i];
        }
        data[index] = value;
        count += 1;
        return  true;
    }

    //根据索引，删除数组中元素
    public boolean delete(int index){
        if (index < 0 || index >=count){
            return false;
        }

        //从删除位置开始，所有元素往前移动一位。
        //0 1 2 3 4
        //1 2 3 4

      for (int i =index +1;i <count ; i++){
          data[i-1] = data[i];
      }
        count -= 1;
        return  true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.printAll();
        array.delete(0);
        //array.insert(3, 11);
        array.printAll();
    }

}
