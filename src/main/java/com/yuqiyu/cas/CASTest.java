package com.yuqiyu.cas;

import lombok.Data;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/5/23
 * 公司：北京活力天汇<br>
 **/
public class CASTest {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(10);
        System.out.println(ai.compareAndSet(8,20));
        // getAndSet 是采用死循环的方式更新新值
        System.out.println(ai.getAndSet(30));
        System.out.println(ai.get());
    }

    @Test
    public void testArray(){
        int[] value = new int[]{1,2};
        AtomicIntegerArray arr = new AtomicIntegerArray(value);
        // 修改第几项元素值
        arr.getAndSet(0,5);
        System.out.println(arr);
        System.out.println(value[0]);
    }


    @Data
    static class UserInfo{
        String name;
        int age;
        public UserInfo(String name,int age){
            this.name= name;
            this.age = age;
        }
    }


    @Test
    public void userAtomicReference(){
        UserInfo ui = new UserInfo("zhu",29);
        AtomicReference<UserInfo> ar = new AtomicReference<>(ui);
        UserInfo updateUser = new UserInfo("yin",28);
        ar.compareAndSet(ui,updateUser);

        System.out.println("替换后"+ar.get());
        System.out.println("替换前"+ui);

    }


    @Test
    public void testAtomicStampedReference() throws InterruptedException {
        AtomicStampedReference<String> asr = new AtomicStampedReference("abc",1);
        Thread t1 = new Thread(()->{
            System.out.println("t1 开始运行");
            System.out.println(asr.getReference()+":"+asr.getStamp());
            System.out.println("执行结果"+asr.compareAndSet("abc","lol",1,2));
        });
        t1.start();
        t1.join();
        Thread t2 = new Thread(()->{
            System.out.println("t2 开始执行");
            System.out.println(asr.getReference()+":"+asr.getStamp());
            System.out.println("执行结果"+asr.compareAndSet("lol","abc",0,1));
        });
        t2.start();


    }

}
