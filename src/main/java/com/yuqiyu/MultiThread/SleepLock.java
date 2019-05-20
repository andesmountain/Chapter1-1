package com.yuqiyu.MultiThread;

/**
 * sleep 使程序由运行状态转变到阻塞状态，但不会释放锁
 */
public class SleepLock {
    private Object lock = new Object();


    public static void main(String[] args) {
        SleepLock sl = new SleepLock();
        Thread ts =  sl.new ThreadSleep();
        ts.start();
        try {
            System.out.println("Main Thread sleep");
            Thread.sleep(2000);
            System.out.println("Main Thread wake");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread tns = sl.new ThreadNoSleep();
        tns.start();

    }

    private class ThreadSleep extends Thread{
        @Override
        public void run() {
            synchronized (lock){
                try {
                    System.out.println("ThreadSleep get lock");
                    Thread.sleep(5000);
                    System.out.println("ThreadSleep release lock");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    private class ThreadNoSleep extends Thread{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println("ThreadNoSleep get lock");
            }
        }
    }
}
