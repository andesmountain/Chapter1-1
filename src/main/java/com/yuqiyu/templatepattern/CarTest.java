package com.yuqiyu.templatepattern;

public class CarTest {
    public static void main(String[] args) {
        AbstractCar car1= new AudiCar();
        car1.run();

        AbstractCar car2= new XialiCar();
        car2.run();
    }
}
