package com.example.bestpracticedemo.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 *
 * @author Gary
 * @date 2020/1/20 17:22
 * @since jdk1.8
 **/
public class ConnectPool {

    private int size;
    private Connect[] connects;
    private boolean[] connectFlags;
    private volatile int available;
    private Semaphore semaphore;

    public ConnectPool(int size) {
        this.size = size;
        this.available = size;
        connects = new Connect[size];
        connectFlags = new boolean[size];
        semaphore = new Semaphore(size);
        initConnects();
    }

    private void initConnects() {
        for (int i = 0; i < this.size; i++) {
            connects[i] = new Connect("localhost", "123", 3306);
        }
    }

    private synchronized Connect getConnect(){
        for (int i = 0; i < connectFlags.length; i++) {
            if(!connectFlags[i]){
                connectFlags[i] = true;
                available--;
                System.out.println(Thread.currentThread().getName() + "获取到连接，剩余连接：" + available);
                return connects[i];
            }
        }
        return null;
    }

    public Connect openConnect() throws InterruptedException {
        semaphore.acquire();
        return getConnect();
    }

    public synchronized void release(Connect connect){
        for (int i = 0; i <connectFlags.length; i++) {
            if(connect == connects[i]){
                connectFlags[i] = false;
                available++;
                System.out.println(Thread.currentThread().getName() + "释放连接，剩余连接：" + available);
                semaphore.release();
            }
        }
    }

    public int getAvailable(){
        return available;
    }

}

