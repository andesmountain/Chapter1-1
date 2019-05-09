package com.yuqiyu.interrupt;

public class EndThread {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new UserThread("abc");
        a.start();

        System.out.println("启动线程");
        Thread.sleep(2000);
        //a.stop();
        a.interrupt();
    }

    private static class UserThread extends Thread{
        public UserThread(String name){
            super(name);
        }

        @Override
        public void run() {
            while(!isInterrupted()) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is running");
                // interrupt(); // 仅仅只是做个标识   可以用isInterrupted判断
            }
            System.out.println("Thread "+ Thread.currentThread().getName() +" is interrupted");
        }
    }
}
