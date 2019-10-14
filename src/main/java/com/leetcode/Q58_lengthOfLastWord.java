package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 * @author dell
 * @date 2019/9/18
 * 公司：北京活力天汇<br>
 **/
public class Q58_lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] arr = s.toCharArray();
        int left=0,right=-1;

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>64 && right==-1){
                right = i;
            }
            if(arr[i]==' ' && right!=-1){
                left = i+1;
                break;
            }
        }
        if(right==-1){
            return 0;
        }
        return right+1-left;
    }

    public static void main(String[] args) {
        Q58_lengthOfLastWord q=  new Q58_lengthOfLastWord();
        q.lengthOfLastWord("   ");
    }

}
