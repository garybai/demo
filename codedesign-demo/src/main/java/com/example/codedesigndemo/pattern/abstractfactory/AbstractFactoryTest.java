package com.example.codedesigndemo.pattern.abstractfactory;

/**
 * 抽象工厂测试
 *
 * @author Gary
 * @date 2020/1/9 14:54
 * @since jdk1.8
 **/
public class AbstractFactoryTest {
    public static void main(String[] args) {
        Farm sxFarm = new SXFarm();
        sxFarm.newAnimal().show();
        sxFarm.newPlant().show();

        Farm sdFarm = new SDFarm();
        sdFarm.newAnimal().show();
        sdFarm.newPlant().show();
    }
}
