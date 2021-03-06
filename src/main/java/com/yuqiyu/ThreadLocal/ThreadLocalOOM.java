package com.yuqiyu.ThreadLocal;

import java.util.concurrent.Executors;
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
public class ThreadLocalOOM {
    private static final int TASK_POOL_SIZE=500;


    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,5,1, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
    final static ThreadLocal<Object> tl = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<TASK_POOL_SIZE;++i){
            poolExecutor.execute(()->{
                tl.set(new byte[1024*1024*5]);
                System.out.println(Thread.currentThread().getName()+" use local variable");
                //tl.remove();
            });
            Thread.sleep(100);
        }
        System.out.println("over");
    }

}
