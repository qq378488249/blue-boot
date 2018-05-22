package com.blue.dao.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回模型类
 *
 * @author lblue
 * @date 2018/5/21
 */
@Data
public class ResultModel implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    public ResultModel setErrMsg(String msg){
        setMessage(msg);
        setCode(200);
        return this;
    }

    public ResultModel setSucMsg(String msg){
        setMessage(msg);
        setCode(201);
        return this;
    }
}
