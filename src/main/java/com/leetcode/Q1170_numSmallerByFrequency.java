package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * 若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 * queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * "bbb"=3<"aaaa"=4
 * "cc"=3<"aaa","aaaa"
 * 返回[1,2]
 * @author dell
 * @date 2019/8/26
 * 公司：北京活力天汇<br>
 **/
public class Q1170_numSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        List<Integer> wordNumCount = new ArrayList<>();
        for(String word:words){
            wordNumCount.add(parse(word));
        }

        int[] rs = new int[queries.length];
        int k=0;
        for(String q:queries){
            int qCount = parse(q);
            int x = (int)wordNumCount.stream().filter(w->{
               return w>qCount;
            }).count();
            rs[k++] = x;
        }
        return rs;

    }

    // 统计最小的字母出现次数
    public int parse(String str){
        int minChar = 1000;
        int minCount = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)<minChar){
                minChar = str.charAt(i);
                minCount=1;
            }else if(str.charAt(i)==minChar){
                minCount++;
            }
        }
        return minCount;

    }

    public static void main(String[] args) {
        Q1170_numSmallerByFrequency q = new Q1170_numSmallerByFrequency();

        q.numSmallerByFrequency(new String[]{"cbd"},new String[]{"zaaaz"});

    }

}
