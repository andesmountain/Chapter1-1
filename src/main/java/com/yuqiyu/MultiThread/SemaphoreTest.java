package com.yuqiyu.MultiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/5/22
 * 公司：北京活力天汇<br>
 **/
public class SemaphoreTest {

    public static Semaphore sem = new Semaphore(2);


    public static void main(String[] args) {
        for(int i=0;i<6;i++){
            Thread t = new Thread(()->{
                try {
                    // 没有拿到许可证就阻塞
                    sem.acquire();
                    System.out.println(Thread.currentThread().getName()+" acquired");
                    Thread.sleep(1000);
                    sem.release();
                    System.out.println(Thread.currentThread().getName()+" released,remain "+sem.availablePermits());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }


}
