package com.yuqiyu.cas;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/5/29
 * 公司：北京活力天汇<br>
 **/
public class ReetrantSelfLock implements Lock {

    private final Sync sync;

    public ReetrantSelfLock() {
        sync = new Sync();
    }

    static class Sync   extends AbstractQueuedSynchronizer{
        protected void lock() {
            if (compareAndSetState(0, 1))
                setExclusiveOwnerThread(Thread.currentThread());
            else
                acquire(1);
        }

        @Override
        protected boolean tryAcquire(int arg) {
            if(getExclusiveOwnerThread()==Thread.currentThread()){
                compareAndSetState(getState(),getState()+arg);
            }
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(Thread.currentThread()== getExclusiveOwnerThread()) {
                if (getState() == 0) {
                    throw new IllegalMonitorStateException();
                }
                int c=getState()-arg;
                setState(c);
                if(c==0) {
                    // 只有拿到锁的才会释放，所以不存在多线程安全问题
                    setExclusiveOwnerThread(null);
                    return true;
                }
            }
            return false;
        }

        protected ConditionObject newCondition(){
            return new ConditionObject();
        }
    }


    @Override
    public void lock() {
        sync.lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return  sync.newCondition();
    }
}
