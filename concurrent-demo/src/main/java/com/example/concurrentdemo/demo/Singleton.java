package com.example.concurrentdemo.demo;

/**
 * @author Gary
 * @className Test02
 * @description TODO
 * @date 2019-09-24 11:43
 **/
public class Singleton {

    static Singleton instance;

    static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
