package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/8/14
 * 公司：北京活力天汇<br>
 **/
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int size = strs.length;
        StringBuilder sb = new StringBuilder();
        char c;
        for(int k=0;k<strs[0].length();k++){
            c = strs[0].charAt(k);
            for(int i=1;i<size;i++){
                if(strs[i].length()<=k  ||  c!=strs[i].charAt(k)){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"c","c"}));
    }
}
