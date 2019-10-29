package com.example.unnameddemo.threadpoolexecutor;

import lombok.Data;

/**
 * @author Gary
 * @className TaskWithoutResult
 * @description TODO
 * @date 2019-07-28 21:40
 **/
@Data
public class TaskWithoutResult implements Runnable {

    private String name;

    public TaskWithoutResult(String name) {
        this.name = name;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("thread " + Thread.currentThread().getName() + " start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("thread " + Thread.currentThread().getName() + " interrupted");
        }
        System.out.println("thread " + Thread.currentThread().getName() + " end");
    }

    @Override
    public String toString() {
        return "mythread-" + name;
    }
}
