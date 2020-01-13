package com.example.codedesigndemo.principle.ocp;

/**
 * 开闭原则
 *
 * @author Gary
 * @date 2020/1/8 15:15
 * @since jdk1.8
 **/
public class OCPTest {

    /**
     * Open Closed Principle, OCP
     * @param args
     */
    public static void main(String[] args) {
        AbstractSubject specificSubject1 = new SpecificSubject1();
        specificSubject1.display();
        AbstractSubject specificSubject2 = new SpecificSubject2();
        specificSubject2.display();
    }
}

abstract class AbstractSubject {

    /**
     * 主题展示
     * @description: 主题展示
     * @param :
     * @return void
     * @author: Gary
     * @date: 2020/1/8 14:51
     */
    abstract void display();
}

class SpecificSubject1 extends AbstractSubject {

    @Override
    void display() {
        System.out.println("我是主题1");
    }

}

class SpecificSubject2 extends AbstractSubject {

    @Override
    void display() {
        System.out.println("我是主题2");
    }
}
