package com.example.codedesigndemo.principle.isp;

/**
 * 接口隔离原则
 *
 * @author Gary
 * @date 2020/1/8 15:42
 * @since jdk1.8
 **/
public class ISPTest {

    /**
     * Inteface Segregation Principle, ISP
     *
     * @param args
     */
    public static void main(String[] args) {
        InputModule inputModule = StuScoreList.getInputModule();
        CountModule countModule = StuScoreList.getCountModule();
        PrintModule printModule = StuScoreList.getPrintModule();
        inputModule.insert();
        countModule.countAverage();
        printModule.printStuInfo();
    }
}

interface InputModule {
    void insert();

    void delete();

    void modify();
}

interface CountModule {
    void countTotalScore();

    void countAverage();
}

interface PrintModule {
    void printStuInfo();

    void queryStuInfo();
}

class StuScoreList implements InputModule, CountModule, PrintModule {

    private StuScoreList() {
    }

    public static InputModule getInputModule() {
        return new StuScoreList();
    }

    public static CountModule getCountModule() {
        return new StuScoreList();
    }

    public static PrintModule getPrintModule() {
        return new StuScoreList();
    }

    @Override
    public void insert() {
        System.out.println("输入模块的insert()方法被调用！");
    }

    @Override
    public void delete() {
        System.out.println("输入模块的delete()方法被调用！");
    }

    @Override
    public void modify() {
        System.out.println("输入模块的modify()方法被调用！");
    }

    @Override
    public void countTotalScore() {
        System.out.println("统计模块的countTotalScore()方法被调用！");
    }

    @Override
    public void countAverage() {
        System.out.println("统计模块的countAverage()方法被调用！");
    }

    @Override
    public void printStuInfo() {
        System.out.println("打印模块的printStuInfo()方法被调用！");
    }

    @Override
    public void queryStuInfo() {
        System.out.println("打印模块的queryStuInfo()方法被调用！");
    }
}