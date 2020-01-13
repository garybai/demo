package com.example.codedesigndemo.pattern.singleton;

/**
 * 单例模式测试
 *
 * @author Gary
 * @date 2020/1/9 11:40
 * @since jdk1.8
 **/
public class SingletonTest {

    public static void main(String[] args) {
        p1Test();
        System.out.println("============");
        p2Test();
        System.out.println("============");
        p3Test();
        System.out.println("============");
        p4Test();
        System.out.println("============");
        p5Test();
    }

    private static void p1Test() {
        President1 p1 = President1.getInstance();
        p1.getName();
        President1 p2 = President1.getInstance();
        p2.getName();
        System.out.println(p1 == p2);
    }
    private static void p2Test() {
        President2 p1 = President2.getInstance();
        p1.getName();
        President2 p2 = President2.getInstance();
        p2.getName();
        System.out.println(p1 == p2);
    }
    private static void p3Test() {
        President3 p1 = President3.getInstance();
        p1.getName();
        President3 p2 = President3.getInstance();
        p2.getName();
        System.out.println(p1 == p2);
    }
    private static void p4Test() {
        President4 p1 = President4.getInstance();
        p1.getName();
        President4 p2 = President4.getInstance();
        p2.getName();
        System.out.println(p1 == p2);
    }
    private static void p5Test() {
        President5 p1 = President5.getInstance();
        p1.getName();
        President5 p2 = President5.getInstance();
        p2.getName();
        System.out.println(p1 == p2);
    }
}
