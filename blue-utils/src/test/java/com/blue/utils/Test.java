package com.blue.utils;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author lblue
 * @date 2018/4/9
 */
public class Test {
    public static void main(String[] args) {
        int[] b = {45, 42, 7};
        px(b);
        System.out.println(Arrays.toString(b));
    }

    static void px(int[] a) {
        int[] temp = new int[a.length];
        px(a, temp, 0, a.length - 1);
    }

    static void px(int[] a, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            px(a, temp, left, mid);//左边归并排序，使得左子序列有序
            px(a, temp, mid + 1, right);//右边归并排序，使得右子序列有序
            merge(a, temp, left, mid, right);//将两个有序子数组合并操作
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
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
        while (i <= mid) {//将左边剩余元素填充进temp中
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
