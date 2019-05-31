package com.yuqiyu.cas;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/5/23
 * 公司：北京活力天汇<br>
 **/
public class CASTest {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(10);
        System.out.println(ai.compareAndSet(8, 20));
        // getAndSet 是采用死循环的方式更新新值
        System.out.println(ai.getAndSet(30));
        System.out.println(ai.get());
    }

    @Test
    public void testArray() {
        int[] value = new int[]{1, 2};
        AtomicIntegerArray arr = new AtomicIntegerArray(value);
        // 修改第几项元素值，同时会改动原数组的值
        arr.getAndSet(0, 5);
        System.out.println(arr);
        System.out.println(value[0]);
    }


    @Data
    static class UserInfo {
        String name;
        int age;

        public UserInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    @Test
    public void userAtomicReference() {
        UserInfo ui = new UserInfo("zhu", 29);
        AtomicReference<UserInfo> ar = new AtomicReference<>(ui);
        UserInfo updateUser = new UserInfo("yin", 28);
        ar.compareAndSet(ui, updateUser);

        System.out.println("替换后" + ar.get());
        System.out.println("替换前" + ui);

    }


    /**
     * 带版本号，解决ABA问题
     *
     * @throws InterruptedException
     */
    @Test
    public void testAtomicStampedReference() throws InterruptedException {
        AtomicStampedReference<String> asr = new AtomicStampedReference("abc", 1);
        Thread t1 = new Thread(() -> {
            System.out.println("t1 开始运行");
            System.out.println(asr.getReference() + ":" + asr.getStamp());
            System.out.println("执行结果" + asr.compareAndSet("abc", "lol", 1, 2));
        });
        t1.start();
        t1.join();
        Thread t2 = new Thread(() -> {
            System.out.println("t2 开始执行");
            System.out.println(asr.getReference() + ":" + asr.getStamp());
            System.out.println("执行结果" + asr.compareAndSet("lol", "abc", 0, 1));
        });
        t2.start();


    }


    @Test
    public void testMultiLock() throws InterruptedException {
        Lock lock = new ReentrantLock();
        for(int i=0;i<3;i++){
            Thread t =new Thread(()->{
                System.out.println(Thread.currentThread()+"get lock");
                lock.lock();
            });
            t.start();
            Thread.sleep(10);
        }
        Thread.sleep(10);
        System.out.println("=== main get lock===");
        System.out.println("compareAndSetState(0, 1)  失败，进入acquire方法");
        System.out.println("addWaiter(Node.EXCLUSIVE)   新建Node new Node(Thread.currentThread(), mode)，并插入到tail后 ");
        System.out.println("acquireQueued   如果前置节点是head且能获取到锁，则设置本节点为head；否则执行 shouldParkAfterFailedAcquire");
        System.out.println("shouldParkAfterFailedAcquire   设置pred前置节点waitStatus=-1,表示pred后的节点进入等待队列，随时准备被唤醒");
        System.out.println("LockSupport.park(this)");
        lock.lock();
    }


    @Test
    public void testUnLock() throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(()->{
            System.out.println(Thread.currentThread()+"get lock");
            lock.lock();
            System.out.println(Thread.currentThread()+"被唤醒");
        });
        es.submit(()->{
            System.out.println(Thread.currentThread()+"get lock");
            lock.lock();
            System.out.println(Thread.currentThread()+"被唤醒");
        });

        Thread.sleep(10);

        System.out.println("unlock");
        System.out.println("CLH队列保证排在前面的Node比后面的Node先获取到锁，FIFO");
        System.out.println("非公平锁：老的线程排队使用锁；但是无法保证新线程抢占已经在排队的线程的锁。");
        System.out.println("公平锁：老的线程排队使用锁，新线程仍然排队使用锁。");
        lock.unlock();
        es.awaitTermination(10000000, TimeUnit.MINUTES);
    }


    @Test
    public void testCondition() throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition cond = lock.newCondition();
        Thread t1 = new Thread(() -> {

            lock.lock();
            System.out.println("1.lock.lock()  ");
            System.out.println("没有锁的话，只会设置 setExclusiveOwnerThread setState");

            try {
                System.out.println("2.cond.await()");
                System.out.println("addConditionWaiter  firstWaiter = lastWaiter (nextWaiter=null,waitStatus=-2,thread=Thread[Thread-1,5,main])");
                System.out.println("fullyRelease   setState(0)  setExclusiveOwnerThread(null)  head=tail=null");
                System.out.println("isOnSyncQueue(node)=false   LockSupport.park(this)   跳出线程并阻塞");
                cond.await();
                System.out.println("5." + Thread.currentThread() + " 被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });
        t1.start();

        Thread.sleep(10);
        lock.lock();
        cond.signal();
        System.out.println("3.cond.signal ");
        System.out.println("从firstWaiter往后，将condition队列中的node enq 到lock队列中");
        System.out.println("lock  head: waitStatus=-1(SIGNAL，值为-1，表示当前节点的后继节点包含的线程需要运行，也就是unpark),thread=null   tail:waitStatus=0,thread=Thread[Thread-1,5,main]");
        System.out.println("condition  firstWaiter=lastWaiter=null");

        System.out.println("4. lock.unlock()");
        System.out.println("tryRelease(arg)  判断 Thread.currentThread() == getExclusiveOwnerThread()   getState()-arg==0");
        System.out.println("若满足上面条件，表示锁已释放，唤醒等待队列上的锁  h=head: waitStatus=-1   ");
        System.out.println("unparkSuccessor(h)   s=head.next=tail(waitStatus=0,thread=Thread[Thread-1,5,main]) !=null  LockSupport.unpark(s.thread)");
        lock.unlock();


        t1.join();

    }


    @Test
    public void testCountDownLatch() {
        CountDownLatch cdl = new CountDownLatch(2);
        System.out.println("初始化 state=2");
        Thread t = new Thread(() -> {
            System.out.println("====countDown====");
            System.out.println("共享模式，无需先获取到锁，直接判断state值大小");
            System.out.println("getState()-1==0?  return true(LockSupport.unPark 唤醒await):return false");
            cdl.countDown();
        });
        t.start();

        try {
            cdl.countDown();
            System.out.println("====await====");
            System.out.println("tryAcquireShared   getState()==0?放行:LockSupport.park");
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
