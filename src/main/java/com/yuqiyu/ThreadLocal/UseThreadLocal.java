package com.yuqiyu.ThreadLocal;

import java.util.Arrays;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/4/22
 * 公司：北京活力天汇<br>
 **/
public class UseThreadLocal {

    static Integer count = new Integer(1);
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    private static  ThreadLocal<String> threadLocalS  = new ThreadLocal<>();

    private void start() {
        Thread[] arr = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread a = new Thread(new ThreadA(i));
            arr[i] = a;
        }

        for (int j = 10; j > 0; j--) {
            arr[j - 1].start();
        }
    }

    static class ThreadA implements Runnable {
        int id = 0;

        public ThreadA(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            threadLocal.set(threadLocal.get() + id);
            threadLocalS.set("abc");
            System.out.println(Thread.currentThread().getName() + " threadLocal " + threadLocal.get());
            count = count + id;
            System.out.println(Thread.currentThread().getName() + " count " + count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThreadLocal utl = new UseThreadLocal();
        utl.start();

    }

}
