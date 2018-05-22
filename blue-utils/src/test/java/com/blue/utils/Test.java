package com.blue.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 归并排序
 *
 * @author lblue
 * @date 2018/4/9
 */
public class Test {
//    public static void main(String[] args) {
//        int[] b = {45, 42, 7};
//        px(b);
//        System.out.println(Arrays.toString(b));
//    }

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

    public static void main(String[] args) throws IOException {
        in();
//        System.out.println("请输入你的年龄：");
//        int age = sc.nextInt();
//        System.out.println("请输入你的工资：");
//        float salary = sc.nextFloat();
//        System.out.println("你的信息如下：");
//        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);
    }

    public static void in() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入一个数字字符串：");
//        String str = sc.nextLine();
//
//        if (str == null || str.equals("")) {
//            System.out.println("不能输入空，请重新输入");
//            //继续接受键盘输入
//        } else {
//            if (isNum(str)) {
//                System.out.println("您输入的数字是 " + str);
//                return;
//            } else {
//                System.out.println("您输入的不是数字，请重新输入 ");
//                //继续接受键盘输入
//            }
//        }
//        in();
        System.out.println(je(50000, 0.095, 6));
        System.out.println(je1(50000, 0.1, 6));
    }

    static double je(double bj, double ll, double qx) {
        double lx = bj * ll * qx / 12;
        System.out.println("利息"+lx);
        double sx = (bj + lx) * 0.015;
        System.out.println("手续费" + sx);
        return (bj + lx) * 0.985;
    }

    static double je1(double bj, double ll, double qx) {
        double lx = bj * ll * qx / 12;
        System.out.println("利息"+lx);
        double sx = lx * 0.05;
        System.out.println("手续费" + sx);
        return bj + (lx * 0.95);
    }

    public static boolean isNum(String str) {
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
//            if (Character.isDigit(aChar)) {
//                return true;
//            }
            if (!(aChar >= '0' && aChar <= '9')) {
                return false;
            }
        }
        return true;
    }
}
