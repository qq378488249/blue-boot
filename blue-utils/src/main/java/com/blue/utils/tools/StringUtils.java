package com.blue.utils.tools;

import java.util.Objects;

/**
 * Created by light blue on 2017/12/19
 */
public class StringUtils {
    public static boolean isNull(Object... objects){
        if(objects==null||objects.length<1){
            return true;
        }
        for (Object object : objects) {
            if(object==null||object.toString().length()==0|| Objects.equals(object,"")){
                return true;
            }
        }
        return false;
    }
}
