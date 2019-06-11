package com.yuqiyu.jvm;

/**
 * -XX:+PrintGCDetails -XX:+DoEscapeAnalysis
 * 默认开启逃逸模式，对象在栈中，随方法结束而结束生命周期
 * -XX:-DoEscapeAnalysis  关闭逃逸模式，对象在堆里
 */
public class StackAlloc {
    public static class User{
        public int id =0;
        public String name="";
    }

    public static void alloc(){
        User u = new User();
        u.id=12;
        u.name="asdasd";
    }

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            alloc();
        }


        long endTime=System.currentTimeMillis();
        System.out.println("耗时："+(endTime-startTime));


    }

}
