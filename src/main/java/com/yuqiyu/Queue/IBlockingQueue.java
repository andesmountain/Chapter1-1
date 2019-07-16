package com.yuqiyu.Queue;

import java.util.concurrent.TimeUnit;

public interface IBlockingQueue<E> {

    void put(E e) throws InterruptedException;

    E take() throws InterruptedException;

    E poll(long timeout, TimeUnit unit)
            throws InterruptedException;

}
