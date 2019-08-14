package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * abcabcdef  -> abcdef = 6 最长的不包含重复字符的子串
 * @author dell
 * @date 2019/8/9
 * 公司：北京活力天汇<br>
 **/
public class LengthOfLongestSubstring {
    // abcabcbb
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || "".equals(s)){
            return 0;
        }

        int max = 0,left=0;
        for(int i=0;i<s.length();i++){
            for(int j=left;j<i;j++){
                if(s.charAt(j)==s.charAt(i)){
                    if(max<i-left)
                        max=i-left;
                    left = j+1;
                }
            }
        }
        max = max<s.length()-left?s.length()-left:max;

        return max;
    }


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcdef"));
    }


}
