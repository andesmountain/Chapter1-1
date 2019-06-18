package com.yuqiyu.map;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * putIfAbsent  返回先前的value值，只有当oldValue == null时，才会插入新值
 * put 不能为空
 *
 * @author dell
 * @date 2019/6/12
 * 公司：北京活力天汇<br>
 **/
public class ConcurrentMapTest {

    @Test
    public void testPutIfAbsent(){
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        System.out.println(map.put("abc","000"));

        System.out.println("putIfAbsent {abc:111}");
        System.out.println("返回值："+map.putIfAbsent("abc","111"));

        System.out.println("get abc");
        // 返回的还是000   putIfAbsent当value！=null时，不会覆盖原有值，只会返回oldValue
        System.out.println("返回值："+map.get("abc"));


        System.out.println("putIfAbsent {abc:555}");
        System.out.println("返回值："+map.putIfAbsent("abc","555"));



        map.get("abc");


        System.out.println("putIfAbsent {abc:null}");
        System.out.println("返回值："+map.putIfAbsent("abc",null));
    }
}
