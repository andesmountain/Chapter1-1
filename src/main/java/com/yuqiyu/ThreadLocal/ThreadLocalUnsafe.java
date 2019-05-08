package com.yuqiyu.ThreadLocal;

import java.util.Arrays;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/4/28
 * 公司：北京活力天汇<br>
 **/
public class ThreadLocalUnsafe implements Runnable {
    private static Number num =  new Number(0);

    private static ThreadLocal<Number> tl = new ThreadLocal<Number>(){
        @Override
        protected Number initialValue() {
            return new Number(0);
        }
    };

    public static void main(String[] args) {
        Thread[] arr = new Thread[5];
        for(int i=0;i<5;i++){
            Thread t = new Thread(new ThreadLocalUnsafe());
            arr[i] = t;
        }
        System.out.println("==============");
        Arrays.stream(arr).forEach(a->{a.start();});
    }

    @Override
    public void run() {
        num.setNum(num.getNum()+1);
        tl.set(num);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+ num.getNum());
    }


    private static class Number{
        int num;
        public Number(int num){
            this.num = num;
        }

        public void setNum(int num){
            this.num = num;
        }

        public int getNum(){
            return this.num;
        }

    }

}
