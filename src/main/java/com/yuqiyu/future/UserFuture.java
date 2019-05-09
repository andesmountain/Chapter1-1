package com.yuqiyu.future;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UserFuture   {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask ft = new FutureTask<>(()->{
            int sum = 0;
            for(int i=0;i<5000;i++){
                sum += i;
                System.out.println(sum);
            }
            return sum;
        });
        Thread t = new Thread(ft);
        t.start();
        System.out.println(ft.get());

    }

}
