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

    @Scheduled(cron = "0 48 14 ? * 1,2")
    public void test(){
        System.out.println(LocalTime.now());
    }
}
