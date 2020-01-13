package com.example.codedesigndemo.principle.crp;

/**
 * 合成复用原则
 *
 * @author Gary
 * @date 2020/1/8 16:41
 * @since jdk1.8
 **/
public class CRPTest {
    /**
     * Composite Reuse Principle, CRP
     *
     * @param args
     */
    public static void main(String[] args) {
        Car car1 = new GasolineCar(new Color("红色"));
        car1.move();
        Car car2 = new ElectricCar(new Color("白色"));
        car2.move();
    }
}

class Car {
    private Color color;

    public Car(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void move() {

    }
}

class GasolineCar extends Car {

    public GasolineCar(Color color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println("我靠烧汽油行驶，我的颜色是: " + getColor().getName());
    }
}

class ElectricCar extends Car {

    public ElectricCar(Color color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println("我靠电行驶，我的颜色是: " + getColor().getName());
    }
}

class Color {
    private String name;

    public Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
