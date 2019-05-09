package com.yuqiyu.ThreadLocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * ThreadLocalMap key存储Threadlocal对象，一直有引用无法被回收，可能会造成内存泄漏
 * threadLocal.set(value) 相当于CurrentThread -> ThreadLocalMap -> (threadLocal,value)
 * @author dell
 * @date 2019/4/28
 * 公司：北京活力天汇<br>
 **/
public class ThreadLocalOOM2 extends Thread {
    private static final int TASK_POOL_SIZE=500;


     static ThreadLocal<Object> tl1 = new ThreadLocal<>();
     static ThreadLocal<Object> tl2 = new ThreadLocal<>();
    static ThreadLocal<Object> tl3 = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        System.out.println("tl1.set,并重置为null");
        tl1.set(new byte[1024*1024*5]);
        tl1=null;
        Thread.sleep(5000);

        System.out.println("tl2.set");
        tl2.set(new byte[1024*1024*5]);
        tl2=null;
        Thread.sleep(5000);

        System.out.println("tl3.set ");
        tl3.set(new byte[1024*1024*5]);
        Thread.sleep(1000);

        System.out.println(tl1);
        System.out.println(tl2);
        System.out.println(tl3);
    }

}
