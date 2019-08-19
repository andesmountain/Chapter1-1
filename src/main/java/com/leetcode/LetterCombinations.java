package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/8/15
 * 公司：北京活力天汇<br>
 **/
public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {

        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        List<String> list = new ArrayList<>();


        for(int i=0;i<digits.length();i++){
            Integer num = Integer.parseInt(digits.substring(i,i+1));

            String letter = map.get(num);
            if(i==0){
                for(int k=0;k<letter.length();k++){
                    list.add(letter.substring(k,k+1));
                }
                continue;
            }
            List<String> temp = new ArrayList<>();
            for(int k=0;k<letter.length();k++){
                for(int n=0;n<list.size();n++){
                    String combine = list.get(n)+String.valueOf(letter.charAt(k));
                    temp.add(combine);
                }
            }
            list = temp;
        }

        return list;

    }

    public static void main(String[] args) {

        System.out.println(letterCombinations("233"));

    }

}
