package com.yuqiyu.jvm;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/6/11
 * 公司：北京活力天汇<br>
 **/
public class DirectOOM {

    /**
     * -XX:MaxDirectMemorySize=100m
     * java.lang.OutOfMemoryError: Direct buffer memory
     */
    @Test
    public void testGCDirectOOM(){
        // 直接从本地缓冲区分配内存，不在java堆中，不能被回收器回收
        ByteBuffer buffer = ByteBuffer.allocateDirect(120*1024*1024);
    }
}
