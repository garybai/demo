package com.example.codedesigndemo.pattern.proxy;

/**
 * 代理
 *
 * @author Gary
 * @date 2020/1/9 16:29
 * @since jdk1.8
 **/
public class SgProxy implements Specialty {

    private WySpecialty wySpecialty = new WySpecialty();

    @Override
    public void display() {
        pre();
        wySpecialty.display();
        post();
    }

    public void pre(){
        System.out.println("代理之前");
    }

    public void post(){
        System.out.println("代理之后");
    }
}
