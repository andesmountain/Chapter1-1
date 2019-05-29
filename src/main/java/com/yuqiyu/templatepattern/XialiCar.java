package com.yuqiyu.templatepattern;

public class XialiCar extends AbstractCar {
    @Override
    protected void weight() {
        System.out.println("xiali weight");
    }

    @Override
    protected void color() {
        System.out.println("black");
    }

    @Override
    protected int price() {
        System.out.println("price 10");
        return 10;
    }
}
