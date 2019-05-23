package com.yuqiyu.cas;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

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
        System.out.println(ai.compareAndSet(10,20));
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


}
