package com.yuqiyu.MultiThread;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/5/20
 * 公司：北京活力天汇<br>
 **/
public class YieldTest extends Thread {

    public static String lock = "";

    public YieldTest(String name) {
        super(name);
    }

    public void run() {
            System.out.println("" + this.getName() + "-----");
            Thread.yield();
            System.out.println("" + this.getName() + "end");
    }


    public static void main(String[] args) {
        YieldTest ta = new YieldTest("hello1");
        YieldTest tb = new YieldTest("hello2");
        ta.start();
        tb.start();
    }
}
