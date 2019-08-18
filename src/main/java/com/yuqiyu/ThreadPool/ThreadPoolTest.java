package com.yuqiyu.ThreadPool;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/7/5
 * 公司：北京活力天汇<br>
 **/
public class ThreadPoolTest {

    @Test
    public void execute() throws InterruptedException {
        System.out.println("1.线程数<corePoolSize,直接从线程池取一个线程，corePool相当于是正式工；");
        System.out.println("2.线程数>corePoolSize,进入BlockingQueue队列；");
        System.out.println("3.线程数>corePoolSize + BlockQueue,从maximumPool里继续取，maximumPool相当于是临时工；");
        System.out.println("4.线程数>maximumPoolSize + BlockingQueue,AbortPolicy报错rejectedExecution");
        System.out.println("5.如果临时工有keepAliveTime没有任何任务做的话，线程池会辞退该临时工，一直辞退到池数量=corePoolSize时停止");
        System.out.println("6.DefaultThreadFactory 命名 pool-1-thread-5 , 非守护线程");


        ExecutorService es = new ThreadPoolExecutor(3,5,10,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        ExecutorService linkedBlockingService= new ThreadPoolExecutor(3,3,10,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        CountDownLatch cdl = new CountDownLatch(30);
        for(int i=0;i<15;i++){
            linkedBlockingService.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cdl.countDown();
                System.out.println("linkedBlockingService  == "+ Thread.currentThread().getName()+",active count:"+
                        +((ThreadPoolExecutor) linkedBlockingService).getActiveCount()+",queue remain capacity:"+   ((ThreadPoolExecutor) linkedBlockingService).getQueue().remainingCapacity());
            });

          /*  es.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cdl.countDown();
                System.out.println("es1  == "+ Thread.currentThread().getName()+",active count:"+
                        +((ThreadPoolExecutor) es).getActiveCount()+",queue remain capacity:"+   ((ThreadPoolExecutor) es).getQueue().remainingCapacity());
            });*/
        }
        cdl.await();
        System.out.println("结束");

    }


    @Test
    public void submit() throws ExecutionException, InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(2,2,10,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("beforeExecute thread:"+t.getName());
                super.beforeExecute(t, r);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                try {
                    FutureTask ft = (FutureTask)r;
                    Integer i = (Integer) ft.get();
                    System.out.println("afterExecute result:"+i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                super.afterExecute(r, t);
            }
        };
        AtomicInteger ai = new AtomicInteger(0);

        System.out.println("submit()有三个方法，主要用于返回值");
        System.out.println("1.FutureTask(Callable c)   execute(Runnable futureTask)");
        System.out.println("2.es.runWorker() ->  futureTask.run()  ->  callable.call()");
        Future<Integer> future = es.submit(()->{
            Thread.sleep(1000);
            int a = ai.getAndIncrement();
            System.out.println("call() 计算结果:"+a);
            return a;
        });

        System.out.println("结束="+future.get());
    }


    @Test
    public void scheduleThreadPool() throws ExecutionException, InterruptedException {
        ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(1);
        CountDownLatch cdl = new CountDownLatch(1);
        // 延时执行一次任务，可执行runnable 或者 callable
        ScheduledFuture<String> sf =  schedule.schedule(()->{
            System.out.println("执行schedule方法");
            return "abc";
        },3,TimeUnit.SECONDS);

        System.out.println("获取结果："+ sf.get());


        // 第一次延时 initialDelay 执行任务，后面每隔 period 执行一次任务,不管上个任务执行完没有
    /*    schedule.scheduleAtFixedRate(()->{
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行scheduleAtFixedRate方法");
        },0,1,TimeUnit.SECONDS);
*/

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 和scheduleAtFixedRate不一样，必须得上个任务做完了才会延时 delay 秒后，再执行下个任务
        // 如果有异常，是不会继续进行下去的，且不会打印错误日志
        schedule.scheduleWithFixedDelay(()->{
            System.out.println("start:"+sdf.format(new Date()));
            try {
                Thread.sleep(-10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("执行 scheduleWithFixedDelay 方法,时间为："+sdf.format(new Date()));
        },0,1,TimeUnit.SECONDS);



        cdl.await();


    }

    class MyWorker implements Callable<Integer>{

        int c=0;

        public MyWorker(int c){
            this.c =c;
        }


        @Override
        public Integer call() throws Exception {
            c++;
            Thread.sleep(c*1000);
            System.out.println("休眠"+c+"秒");
            return c;
        }
    }


    @Test
    public void completeService() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        AtomicInteger ai = new AtomicInteger(10);
        ExecutorService pool = Executors.newFixedThreadPool(8);
        BlockingQueue<Future<Integer>> queue = new LinkedBlockingQueue(16);
        CompletionService<Integer> cService = new ExecutorCompletionService<Integer>(pool);

        for(int i=0;i<16;i++){
            Future f = cService.submit(new MyWorker(15-i));
            queue.add(f);
        }
        // 146 -- 24
       /* for(int i=0;i<16;i++){
            // 谁先完成谁先get到结果，类似微信抢红包
            int sleepTime =cService.take().get();
            ai.addAndGet(sleepTime);
        }

        System.out.println("take sleep time:"+ai+"s");
        System.out.println("spend time:"+ (int)(System.currentTimeMillis()-start)/1000);
*/

        // 146 --24
        for(int i=0;i<16;i++){
            // 按照提交任务顺序来拿结果
            int sleepTime =queue.take().get();
            ai.addAndGet(sleepTime);
        }
        // 146  --  24
        System.out.println("take sleep time:"+ai+"s");
        System.out.println("spend time:"+ (int)(System.currentTimeMillis()-start)/1000);


    }

}
