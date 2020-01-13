package com.example.codedesigndemo.pattern.proxy;

/**
 * 代理模式测试
 *
 * @author Gary
 * @date 2020/1/9 16:32
 * @since jdk1.8
 **/
public class ProxyTest {

    public static void main(String[] args) {
        SgProxy proxy = new SgProxy();
        proxy.display();
    }
}
