package com.example.unnameddemo.runner;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author Gary
 * @className MyInitializingBean
 * @description TODO
 * @date 2019-10-26 21:01
 **/
@Component
public class MyInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("This is MyInitializingBean");

    }
}
