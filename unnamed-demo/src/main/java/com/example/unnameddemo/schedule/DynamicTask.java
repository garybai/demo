package com.example.unnameddemo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * 动态定时任务类
 *
 * @author Gary
 * @date 2019/12/11 10:40
 * @since jdk1.8
 **/
@Component
public class DynamicTask {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    public static Map<String, ScheduledFuture> map = new ConcurrentHashMap<>();

    public void setCron(String taskName, String cron, Runnable runnable) {
        ScheduledFuture<?> future = threadPoolTaskScheduler.schedule(runnable, new CronTrigger(cron));
        assert future != null;
        map.put(taskName, future);
    }

    public void setCron(String taskName, Date dateTime, Runnable runnable) {
        ScheduledFuture<?> future = threadPoolTaskScheduler.schedule(runnable, dateTime);
        assert future != null;
        map.put(taskName, future);
    }

    public void stop(String name){
        ScheduledFuture future = map.get(name);
        future.cancel(true);
        map.remove(name);
    }

    public int getCount(){
        return map.size();
    }
}
