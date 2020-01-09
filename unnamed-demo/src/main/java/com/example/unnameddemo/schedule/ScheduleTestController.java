package com.example.unnameddemo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定时 congtroller'
 *
 * @author Gary
 * @date 2019/12/11 10:54
 * @since jdk1.8
 **/
@RestController
public class ScheduleTestController {

    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/set")
    public void setCron(@RequestParam("taskName") String taskName){
        scheduleService.setCronTask(taskName);
    }

    @PostMapping("/set1")
    public void setOnce(@RequestParam("taskName") String taskName){
        scheduleService.setTaskOnce(taskName);
    }

    @PostMapping("/cancle")
    public void cancle(@RequestParam("name") String name){
        scheduleService.cancleCronTask(name);
    }

    @GetMapping("/count")
    public Integer count(){
        return scheduleService.getTaskCount();
    }
}
