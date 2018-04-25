package com.blue.utils.tools;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * gson工具类
 *
 * @author lblue
 * @date 2016/4/25
 */
public class GsonUtils {

    private static Gson gson = new Gson();

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static <T> T  fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json,classOfT);
    }

    public <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        return gson.fromJson(json,typeOfT);
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("asg", "qwoit");

        System.out.println(GsonUtils.toJson(map));
        Map<String, Object> map1 = GsonUtils.fromJson(GsonUtils.toJson(map), Map.class);
        System.out.println(map1);
    }
}
