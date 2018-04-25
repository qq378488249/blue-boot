package com.blue.utils;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author lblue
 * @date 2018/4/8
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] a = {45, 42, 7, 35, 14};
        int[] a = {2, 3, 5, 6, 7, 213, 4567, 32, 645, 7, 45, 74, 36, 12, 4, 2, 35, 367, 4, 63, 15, 3, 647, 213};
//        int[] a = {45, 42, 7};
//        int[] a = new int[10];
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            a[i] = random.nextInt(1000);
//        }
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i++];
            } else {
                temp[t] = arr[j++];
            }
            t++;
        }
        while (i <= mid) {//将左序列剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
