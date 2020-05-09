package com.example.bestpracticedemo.result.entity;

import com.example.bestpracticedemo.result.annotation.ExceptionCode;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户实体
 *
 * @author Gary
 * @date 2020/5/9 15:37
 **/
@Data
public class User {

    private Long id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账户长度必须6-11个字符")
    @ExceptionCode(value = 10001, message = "账号验证错误")
    private String account;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 16, message = "密码长度必须6-16个字符")
    @ExceptionCode(value = 10002, message = "密码验证错误")
    private String password;

    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @ExceptionCode(value = 10003, message = "邮箱验证错误")
    private String email;

}
