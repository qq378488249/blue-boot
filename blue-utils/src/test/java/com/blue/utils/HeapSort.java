package com.blue.utils;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author lblue
 * @date 2018/4/4
 */
public class HeapSort {
    /**
     * 堆排序
     *
     * @param ts
     */
    public static <T extends Comparable<? super T>> void heapSort(T[] ts) {
        // 通过下滤，将数组初始化成一个堆。
        for (int length = ts.length, i = length / 2 - 1; i >= 0; i--) {
            percDown(ts, i, length);
        }

        // 对具有堆性质的数组排序
        for (int len = ts.length - 1; len >= 0; len--) {
            // 将最大元[0]删除，即放到堆尾，堆尾元素放到最大元位置
            swap(ts, len);
            // 对最大元位置元素 下滤
            percDown(ts, 0, len);
        }
    }

    /**
     * 下滤 找出最大元
     *
     * @param ts
     * @param index
     * @param length
     */
    private static <T extends Comparable<? super T>> void percDown(T[] ts, int i, int length) {

        T temp = ts[i];// 待调整最大元位置元素

        for (int child = leftChild(i); child < length; i = child, child = leftChild(i)) {

            // 判断有右儿子&&右儿子>左儿子
            if (child + 1 != length && ts[child + 1].compareTo(ts[child]) > 0) {
                child++;
            }

            // 最大儿子跟父比较
            if (temp.compareTo(ts[child]) < 0) {
                ts[i] = ts[child];
            } else {
                break;
            }
        }

        ts[i] = temp;// 放到正确位置
    }

    /**
     * 堆尾、堆首互换
     *
     * @param ts
     * @param index
     */
    private static <T extends Comparable<? super T>> void swap(T[] ts, int index) {
        T temp = ts[index];
        ts[index] = ts[0];
        ts[0] = temp;
    }

    /**
     * 左儿子位置
     *
     * @param i
     * @return
     */
    private static int leftChild(int i) {
        return i * 2 + 1;
    }

    public static void main(String[] args) {
        Integer a[] = {1, 3, 2, 5};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
