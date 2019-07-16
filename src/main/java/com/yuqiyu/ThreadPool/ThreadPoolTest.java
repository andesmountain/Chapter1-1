package com.yuqiyu.ThreadPool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    @Test
    public void test1(){
        ExecutorService es = new ThreadPoolExecutor(3,5,20,
                TimeUnit.SECONDS,new ArrayBlockingQueue(10));
        for(int i=0;i<20;i++){
            es.execute(()->{
                System.out.println("==="+Thread.currentThread().getName()+"===");
            });
        }

        Thread.yield();


    }
}
