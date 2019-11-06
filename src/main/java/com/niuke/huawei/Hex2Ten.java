package com.niuke.huawei;

import java.util.HashMap;
import java.util.Map;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/11/6
 * 公司：北京活力天汇<br>
 **/
public class Hex2Ten {
    // 0xA
    public int transform(String hex){
        Map<String,Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);
        map.put("6",6);
        map.put("7",7);
        map.put("8",8);
        map.put("9",9);
        map.put("A",10);
        map.put("B",11);
        map.put("C",12);
        map.put("D",13);
        map.put("E",14);
        map.put("F",15);

        String[] strs = hex.split("");
        int rs=  0;
        for(int i=strs.length-1;i>1;i--){
            rs = rs*16 + map.get(strs[i]);
        }
        return rs;
    }

    public static void main(String[] args) {
        Hex2Ten h = new Hex2Ten();
        h.transform("0xAB9");
    }
}
