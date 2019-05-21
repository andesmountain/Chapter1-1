package com.yuqiyu.MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static Lock lock = new ReentrantLock();

    public static Condition cond = lock.newCondition();

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            Thread t= new Thread(()->{
                // 有线程占有锁的话，其余线程进行等待
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" get lock");
                try {
                    // 不会释放锁
                    Thread.sleep(2000);
                    // 必须先获得锁，才能await
                    // 当前线程进入等待，同时释放锁，notify后继续从此处开始执行
                    cond.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
                System.out.println(Thread.currentThread().getName()+" 继续执行");
            });
            t.start();
        }
        try {
            Thread.sleep(8000);
            lock.lock();
            // 也必须先获取锁，才能唤醒其他锁
            System.out.println("唤醒所有condition");
            cond.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 必须释放锁，其他被唤醒的线程才能获取锁
            lock.unlock();
        }

    }
}
