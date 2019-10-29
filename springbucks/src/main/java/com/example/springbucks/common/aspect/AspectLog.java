package com.example.springbucks.common.aspect;

import cn.hutool.json.JSONUtil;
import com.example.springbucks.common.annotation.TimeAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Gary
 * @className AspectLog
 * @description TODO
 * @date 2019-09-11 15:25
 **/
@Aspect
@Slf4j
@Component
public class AspectLog {

    /**
     * 存储开始时间、请求名称、请求参数
     *
     */
    private ThreadLocal<Long> startTime = new ThreadLocal<>();
    private ThreadLocal<String> name = new ThreadLocal<>();
    private ThreadLocal<Map> parameters = new ThreadLocal<>();

    private static String[] types = {"java.lang.Integer", "java.lang.Double",
            "java.lang.Float", "java.lang.Long", "java.lang.Short",
            "java.lang.Byte", "java.lang.Boolean", "java.lang.Char",
            "java.lang.String", "int", "double", "long", "short", "byte",
            "boolean", "char", "float"};

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.example.springbucks.common.annotation.TimeAspect)")
    public void aspectLog() {

    }

    /**
     * 前置操作
     *
     * @param joinPoint 切入点
     */
    @Before("aspectLog()")
    public void beforeLog(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        HttpServletResponse response = attributes.getResponse();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        TimeAspect timeAspect = method.getAnnotation(TimeAspect.class);
        name.set(timeAspect.name());

//        log.info("【请求 URL】：{}", request.getRequestURL());
//        log.info("【请求 IP】：{}", request.getRemoteAddr());
//        log.info("【请求类名】：{}，【请求方法名】：{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());

//        Map<String, String[]> parameterMap = request.getParameterMap();
//        log.info("{}【请求参数】：{}，", name, JSONUtil.toJsonStr(parameterMap));
        Long start = System.currentTimeMillis();
        startTime.set(start);

        // 记录请求参数
        Map<String, Object> parameterMap = new HashMap<>(8);

        // joinPoint获取参数名
        String[] params = ((CodeSignature) joinPoint.getStaticPart().getSignature()).getParameterNames();
        // joinPoint获取参数值
        Object[] args = joinPoint.getArgs();

        // 打印请求参数
        int i = 0;
        for (Object arg : args) {
            if (arg == request || arg == response || arg instanceof BindingResult) {
                i += 1;
                continue;
            }

            // 对参数进行非空校验
            if (arg != null) {

                String typeName = "";
                typeName = arg.getClass().getTypeName();

                if (!Arrays.asList(types).contains(typeName)) {
                    // 把参数转成json格式
                    parameterMap.put(params[i], JSONUtil.parseObj(arg));
                } else {
                    parameterMap.put(params[i], arg);
                }
            } else { // 如果参数为空，直接将null存进去
                parameterMap.put(params[i], null);
            }
            i += 1;
        }
        parameters.set(parameterMap);

        log.info("{}【请求参数】：{}", name.get(), JSONUtil.toJsonStr(parameters.get()));

    }

    /**
     * 环绕操作
     *
     * @param point 切入点
     * @return 原方法返回值
     * @throws Throwable 异常信息
     */
    @Around("aspectLog()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {

        Object result = point.proceed();
        log.info("{}【返回值】：{}", name.get(), JSONUtil.toJsonStr(result));
        return result;
    }

    /**
     * 后置操作
     */
    @AfterReturning("aspectLog()")
    public void afterReturning(JoinPoint point) {

        Long end = System.currentTimeMillis();
        log.info("{}【请求耗时】：{}毫秒", name.get(), end - startTime.get());

        startTime.remove();
        name.remove();
        parameters.remove();

    }

}
