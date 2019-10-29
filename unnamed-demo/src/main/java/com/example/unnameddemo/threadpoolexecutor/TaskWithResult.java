package com.example.unnameddemo.threadpoolexecutor;

import lombok.Data;

import java.util.concurrent.Callable;

/**
 * @author Gary
 * @className TaskWithResult
 * @description TODO
 * @date 2019-07-29 11:19
 **/
@Data
public class TaskWithResult implements Callable<String> {
    /**
     * Computes a result, or throws an exception if unable to dooo so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */

    private String name;

    public TaskWithResult(String name){
        this.name = name;
    }

    @Override
    public String call() {
        System.out.println("thread " + Thread.currentThread().getName() + " start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("thread " + Thread.currentThread().getName() + " interrupted");
        }
        System.out.println("thread " + Thread.currentThread().getName() + " end");
        return name + " executing";
    }
}
