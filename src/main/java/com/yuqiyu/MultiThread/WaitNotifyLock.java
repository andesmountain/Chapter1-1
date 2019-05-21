package com.yuqiyu.MultiThread;

import java.util.concurrent.CountDownLatch;

/**
 * wait notifyAll  必须在synchronized中执行
 * wait会释放锁
 * 可以作为观察者模式
 */
public class WaitNotifyLock {
    private Object lock = new Object();


    public static void main(String[] args) {
        WaitNotifyLock sl = new WaitNotifyLock();
        Thread a =  sl.new ThreadWait();
        Thread b =  sl.new ThreadWait2();

        try {
            a.start();
            b.start();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread tns = sl.new ThreadNotify();
        tns.start();

    }

    private class ThreadWait extends Thread{
        @Override
        public void run() {

            synchronized (lock){
                try {
                    System.out.println("a get the lock");
                    System.out.println("a start wait");
                    lock.wait();
                    System.out.println("a wake up");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private class ThreadWait2 extends Thread{
        @Override
        public void run() {
            synchronized (lock){
                try {
                    System.out.println("B get the lock");
                    System.out.println("B start wait");
                    lock.wait();
                    System.out.println("B wake up");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private class ThreadNotify extends Thread{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println("ThreadNotify get the lock and  notify all");
                lock.notifyAll();
            }
        }
    }
}
