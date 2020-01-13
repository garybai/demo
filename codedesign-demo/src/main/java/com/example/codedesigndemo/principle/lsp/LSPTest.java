package com.example.codedesigndemo.principle.lsp;

/**
 * 里氏替换原则
 *
 * @author Gary
 * @date 2020/1/8 15:00
 * @since jdk1.8
 **/
public class LSPTest {

    /**
     * Liskov Substitution Principle, LSP
     * @param args
     */
    public static void main(String[] args) {
        Bird bird = new Swallow();
        bird.setFlySpeed(120D);
        Animal animal = new BrownKiwi();
        animal.setRunSpeed(100D);
        System.out.println("如果飞行300公里：");
        try {
            System.out.println("燕子将飞行" + bird.getFlyTime(300D) + "小时.");
            System.out.println("几维鸟将飞行" + animal.getRunTime(300D) + "小时。");
        } catch (Exception err) {
            System.out.println("发生错误了!");
        }
    }

}

class Animal {
    private Double runSpeed;

    public void setRunSpeed(Double runSpeed) {
        this.runSpeed = runSpeed;
    }

    public Double getRunTime(Double distance) {
        return distance / runSpeed;
    }
}

class Bird extends Animal {
    private Double flySpeed;

    public void setFlySpeed(Double flySpeed) {
        this.flySpeed = flySpeed;
    }

    public Double getFlyTime(Double distanct) {
        return distanct / flySpeed;
    }
}

class BrownKiwi extends Animal {

}

class Swallow extends Bird {

}
