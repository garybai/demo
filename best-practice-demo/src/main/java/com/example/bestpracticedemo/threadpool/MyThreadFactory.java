package com.example.bestpracticedemo.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 定义线程池名称
 *
 * @author Gary
 * @date 2019/11/26 16:37
 * @since jdk1.8
 **/
public class MyThreadFactory implements ThreadFactory {

    private final AtomicInteger myThreadNum = new AtomicInteger(1);

    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     * create a thread is rejected
     */
    @Override
    public Thread newThread(Runnable r) {
        String myTheadName = "泡茶线程池-";
        return new Thread(r, myTheadName + myThreadNum.getAndIncrement());
    }
}
