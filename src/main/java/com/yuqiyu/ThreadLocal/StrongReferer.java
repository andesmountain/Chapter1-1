package com.yuqiyu.ThreadLocal;

public class StrongReferer {
    public static void main(String[] args) throws InterruptedException {
        Object abc = new byte[1024*1024*5];
        B b1 = new B(abc);
        abc=null;
        System.out.println("创建第1个对象");
        Thread.sleep(1000);

        abc = new byte[1024*1024*5];
        B b2 = new B(abc);
        abc=null;
        System.out.println("创建第2个对象");
        Thread.sleep(1000);

        abc = new byte[1024*1024*5];
        B b3 = new B(abc);
        abc=null;
        System.out.println("创建第3个对象");
        Thread.sleep(1000);

        abc = new byte[1024*1024*5];
        B b4 = new B(abc);
        abc=null;
        System.out.println("创建第4个对象");
        Thread.sleep(1000);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }
}
class B{
    Object b;
    public B(Object b){
        this.b = b;
    }
}