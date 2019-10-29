package com.example.unnameddemo.synchronize;

/**
 * @author Gary
 * @className Test
 * @description TODO
 * @date 2019-07-22 14:07
 **/
public class Test {

    public synchronized void test1() {
        try {
            System.out.println("test1 start");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("test1 end");
    }

    public synchronized void test2() {
        try {
            System.out.println("test2 start");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("test2 end");
    }

    public static void main(String[] args) {
        Test test = new Test();

        new Thread(() -> test.test1()).start();
        new Thread(() -> test.test2()).start();
    }

}
