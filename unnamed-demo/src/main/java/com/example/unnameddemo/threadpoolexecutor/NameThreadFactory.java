package com.example.unnameddemo.threadpoolexecutor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Gary
 * @className NameThreadFactory
 * @description TODO
 * @date 2019-07-28 22:28
 **/
public class NameThreadFactory implements ThreadFactory {

    private final AtomicInteger myThreadNnum = new AtomicInteger(0);

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
        Thread thread = new Thread(r, "mythread-" + myThreadNnum.getAndIncrement());
//        System.out.println(thread.getName() + " has been created");
        return thread;
    }
}
