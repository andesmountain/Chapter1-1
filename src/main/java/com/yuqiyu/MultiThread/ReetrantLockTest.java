package com.yuqiyu.MultiThread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockTest {
    public static  Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            Thread t= new Thread(()->{
                // 有线程占有锁的话，其余线程进行等待
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" get lock");
                try {
                    // 不会释放锁
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" release lock");
                lock.unlock();
            });
            t.start();
        }

    }

}
