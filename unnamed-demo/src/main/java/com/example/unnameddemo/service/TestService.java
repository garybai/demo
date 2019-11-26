package com.example.unnameddemo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @author Gary
 * @className TestService
 * @description TODO
 * @date 2019/11/22 12:02
 **/

@Component
public class TestService {


    /**
     * 
     * 
     * @author Gary
     * @return void 
     * @date 2019/11/26 14:48 
     */
    @Scheduled(cron = "0 48 14 ? * 1,2")
    public void test(){
        System.out.println(LocalTime.now());
    }


    /**
     * @description: f
     * @param name:
     * @param phone:
     * @return java.lang.String
     * @author: Gary
     * @date: 2019/11/26 16:18
     */
    public String a(String name, String phone){
        System.out.println(name + phone);
        return name + phone;
    }
}
