package com.example.bestpracticedemo.result.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义参数校验错误码和错误信息
 *
 * @author Gary
 * @date 2020/5/9 15:02
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD}) //该注解只能放到字段上
public @interface ExceptionCode {
    // 响应码
    int value() default 10000;

    // 响应信息
    String message() default "参数校验错误";
}
