package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * I      6    1
 * V      5    5
 * X      4    10
 * L      3    50
 * C      2    100
 * D      1    500
 * M      0    1000
 * @author dell
 * @date 2019/8/14
 * 公司：北京活力天汇<br>
 **/
public class RomanToInt {
    public static int romanToInt(String s) {
       /* String[] strArr = new String[]{"M","D","CM","CD","C","L","XC","XL","X","V","IX","IV","I"};
        int[] intArr = new int[]{1000,500,900,400,100,50,90,40,10,5,9,4,1};
*/
        Map<String,Integer> map = new HashMap<>();
        map.put("M",1000);
        map.put("D",500);
        map.put("CM",900);
        map.put("CD",400);
        map.put("C",100);
        map.put("L",50);
        map.put("XC",90);
        map.put("XL",40);
        map.put("X",10);
        map.put("V",5);
        map.put("IX",9);
        map.put("IV",4);
        map.put("I",1);
        String str = "";

        StringBuilder sb = new StringBuilder();
        int rs=0,i=0;
        Integer num=null;
        while(i<s.length()){
            // 双字符
            if(i<s.length()-1){
                str = String.valueOf(s.charAt(i))+ String.valueOf(s.charAt(i+1));
                if((num=map.get(str))!=null){
                    rs += num;
                    i= i+2;
                    continue;
                }
            }
            //  单个字符
            str =  String.valueOf(s.charAt(i))+"";
            rs += map.get(str);
            i++;
        }
        return rs;

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
