package com.blue.utils;

import java.util.Arrays;

/**
 * 类名
 *
 * @author lblue
 * @date 2018/4/9
 */
public class Test2 {
    public static void main(String[] args) {
        int[] b = {3, 5, 7, 5, 8, 12};
//        jh(b,1,2);
//        System.out.println(Arrays.toString(b));
//        for (int i = 0; i < ; i++) {
//            for (int i1 = 0; i1 < b.length; i1++) {
//
//            }
//        }
        int temp = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = b.length - 1; j > -1; j--) {
                if (b[i] < b[j]) {
                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
//        for (int i : b) {

//            for (int i1 : b) {
//                if (i < i1) {
////                    = b[]
////                    temp = i;
////                    i = i1;
////                    i1 = temp;
//
//                    i += i1;
//                    i1 = i - i1;
//                    i = i - i1;
//
//                }
//            }
//        }
//        px(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));
    }

    static void px(int[] a, int s, int e) {
        if (s < e) {
            int index = getIndex(a, s, e);
            System.out.println(index);
            px(a, s, index - 1);
            px(a, index + 1, e);
        }
    }

    private static int getIndex(int[] a, int s, int e) {
        int index = s;
        int value = a[s];
        for (int i = 1; i <= e; i++) {
            if (a[i] < value) {
                jh(a, i, ++index);
            }
        }
        jh(a, index, s);
        return index;
    }

    private static void jh(int[] a, int i, int index) {
        a[i] += a[index];
        a[index] = a[i] - a[index];
        a[i] = a[i] - a[index];
    }
}
