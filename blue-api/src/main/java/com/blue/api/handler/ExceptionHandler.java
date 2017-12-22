package com.blue.api.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 全局异常捕捉类
 * Created by light blue on 2017/12/19
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object handException(Exception e){
        return e.getMessage();
    }
}
