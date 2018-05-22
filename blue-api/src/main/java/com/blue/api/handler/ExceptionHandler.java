package com.blue.api.handler;

import com.blue.api.exception.BlueException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常捕捉类
 * Created by light blue on 2017/12/19
 */
@ControllerAdvice
@RestController
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object handException(Exception e){
        Map<String, Object> map = new HashMap<>();
        if (e instanceof BlueException){
            map.put("code", ((BlueException) e).getCode());
        }else{
            map.put("code", 0);
        }
        map.put("msg",  e.getMessage());
        return map;
    }
}
