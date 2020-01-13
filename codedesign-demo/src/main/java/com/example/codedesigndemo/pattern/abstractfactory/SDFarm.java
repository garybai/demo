package com.example.codedesigndemo.pattern.abstractfactory;

/**
 * 具体农场-SD农场
 *
 * @author Gary
 * @date 2020/1/9 14:52
 * @since jdk1.8
 **/
public class SDFarm implements Farm {
    @Override
    public Animal newAnimal() {
        System.out.println("新牛出生");
        return new Cattle();
    }

    @Override
    public Plant newPlant() {
        System.out.println("蔬菜长成");
        return new Vegetables();
    }
}
