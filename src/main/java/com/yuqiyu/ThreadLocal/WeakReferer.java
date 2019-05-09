package com.yuqiyu.ThreadLocal;

import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WeakReferer {


    public static void main(String[] args) throws InterruptedException {
        Object str=new byte[1024*1024*5];
        WeakReference<Object> a1 = new WeakReference<Object>(str);
        str=null;
        System.out.println("创建第1个对象");
        Thread.sleep(1000);


        str=new byte[1024*1024*5];
        WeakReference<Object> a2 = new WeakReference<Object>(str);
        str=null;
        System.out.println("创建第2个对象");
        Thread.sleep(1000);



        str=new byte[1024*1024*5];
        WeakReference<Object> a3 = new WeakReference<Object>(str);
        str=null;
        System.out.println("创建第3个对象");
        Thread.sleep(1000);


        str=new byte[1024*1024*5];
        WeakReference<Object> a4 = new WeakReference<Object>(str);
        str=null;
        System.out.println("创建第4个对象");
        Thread.sleep(1000);


        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
    }
}