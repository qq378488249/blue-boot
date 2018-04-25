package com.blue.utils;

import java.util.Arrays;

/**
 * 类名
 *
 * @author lblue
 * @date 2018/4/9
 */
public class Test1 {
    public static void main(String[] args) {
        int[] b = {2, 3, 5, 6, 7, 213, 4567, 32, 645, 7, 45, 74, 36, 12, 4, 2, 35, 367, 4, 63, 15, 3, 647, 213};
        px(b);
        System.out.println(Arrays.toString(b));
    }

    static void px(int[] a) {
        int[] temp = new int[a.length];
        px(a, temp, 0, a.length-1);
    }

    private static void px(int[] a, int[] temp, int s, int e) {
        if (s < e) {
            int index = (s + e) / 2;
            px(a, temp, s, index);
            px(a, temp, index + 1, e);
            hb(a, temp, s, index, e);
        }
    }

    /**
     *
     * @param a
     * @param temp
     * @param s 开始点
     * @param index 分割点
     * @param e 结束点
     */
    private static void hb(int[] a, int[] temp, int s, int index, int e) {
        int l = s;
        int r = index + 1;
        int t = 0;
        while (l <= s && r <= e) {
            if (a[l] <= a[r]) {
                temp[t++] = a[l++];
            } else {
                temp[t++] = a[r++];
            }
        }

        //将左边剩余元素填充进temp中
        while (l <= index) {
            temp[t++] = a[l++];
        }
        //将右边剩余元素填充进temp中
        while (r <= e) {
            temp[t++] = a[r++];
        }

        //将temp中的元素全部拷贝到原数组中
        t = 0;
        while (s <= e) {
            a[s++] = temp[t++];
        }
    }
}
