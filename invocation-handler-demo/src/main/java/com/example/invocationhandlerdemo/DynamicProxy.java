package com.example.invocationhandlerdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Gary
 * @className DynamicProxy
 * @description TODO
 * @date 2019-11-07 11:38
 **/
public class DynamicProxy implements InvocationHandler {

    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(),
                this.delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        try {
            String methodName = method.getName();
            if (methodName.equalsIgnoreCase("sayHello")) {
                System.out.println("我来了");
            } else if (methodName.equalsIgnoreCase("sayGoodBye")) {
                System.out.println("我走了");
            }
            // JVM通过这条语句执行原来的方法(反射机制)
            result = method.invoke(this.delegate, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
