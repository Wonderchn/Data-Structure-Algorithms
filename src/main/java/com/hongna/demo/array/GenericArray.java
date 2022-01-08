package com.hongna.demo.array;



public class GenericArray<T> {
    private T[] data;
    private int size;

    //根据传入容量，构造Array
    public GenericArray(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;


    }
    //无参构造方法，默认数组容量为10
    public GenericArray(){
        data = (T[]) new Object[10];
        size = 0;
    }


    //获取数组容量
    public int getCapacity(){
        return data.length;
    }

    //获取当前元素个数
    public int count() {
        return size;
    }


    //判断数组是否为空


    public boolean isEmpty(){
        return  data.length == 0 ? true :false;
    }

    //修改index位置的元素

    public void set(int index, T e) {
        data[index] = e;

    }
    //获取对应index位置的元素
    public T get(int index) {
        return  data[index];
    }
    //查看数组是否包含元素e
    public boolean contains(T e) {
        for (T i : data){
            if (i == e){
                return true;
            }
        }
        return false;
    }
    //获取对应元素的下标，未找到，返回-1
    public int find(T e) {
        for (int i = 0 ; i <data.length ; i++){
            if (data[i] ==e){
                return   i;
            }
        }
        return  -1;
    }

        //在index位置，插入元素e，时间复杂度O(m+n)
    public void add(int index, T e) {
        //在此位置插入元素，所有元素往后移动一位
        for (int i = size - 1 ; i > index - 1 ; i--){
            data[i+1] = data[i];
        }
        data[index] = e;

    }
    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

//                             向数组尾插入元素
    public void addLast(T e) {
        add(size, e);
    }
    // 删除 index 位置的元素，并返回
    public T remove(int index) {

    }
                                    // 删除第一个元素
//                                    public T removeFirst() {
                                        // 删除末尾元素
//                                        public T removeLast() {

                                        // 从数组中删除指定元素
//                                        public void removeElement(T e) {
                                            // 扩容方法，时间复杂度 O(n)
//                                            private void resize(int capacity) {
//                                        }

}
