package com.blue.utils.tools;

import java.util.Objects;

/**
 * 字符串工具类
 *
 * @author lblue
 * @date 2016/4/25
 */
public class StringUtils {

    /**
     * 判断对象为空/为null
     *
     * @param objects
     * @return
     */
    public static boolean isEmpty(Object... objects) {
        if (objects == null) {
            return true;
        }
        for (Object object : objects) {
            if (object == null || object.toString().length() == 0 || Objects.equals(object, "")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断对象非空/非null
     *
     * @param objects
     * @return
     */
    public static boolean notEmpty(Object... objects) {
        return !isEmpty(objects);
    }

    /**
     * 隐藏手机号中间4位
     *
     * @param mobile
     * @return 123****5678
     */
    public static String hiddenMobile(String mobile) {
        return hiddenMobile(mobile, 4);
    }

    /**
     * 隐藏手机号
     * @param mobile
     * @param hiddenLength 中间需要隐藏的长度
     * @return
     */
    public static String hiddenMobile(String mobile, int hiddenLength) {
        if (isEmpty(mobile)) {
            throw new RuntimeException("mobile is not null");
        }
        if (isEmpty(hiddenLength)) {
            throw new RuntimeException("hiddenLength is not null");
        }
        if (hiddenLength>8) {
            throw new RuntimeException("the hiddenLength is to long");
        }
        int endShow = mobile.length() - 3 - hiddenLength;
        String regex = "(\\d{3})\\d{" + hiddenLength + "}(\\d{" + endShow + "})";
        String replacement = "$1";
        for (int i = 0; i < hiddenLength; i++) {
            replacement += "*";
        }
        replacement += "$2";
        return mobile.replaceAll(regex, replacement);
    }

    public static String hiddenName(String name) {
        if (isEmpty(name)) {
            throw new RuntimeException("name is not null");
        }
        String regex = "([\\d\\D]{1})[\\d\\D]";
        String replacement = "$1*";
        int hiddenLength = name.length() - 2;
        if (name.length() > 2) {
            regex += "{" + hiddenLength + "}([\\d\\D]{1})";
            for (int i = 3; i < name.length(); i++) {
                replacement += "*";
            }
            replacement += "$2";
        }
        return name.replaceAll(regex, replacement);
    }

    public static void main(String[] args) {
        System.out.println(hiddenMobile("17602111154"));
        System.out.println(hiddenMobile("12345678901",5));
        System.out.println(hiddenName("关羽"));
        System.out.println(hiddenName("赵子龙"));
        System.out.println(hiddenName("诸葛孔明"));
        System.out.println(hiddenName("诸葛孔明亮"));

        System.out.println(notEmpty(1, 2, 12, 468, 3, ""));

    }
}
