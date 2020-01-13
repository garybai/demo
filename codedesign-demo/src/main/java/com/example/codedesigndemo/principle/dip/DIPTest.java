package com.example.codedesigndemo.principle.dip;

/**
 * 依赖倒置原则
 *
 * @author Gary
 * @date 2020/1/8 15:27
 * @since jdk1.8
 **/
public class DIPTest {

    /**
     * Dependence Inversion Principle, DIP
     * @param args
     */
    public static void main(String[] args) {
        Customer bai = new Customer();
        System.out.println("顾客购买以下商品：");
        bai.shopping(new ShaoguanShop());
        bai.shopping(new WuyuanShop());
    }
}

interface Shop {
    String sell();
}

class ShaoguanShop implements Shop {

    @Override
    public String sell() {
        return "韶关土特产：香菇、木耳……";
    }
}

class WuyuanShop implements Shop {

    @Override
    public String sell() {
        return "婺源土特产：绿茶、酒糟鱼……";
    }
}

class Customer {
    public void shopping(Shop shop) {
        System.out.println(shop.sell());
    }
}