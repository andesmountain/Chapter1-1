package com.yuqiyu.future;


import java.util.concurrent.*;

public class UserFuture {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask ft = new FutureTask<>(
                new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        int sum = 0;
                        System.out.println("Callable 计算开始");
                        for (int i = 0; i < 5000; i++) {
                            sum += i;
                            // System.out.println(sum);

                            // 如果interrupt,sleep会报错，直接throws Exception，但这并不是interrupt使程序中断的
                            // Thread.sleep(1);
                            System.out.println("sum=" + sum);
                            if (Thread.currentThread().isInterrupted()) {
                                System.out.println("Callable interrupt");
                            }
                        }
                        System.out.println("Callable 计算完成：" + sum);
                        return sum;
                    }
                });
        Thread t = new Thread(ft);
        t.start();
        Thread.sleep(10);


        // t.interrupt();

        ft.cancel(true);
        // System.out.println(ft.get());


        Thread t1 = new Thread(() -> {
            int sum = 0;
            System.out.println("runnable 计算开始");
            for (int i = 0; i < 5000; i++) {
                sum += i;
                // System.out.println(sum);

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("runnable interrupt");
                }
            }
            System.out.println("runnable 计算完成：" + sum);
        });

        t1.start();
        Thread.sleep(1);
        // 针对 runnable 而言，interrupt 只是作为标识，并没有真正停止线程
        //t1.interrupt();


        ExecutorService es = Executors.newCachedThreadPool();
        Future<Integer> future = es.submit(() -> {
            int sum = 0;
            for (int i = 0; i < 5000; i++) {
                sum += i;
            }
            return sum;
        });
        es.shutdown();
        System.out.println(future.get());

    }

}
