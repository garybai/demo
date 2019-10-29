package com.example.unnameddemo.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author Gary
 * @className DataBinderControllerAdvice
 * @description TODO
 * @date 2019-10-27 22:39
 **/
@ControllerAdvice
public class DataBinderControllerAdvice {

    @InitBinder("b")
    public void b(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }
    @InitBinder("a")
    public void a(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a.");
    }

}
