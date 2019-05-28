package com.yuqiyu.MultiThread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockTest {
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            try {
                // 不会释放锁
                // 有线程占有锁的话，其余线程进行等待
                lock.lock();
                System.out.println("t1 get lock");
                Thread.sleep(5000);
                String a = null;
                a.equals("");
                System.out.println("t1 release lock");
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });
        t1.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(() -> {
            // 有线程占有锁的话，其余线程进行等待
            lock.lock();
            System.out.println( "t2 get lock");
            try {
                // 不会释放锁
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 release lock");
            lock.unlock();
        });
        t2.start();



        Thread t3 = new Thread(() -> {
            // 有线程占有锁的话，其余线程进行等待
            lock.lock();
            System.out.println(  "t3 get lock");
            try {
                // 不会释放锁
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( "t3 release lock");
            lock.unlock();
        });
        t3.start();


        Thread t4 = new Thread(() -> {
            // 有线程占有锁的话，其余线程进行等待
            lock.lock();
            System.out.println(  "t4 get lock");
            try {
                // 不会释放锁
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( "t4 release lock");
            lock.unlock();
        });
        t4.start();
    }

}
