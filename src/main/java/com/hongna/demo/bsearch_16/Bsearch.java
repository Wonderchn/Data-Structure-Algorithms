package com.hongna.demo.bsearch_16;

public class Bsearch {


    /**
     * 最初始版本，假设数组中元素唯一
     *
     * @param a     传入数组
     * @param n     数组长度
     * @param value 需要查找元素
     * @return
     */
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high + low << 2);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 变体一：查找第一个值等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch_1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high + low << 2);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] == value) {
                if ((mid == 0) || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
