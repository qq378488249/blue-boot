package com.blue.utils;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author lblue
 * @date 2018/4/8
 */
public class QuickSort {
    public static void main(String[] args) {
        int size = 5;
//        int[] b = {2, 3, 5, 6, 7, 213, 4567, 32, 645, 7, 45, 74, 36, 12, 4, 2, 35, 367, 4, 63, 15, 3, 647, 213};
//        int[] b = {45,42,7,35,14};
        int[] b = {3,5,7,5,8,12};
//        int[] b = new int[size];
//        for (int i = 0; i < size; i++) {
//            b[i] = new Random().nextInt(size * 10);
//        }
        System.out.println(Arrays.toString(b));
//        int[] a = {2, 3, 5, 6, 7, 213, 4567, 32, 645, 7, 45, 74, 36, 12, 4, 2, 35, 367, 4, 63, 15, 3, 647, 213};
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        long start = System.currentTimeMillis();
//        System.out.println("开始时间" + simpleDateFormat.format(new Date()));
        quickSort(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));
//        long end = System.currentTimeMillis();
//        System.out.println("结束时间" + simpleDateFormat.format(new Date()));
//        System.out.println("总耗时 " + (end - start) / 1000);

//        Random ra = new Random();
//        for (int i = 0; i < 30; i++) {
//            System.out.println(ra.nextInt(10) + 1);
//        }
//        通过java.util包中的Random类的nextInt方法来得到1-10的int随机数
//
//        生成0到1之间的任意随机小数：
//        生成[0,d)区间的随机小数，d为任意正的小数，则只需要将nextDouble方法的返回值乘以d即可。
//
//[n1，n2]

//        也就是 ra.nextDouble() * (n2-n1)+n1
//        for (int i = 0; i < 5; i++) {
//            System.out.println(ra.nextDouble() * 1000);
//        }
    }

    /**
     * 交换指定数组a的两个变量的值
     *
     * @param a 数组应用
     * @param i 数组下标
     * @param j 数组下标
     */
    public static void swap(int a[], int i, int j) {
        if (i == j) return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    /**
     * @param array 待排序数组
     * @param low   数组下标下界
     * @param high  数组下标上界
     * @return pivot
     */
    public static int partition(int array[], int low, int high) {
        //当前位置为第一个元素所在位置
        int p_pos = low;
        //采用第一个元素为轴
        int pivot = array[p_pos];

        for (int i = low + 1; i <= high; i++) {
            if (array[i] < pivot) {
//                p_pos++;
//                p_pos++;
                swap(array, ++p_pos, i);
//                System.out.println();
            }
        }
        swap(array, low, p_pos);
        System.out.println(Arrays.toString(array));
        return p_pos;
    }

    /**
     * 快速排序实现
     *
     * @param array
     * @param low
     * @param high
     */
    public static void quickSort(int array[], int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            System.out.println(pivot);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

}
