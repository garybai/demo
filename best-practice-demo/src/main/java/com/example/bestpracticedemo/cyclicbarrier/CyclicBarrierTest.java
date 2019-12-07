package com.example.bestpracticedemo.cyclicbarrier;

import java.util.Vector;

/**
 * test
 *
 * @author Gary
 * @date 2019/12/7 14:26
 * @since jdk1.8
 **/
public class CyclicBarrierTest {

    public static void main(String[] args) {
        Vector<String> pos = new Vector<>();
        Vector<String> dos = new Vector<>();
        CyclicBarrierTask test = new CyclicBarrierTask(pos, dos);
        test.checkAll();
    }

}
