package com.yuqiyu.Queue;

public class TestQueue {
    public static void main(String[] args) throws InterruptedException {
        IBlockingQueue<String> bq =new BqConditionImpl<>(10);
        for(int i=0;i<10;i++){
            bq.put("a");
        }

        Thread t= new Thread(()->{
            try {
                Thread.sleep(100);
                String o = bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();

        bq.put("b");
        System.out.println("put成功");


    }
}
