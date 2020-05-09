package com.example.bestpracticedemo.result.config;

import com.example.bestpracticedemo.result.annotation.ExceptionCode;
import com.example.bestpracticedemo.result.enums.ResultCode;
import com.example.bestpracticedemo.result.exception.APIException;
import com.example.bestpracticedemo.result.vo.ResultVO;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;

/**
 * 全局异常处理
 *
 * @author Gary
 * @date 2020/5/9 15:21
 **/
@RestControllerAdvice
public class ExceptionControllerAdvice {

//    @ExceptionHandler(Exception.class)
//    public ResultVO<String> exceptionHandler(Exception e) {
//        return new ResultVO<>(ResultCode.ERROR, e.getMessage());
//    }

    @ExceptionHandler(APIException.class)
    public ResultVO<String> apiExceptionHandler(APIException e) {
        return new ResultVO<>(e.getCode(), "未知错误", e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) throws NoSuchFieldException {
        // 从异常对象中获取错误信息
        String defaultMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        // 参数的class对象，等下通过字段名称获取field对象
        Class<?> parameterType = e.getParameter().getParameterType();

        // 拿到错误的字段名称
        String fieldName = e.getBindingResult().getFieldError().getField();
        Field field = parameterType.getDeclaredField(fieldName);

        // 获取field上的自定义注解
        ExceptionCode annotation = field.getAnnotation(ExceptionCode.class);

        // 如果有注解，就返回注解的相应信息
        if (annotation != null) {
            return new ResultVO<>(annotation.value(), annotation.message(), defaultMessage);
        }
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, defaultMessage);

    }

}
