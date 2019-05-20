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
    public static void main(String[] args) {
        Object[] arr = new Object[8];
        for(int i=0;i<8;i++){
            System.out.println("set第"+(i+1)+"个对象");
            ThreadLocal<byte[]> tl = new ThreadLocal<>();
            tl.set(new byte[1024*1024*5]);
            // arr[i]=tl;
            //System.gc();
        }
    }
}
