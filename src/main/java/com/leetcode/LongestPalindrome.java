package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * babad -> bab 或者 aba  返回回文子串  从前往后和从后往前读都一样
 * @author dell
 * @date 2019/8/9
 * 公司：北京活力天汇<br>
 **/
public class LongestPalindrome {

    public static String longestPalindrome(String s) {

        if(s==null || s.length()<2){
            return s;
        }
        int[] barrier = new int[]{0,0};

        for(int i=0;i<s.length();i++) {
            parse(s,barrier,i-1,i+1);
            parse(s,barrier,i,i+1);
        }
        return s.substring(barrier[0],barrier[1]+1);

    }

    public static void parse(String s,int[] barrier ,int min,int max){
        while (min >= 0 && max < s.length()) {
            if(s.charAt(min)==s.charAt(max)){
                if(max-min>barrier[1]-barrier[0]){
                    barrier[0]=min;
                    barrier[1] =max;
                }
                min--;
                max++;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        String a = longestPalindrome("dcababadd");
        System.out.println(a);
    }

}
