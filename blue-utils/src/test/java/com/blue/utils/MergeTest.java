package com.blue.utils;


import java.util.Arrays;

/**
 * 类名
 *
 * @author lblue
 * @date 2018/4/10
 */
public class MergeTest {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 2, 1, 5};
        int[] b = new int[a.length];
        px(a, b, 0, a.length - 1);
        System.out.println(Arrays.toString(b));
    }

    private static void px(int[] a, int[] b, int s, int e) {
        if (s < e) {
            int i = (s + e) / 2;
            px(a, b, s, i);
            px(a, b, i + 1, e);
            hb(a, b, s, i, e);
        }
    }

    private static void hb(int[] a, int[] b, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int t = 0;
        while (l <= mid && r <= right) {
            if (a[l] <= a[r]) {
                b[t++] = a[l++];
            } else {
                b[t++] = a[r++];
            }
        }
        while (l <= mid) {
            b[t++] = a[l++];
        }
        while (r <= right) {
            b[t++] = a[r++];
        }
        t = 0;
        while (left <= right) {
            a[left++] = b[t++];
        }
    }
}
