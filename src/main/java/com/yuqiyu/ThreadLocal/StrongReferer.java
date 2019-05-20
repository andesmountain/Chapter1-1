package com.yuqiyu.ThreadLocal;

public class StrongReferer {
    public static void main(String[] args) throws InterruptedException {
        Object[] arr= new Object[5];
        for(int i=0;i<5;i++){
            Object abc = new byte[1024*1024*5];
            arr[i]=abc;
            System.out.println("创建第"+(i+1)+"个对象");
            abc=null;
            // arr[i]=null;
        }
    }
}