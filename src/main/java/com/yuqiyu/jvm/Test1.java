package com.yuqiyu.jvm;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/6/17
 * 公司：北京活力天汇<br>
 **/
public class Test1 {
    private String a;
    private String b;

    @Override
    public String toString() {
        return "a:" + a + ";b:" + b;
    }

    public enum Color {
        red("红色", 1) {
            @Override
            void hello() {
                System.out.println("我是红色");
            }
        }, blue("蓝色", 0) {
            @Override
            void hello() {
                System.out.println("我是蓝色");
            }
        };

        String name;
        int price;

        Color(String name, int price) {
            this.name = name;
            this.price = price;
        }

        abstract void hello();

    }


    public static class Builder {
        Test1 t1;

        public Builder() {
            this.t1 = new Test1();
        }

        public Builder a(String ss) {
            t1.a = ss;
            return this;
        }

        public Builder b(String ss) {
            t1.b = ss;
            return this;
        }

        public Test1 build() {
            return this.t1;
        }

    }


    public static void main(String[] args) {
        Test1 t1 = new Test1.Builder().a("abc").b("fuck that").build();
        System.out.println(t1);

        Color c = Color.blue;
        switch (c) {
            case red:
                c.hello();
                break;
            case blue:
                c.hello();
                break;
            default:
                System.out.println("nothing");
        }
    }

}
