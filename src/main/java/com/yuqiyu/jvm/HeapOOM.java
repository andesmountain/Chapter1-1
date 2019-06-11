package com.yuqiyu.jvm;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * -Xms30m  -Xmx30m   -XX:+PrintGCDetails
 * @author dell
 * @date 2019/6/11
 * 公司：北京活力天汇<br>
 **/
public class HeapOOM {

    /**
     * -Xms30m  -Xmx30m   -XX:+PrintGCDetails
     * java.lang.OutOfMemoryError: Java heap space
     */
    @Test
    public void testGCOOM(){
        // 堆里分配100m的数组，直接触发OOM
        String[] abc=new String[100000000];
    }





    /**
     * 报错：java.lang.OutOfMemoryError: GC overhead limit exceeded
     *
     * 超过98%的时间用来做GC并且回收了不到2%的堆内存时会抛出此异常。
     */
    @Test
    public void testGClimitExceeded() {
        int i=1;
        List<Object> list = new LinkedList<>();
        while (true){
            if(i%10000==0){
                System.out.println("加载了"+i+"条数据");
            }
            list.add(new Object());
            i++;
        }
    }
}
