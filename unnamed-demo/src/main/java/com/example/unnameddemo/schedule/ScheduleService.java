package com.example.unnameddemo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * 定时 Service
 *
 * @author Gary
 * @date 2019/12/11 10:49
 * @since jdk1.8
 **/
@Service
public class ScheduleService {

    @Autowired
    private DynamicTask dynamicTask;

    public void setCronTask(String taskName){
        String cron = "0 57 11 11 12 ?";
        dynamicTask.setCron(taskName, cron, ()-> System.out.println(taskName + "---" + Thread.currentThread().getName() + "---" + LocalTime.now()));
    }

    public void cancleCronTask(String name){
        dynamicTask.stop(name);
    }

    public int getTaskCount(){
        return dynamicTask.getCount();
    }
}
