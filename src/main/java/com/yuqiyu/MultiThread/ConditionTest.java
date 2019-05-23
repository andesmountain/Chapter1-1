package com.yuqiyu.MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/5/22
 * 公司：北京活力天汇<br>
 **/
public class ConditionTest {
    public static Lock lock = new ReentrantLock();
    public static Condition cond1 = lock.newCondition();
    public static Condition cond2 = lock.newCondition();

    public static void main(String[] args) {
        for(int i=0;i<3;i++) {
            Thread t1 = new Thread(() -> {
                lock.lock();

                try {
                    // 类似于object.wait()  释放锁，等待被唤醒然后继续执行
                    if(Thread.currentThread().getId()==13){
                        System.out.println(Thread.currentThread().getName() + "获得锁,cond1.await()");
                        cond1.await();
                    }else{
                        System.out.println(Thread.currentThread().getName() + "获得锁,cond2.await()");
                        cond2.await();
                    }
                    System.out.println(Thread.currentThread().getName() + "被唤醒,且带着锁休眠1s");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
            t1.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 唤醒所有线程,首先得获取锁，signal后得释放锁
        lock.lock();
        cond1.signalAll();
        System.out.println("唤醒cond1所有线程，同时释放锁");
        lock.unlock();

    }

}
