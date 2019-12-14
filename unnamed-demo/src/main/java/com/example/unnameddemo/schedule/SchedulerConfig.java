package com.example.unnameddemo.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * 定时线程池配置
 *
 * @author Gary
 * @date 2019/12/11 10:26
 * @since jdk1.8
 **/
@Configuration
public class SchedulerConfig {

        @Bean
        public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
            ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
            threadPoolTaskScheduler.setPoolSize(1);
            threadPoolTaskScheduler.setThreadNamePrefix("定时线程-");
            threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
            threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
            System.out.println("=======初始化定时线程池=======");
        return threadPoolTaskScheduler;
    }
}
