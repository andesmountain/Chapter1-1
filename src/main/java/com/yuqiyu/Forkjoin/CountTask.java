package com.yuqiyu.Forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/5/20
 * 公司：北京活力天汇<br>
 **/
public class CountTask extends RecursiveTask<Integer> {

    private static final long serialVersionUID = -3611254198265061729L;

    public static final int threshold = 2;
    private int start;
    private int end;

    public CountTask(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute()
    {
        int sum = 0;

        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= threshold;
        if(canCompute)
        {
            for (int i=start; i<=end; i++)
            {
                sum += i;
            }
        }
        else
        {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end)/2;
            System.out.println(middle);
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle+1, end);

            // 执行子任务
            leftTask.fork(); //拆分，并压入线程队列
            rightTask.fork(); //拆分，并压入线程队列


            //等待任务执行结束合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //合并子任务
            sum = leftResult + rightResult;

        }

        return sum;
    }

    public static void main(String[] args)
    {
        ForkJoinPool forkjoinPool = new ForkJoinPool();

        //生成一个计算任务，计算1+2+3+4
        CountTask task = new CountTask(1, 100);

        //执行一个任务 submit 分布执行   invoke同步执行   execute 无返回结果
        // Future<Integer> result = forkjoinPool.invoke(task);

        Integer result = forkjoinPool.invoke(task);
        System.out.println("end");
        try
        {
            System.out.println(result);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
