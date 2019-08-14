package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 整数是否是回文数
 * @author dell
 * @date 2019/8/12
 * 公司：北京活力天汇<br>
 **/
public class PalindromeInteger {

    public static boolean isPalindrome(int y) {
        if(y<0){
            return  false;
        }
        int x=y;
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN =Integer.MIN_VALUE;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > INT_MAX/10 || (rev == INT_MAX / 10 && pop > 7)) return false;
            rev = rev * 10 + pop;
        }

       return   rev==y?true:false;


    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
