package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * (())(最长的有效括号子串长度
 * @author dell
 * @date 2019/8/20
 * 公司：北京活力天汇<br>
 **/
public class Q32_LongestValidParentheses {

    public int longestValidParentheses(String s){
        // 以s第i位为有效括号子串的长度  ()()  如dp[1]=2,dp[2]=2,dp[3]=4
        // 如果第i位为 (  肯定不能组成有效括号，只有  ） 才能组成有效括号
        if(s==null || "".equals(s)){
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        dp[0] = 0 ;
        for(int i=1;i<s.length();i++){
            // 如果 i-1位为 (   i 位为),则组成一个有效括号子串,dp[i]=dp[i-2]+2
            if(s.charAt(i)==')' && s.charAt(i-1)=='('){
                dp[i] = (i>1?dp[i-2]:0) +2;
            }
            // 如果i-1 位 ), i位为 ) ,则i对应的左括号肯定在i-1位对应的左括号左边一位，即  i-dp[i-1]-1 位必须是左括号，再加上左边的有效括号 dp[i-dp[i-1]-2]
            if(s.charAt(i)==')' && s.charAt(i-1)==')' &&  i>dp[i-1] && s.charAt(i-dp[i-1] -1)=='('){
                dp[i] = (i>dp[i-1]+1?dp[i-dp[i-1]-2]:0)+dp[i-1]+2;
            }
            max = Math.max(dp[i],max);
        }
        return max;

    }


    public static void main(String[] args) {
        Q32_LongestValidParentheses q = new Q32_LongestValidParentheses();

        q.longestValidParentheses("(())");

    }
}
