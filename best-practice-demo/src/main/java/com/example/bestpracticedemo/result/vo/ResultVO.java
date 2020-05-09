package com.example.bestpracticedemo.result.vo;

import com.example.bestpracticedemo.result.annotation.ExceptionCode;
import com.example.bestpracticedemo.result.enums.ResultCode;
import lombok.Getter;

/**
 * 统一返回值
 *
 * @author Gary
 * @date 2020/5/9 15:22
 **/
@Getter
public class ResultVO<T> {
    private Integer code;
    private String message;
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultVO(ExceptionCode annotation, T data) {
        this.code = annotation.value();
        this.message = annotation.message();
        this.data = data;
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

}
