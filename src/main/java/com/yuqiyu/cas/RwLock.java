package com.yuqiyu.cas;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/5/28
 * 公司：北京活力天汇<br>
 **/
public class RwLock {

    @Test
    public void test1(){
        ReentrantReadWriteLock rtLock = new ReentrantReadWriteLock();
        rtLock.readLock().lock();
        System.out.println("get readLock.");
        // 读锁不释放，写锁拿不到锁，不支持锁升级
        // rtLock.readLock().unlock();
        rtLock.writeLock().lock();
        System.out.println("blocking");
    }

    @Test
    public void test2(){
        ReentrantReadWriteLock rtLock = new ReentrantReadWriteLock();
        rtLock.writeLock().lock();
        System.out.println("blocking");

        // 写锁不释放，读锁也能获取到锁，支持锁降级
        rtLock.readLock().lock();
        System.out.println("get readLock.");
    }





    @Test
    public void test3() throws InterruptedException {
        ReentrantReadWriteLock rtLock = new ReentrantReadWriteLock();
        CountDownLatch cdl = new CountDownLatch(2);
        Thread t1 = new Thread(()->{

            rtLock.readLock().lock();
            System.out.println("t1 get readLock.Sleep 3s");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rtLock.readLock().unlock();
            cdl.countDown();

        });

        Thread t2 = new Thread(()->{
            // 读锁与读锁之间非互斥锁
            rtLock.readLock().lock();
            System.out.println("读锁与读锁之间非互斥锁 \n t2 get readLock.Sleep 3s");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rtLock.readLock().unlock();
            cdl.countDown();
        });
        t1.start();
        t2.start();


        cdl.await();
        System.out.println("countdownlatch 保证t1,t2都执行完");

    }


    @Test
    public void test4() throws InterruptedException {
        ReentrantReadWriteLock rtLock = new ReentrantReadWriteLock();
        Thread t1 = new Thread(()->{
            rtLock.readLock().lock();
            System.out.println("t1 get readLock.Sleep 3s");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("t1 释放锁");
                rtLock.readLock().unlock();
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{

            rtLock.writeLock().lock();
            System.out.println("读锁与写锁之间互斥 \n t2 get writeLock.Sleep 3s");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rtLock.writeLock().unlock();
        });
        t2.start();

        // junit 主线程执行完了就默认结束
        t2.join();
    }

    final static CountDownLatch startCdl = new CountDownLatch(1);
    final static CountDownLatch endCdl = new CountDownLatch(20);
    final static ReentrantReadWriteLock rtLock = new ReentrantReadWriteLock();
    @Test
    public void test5() throws InterruptedException {

        for(int i=0;i<20;i++){
            Thread t= new Thread(new UserService(i));
            t.start();
        }

        System.out.println("并发开始");
        startCdl.countDown();

        endCdl.await();
        System.out.println("全部结束");
    }

    class UserService implements Runnable{
        int i;

        public UserService(int i){
            this.i = i;
        }

        @Override
        public void run() {
            try {
                startCdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i%3!=0){
                rtLock.readLock().lock();
                System.out.println("t"+ i + " get readLock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    rtLock.readLock().unlock();
                    endCdl.countDown();
                }
            }else{
                rtLock.writeLock().lock();
                System.out.println("t"+ i + " get writeLock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    rtLock.writeLock().unlock();
                    endCdl.countDown();
                }
            }
        }
    }


}
