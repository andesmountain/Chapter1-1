package com.yuqiyu.cas;

import lombok.Data;
import org.junit.jupiter.api.Test;

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
        System.out.println(ai.compareAndSet(8,20));
        // getAndSet 是采用死循环的方式更新新值
        System.out.println(ai.getAndSet(30));
        System.out.println(ai.get());
    }

    @Test
    public void testArray(){
        int[] value = new int[]{1,2};
        AtomicIntegerArray arr = new AtomicIntegerArray(value);
        // 修改第几项元素值，同时会改动原数组的值
        arr.getAndSet(0,5);
        System.out.println(arr);
        System.out.println(value[0]);
    }


    @Data
    static class UserInfo{
        String name;
        int age;
        public UserInfo(String name,int age){
            this.name= name;
            this.age = age;
        }
    }


    @Test
    public void userAtomicReference(){
        UserInfo ui = new UserInfo("zhu",29);
        AtomicReference<UserInfo> ar = new AtomicReference<>(ui);
        UserInfo updateUser = new UserInfo("yin",28);
        ar.compareAndSet(ui,updateUser);

        System.out.println("替换后"+ar.get());
        System.out.println("替换前"+ui);

    }


    /**
     * 带版本号，解决ABA问题
     * @throws InterruptedException
     */
    @Test
    public void testAtomicStampedReference() throws InterruptedException {
        AtomicStampedReference<String> asr = new AtomicStampedReference("abc",1);
        Thread t1 = new Thread(()->{
            System.out.println("t1 开始运行");
            System.out.println(asr.getReference()+":"+asr.getStamp());
            System.out.println("执行结果"+asr.compareAndSet("abc","lol",1,2));
        });
        t1.start();
        t1.join();
        Thread t2 = new Thread(()->{
            System.out.println("t2 开始执行");
            System.out.println(asr.getReference()+":"+asr.getStamp());
            System.out.println("执行结果"+asr.compareAndSet("lol","abc",0,1));
        });
        t2.start();


    }

    @Test
    public void testReetrantLock() throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition cond =  lock.newCondition();
        Thread t1=new Thread(()->{

            lock.lock();
            System.out.println("1.lock.lock()  ");
            System.out.println("没有锁的话，只会设置 setExclusiveOwnerThread setState");

            try {
                System.out.println("2.cond.await()");
                System.out.println("addConditionWaiter  firstWaiter = lastWaiter  nextWaiter=null,waitStatus=-2,thread=Thread[Thread-1,5,main]");
                System.out.println("fullyRelease   setState(0)  setExclusiveOwnerThread(null)  head=tail=null");
                System.out.println("isOnSyncQueue(node)=false   LockSupport.park(this)   跳出线程并阻塞");
                cond.await();
                System.out.println("5."+Thread.currentThread()+" 被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        });
        t1.start();

        Thread.sleep(10);
        lock.lock();
        cond.signal();
        System.out.println("3.cond.signal ");
        System.out.println("从firstWaiter往后，将condition队列中的node enq 到lock队列中");
        System.out.println("lock  head: waitStatus=-1,thread=null   tail:waitStatus=0,thread=Thread[Thread-1,5,main]");
        System.out.println("condition  firstWaiter=lastWaiter=null");
        lock.unlock();
        System.out.println("4. lock.unlock()");
        System.out.println("tryRelease(1)  h=head: waitStatus=-1   ");
        System.out.println("unparkSuccessor(h)   s=head.next=lastWaiter!=null  LockSupport.unpark(s.thread)");

        t1.join();

    }

}
