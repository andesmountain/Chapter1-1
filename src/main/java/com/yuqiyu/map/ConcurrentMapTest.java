package com.yuqiyu.map;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/6/12
 * 公司：北京活力天汇<br>
 **/
public class ConcurrentMapTest {

    @Test
    public void testPutIfAbsent(){
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        System.out.println("put {abc:123}");
        System.out.println("返回值："+map.putIfAbsent("abc","123"));

        System.out.println("put {abc:555}");
        System.out.println("返回值："+map.putIfAbsent("abc","555"));


        System.out.println("put {abc:null}");
        System.out.println("返回值："+map.putIfAbsent("abc",null));
    }
}
