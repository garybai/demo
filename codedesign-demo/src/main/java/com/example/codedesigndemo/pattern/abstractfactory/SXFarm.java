package com.example.codedesigndemo.pattern.abstractfactory;

/**
 * 具体农场-SX农场
 *
 * @author Gary
 * @date 2020/1/9 14:49
 * @since jdk1.8
 **/
public class SXFarm implements Farm {
    @Override
    public Animal newAnimal() {
        System.out.println("新马出生");
        return new Horse();
    }

    @Override
    public Plant newPlant() {
        System.out.println("水果长成");
        return new Fruitage();
    }
}
