package com.example.unnameddemo.result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gary
 * @className GlobalExceptionHandler
 * @description TODO
 * @date 2019-07-26 14:46
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ResultData myExceptionHandler(HttpServletRequest req, MyException e) {
        log.error("发生业务异常！原因是：{}，{}", req.getRequestURI(), e.getErrorMsg());
        return ResultData.error(e.getErrorCode(), e.getErrorMsg());
    }


    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest req, IndexOutOfBoundsException e) {
        log.error("{}数组越界！原因是: {}", req.getRequestURI(), e.getMessage());
        return ResultData.error(MyExceptionEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest req, NullPointerException e) {
        log.error("{}发生空指针异常！原因是: {}", req.getRequestURI(), e.getMessage());
        return ResultData.error(MyExceptionEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * 处理请求方法不支持的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = ResourceAccessException.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest req, ResourceAccessException e) {
        log.error("{}请求超时！原因是: {}", req.getRequestURI(), e.getMessage());
        return ResultData.error(MyExceptionEnum.REQUEST_TIMEOUT);
    }

    /**
     * 处理请求方法不支持的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest req, HttpRequestMethodNotSupportedException e) {
        log.error("{}发生请求方法不支持异常！原因是: {}", req.getRequestURI(), e.getMessage());
        return ResultData.error(MyExceptionEnum.REQUEST_METHOD_SUPPORT_ERROR);
    }

    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultData exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("{}未知异常！原因是: {}", req.getRequestURI(), e.getMessage());
        return ResultData.error(MyExceptionEnum.INTERNAL_SERVER_ERROR);
    }

    @ModelAttribute(name = "md")
    public Map<String,Object> mydata() {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("age", 99);
        map.put("gender", "男");
        return map;
    }

    @ModelAttribute(name = "ma")
    public Map<String,Object> mydata1() {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("age", 90);
        map.put("gender", "女");
        return map;
    }

}
