package com.yuqiyu.MultiThread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    // 如果只是HashMap   多线程情况下有可能导致put数据丢失或者不准确
    public static Map<String,String> mm = new ConcurrentHashMap<>();

    public static CyclicBarrier barrier = new CyclicBarrier(2,()->{
        System.out.println("指定数量线程执行await后，调用汇总方法");
        for(Map.Entry<String,String> entry: mm.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    });


    public static void main(String[] args) {
        for(int i=0;i<4;i++){
            Thread t = new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"start");
                try {
                    mm.put(Thread.currentThread().getName(),Thread.currentThread().getId()+"");
                    // 如果还未到达barrier放开栅栏的数量，则该线程等待
                    barrier.await();
                    // 放开后继续执行
                    System.out.println(Thread.currentThread().getName() +" wake");
                    // 这里会再次等待，达到数量后触发汇总方法
                    //barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            t.start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
