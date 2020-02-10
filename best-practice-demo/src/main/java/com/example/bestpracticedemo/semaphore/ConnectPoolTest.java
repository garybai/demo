package com.example.bestpracticedemo.semaphore;

import java.util.concurrent.TimeUnit;

/**
 * 信号量测试
 *
 * @author Gary
 * @date 2020/1/20 17:41
 * @since jdk1.8
 **/
public class ConnectPoolTest extends Thread {

    private static ConnectPool connectPool = new ConnectPool(3);

    @Override
    public void run() {
        Connect connect = null;
        try {
            connect = connectPool.openConnect();
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            connectPool.release(connect);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new ConnectPoolTest().start();
        }

    }

}
