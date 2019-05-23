package com.yuqiyu.MultiThread;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;


/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/5/22
 * 公司：北京活力天汇<br>
 **/
public class CyclicBarrierTest {

    public static Map<String,Integer> result = new ConcurrentHashMap<>();

    public static CyclicBarrier barrier = new CyclicBarrier(4,()->{
        System.out.println("汇总任务启动");
        int rs = 0;
        for(Map.Entry<String,Integer> entry:result.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
            rs += entry.getValue();
        }
        System.out.println("rs="+rs);
    });



    public static void main(String[] args) {
        for(int i=0;i<4;i++){
            Thread t = new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"启动");
                try {
                    Random random = new Random();

                    result.put(Thread.currentThread().getName(),random.nextInt(10));
                    barrier.await();
                    System.out.println(Thread.currentThread().getName()+"唤醒后继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            t.start();
            try {
                Thread.sleep(2000);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
