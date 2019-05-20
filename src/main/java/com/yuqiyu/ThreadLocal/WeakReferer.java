package com.yuqiyu.ThreadLocal;

import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WeakReferer {
    public static void main(String[] args) throws InterruptedException {
        Object[] arr= new Object[5];
        for(int i=0;i<5;i++){
            Object str=new byte[1024*1024*5];
            WeakReference<Object> ref = new WeakReference<Object>(str);
            arr[i] =ref;
            System.out.println("创建第"+(i+1)+"个对象");
        }
        System.out.println(arr);
    }
}