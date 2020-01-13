package com.example.codedesigndemo.principle.lkp;

/**
 * 最少知识原则
 *
 * @author Gary
 * @date 2020/1/8 16:12
 * @since jdk1.8
 **/
public class LKPTest {

    /**
     * Least Knowledge Principle, LKP, Law of Demeter
     *
     * @param args
     */
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setStar(new Star("张韶涵"));
        agent.setFans(new Fans("粉丝张三"));
        agent.setCompany(new Company("中国传媒有限公司"));
        agent.meeting();
        agent.business();
    }
}

class Agent {
    private Star star;
    private Fans fans;
    private Company company;

    public void setStar(Star star) {
        this.star = star;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void meeting() {
        System.out.println(fans.getName() + "与明星" + star.getName() + "见面了。");
    }

    public void business() {
        System.out.println(company.getName() + "与明星" + star.getName() + "洽淡业务。");
    }
}

class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Fans {
    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
