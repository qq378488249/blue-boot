package com.blue.api.exception;

import lombok.Data;

/**
 * 自定义异常类
 *
 * @author lblue
 * @date 2018/5/7
 */
@Data
public class BlueException extends RuntimeException {
    private int code;
    private String msg;
    public BlueException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
