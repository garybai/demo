package com.example.unnameddemo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

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

    public void setTaskOnce(String taskName){
        String sDate = "2020-01-04 18:50:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date = sdf.parse(sDate);
            dynamicTask.setCron(taskName, date, ()-> System.out.println(taskName + "---" + Thread.currentThread().getName() + "---" + LocalTime.now()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void cancleCronTask(String name){
        dynamicTask.stop(name);
    }

    public int getTaskCount(){
        return dynamicTask.getCount();
    }
}
