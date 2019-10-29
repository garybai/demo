package com.example.unnameddemo.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Gary
 * @className AsyncThreadPoolConfig
 * @description TODO
 * @date 2019-07-29 23:45
 **/
@Configuration
public class AsyncThreadPoolConfig {

    @Bean
    public Executor getAsyncExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(3);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(10);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        threadPoolTaskExecutor.setThreadNamePrefix("异步线程-");
        //初始化线程池
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

}
