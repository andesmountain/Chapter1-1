package com.yuqiyu.Queue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BqConditionImpl<E> implements IBlockingQueue<E>{

    private final ReentrantLock lock ;
    private final Condition notEmpty;
    private final Condition notFull;

    private final int size;
    private Object[] items;
    // 目前队列存储数据的数量
    private int count;

    private int takeIndex;
    private int putIndex;

    public BqConditionImpl(int size){
        lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
        items = new Object[size];
        this.size = size;
    }

    private void enqueue(E e){
        items[putIndex] =e;
        if(putIndex<size-1){
            putIndex++;
        }else{
            putIndex = 0;
        }
        count++;
        notEmpty.signalAll();
    }


    @Override
    public void put(E e) throws InterruptedException {
        try{
            lock.lockInterruptibly();
            if(count<size){
                enqueue(e);
            }else{
                notFull.await();
                enqueue(e);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private E dequeue(){
        E e = (E)items[takeIndex];
        items[takeIndex]=null;
        if(takeIndex<size-1){
            takeIndex++;
        }else{
            takeIndex = 0;
        }
        count--;
        notFull.signalAll();
        return e;
    }

    /**
     * 阻塞获取
     * @return
     */
    @Override
    public E take() {
        try {
            lock.lockInterruptibly();
            if(count>0){
                return dequeue();
            }else{
                notEmpty.await();
                // 取出来
                return dequeue();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }
}
