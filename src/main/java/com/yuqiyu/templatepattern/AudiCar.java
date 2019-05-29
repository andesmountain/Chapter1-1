package com.yuqiyu.templatepattern;

public class AudiCar extends AbstractCar {
    @Override
    protected void weight() {
        System.out.println("audi weight");
    }

    @Override
    protected void color() {
        System.out.println("blue");
    }

    @Override
    protected int price() {
        System.out.println("price 30");
        return 30;
    }
}
