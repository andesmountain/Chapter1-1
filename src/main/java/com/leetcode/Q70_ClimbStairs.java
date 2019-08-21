package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 爬楼梯
 * @author dell
 * @date 2019/8/20
 * 公司：北京活力天汇<br>
 **/
public class Q70_ClimbStairs {

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n==1){
            return 1;
        }
        dp[0]= 1;
        dp[1] =1;
        // dp[3] = dp[2] + dp[1];  dp[4] = dp[3]+dp[2]
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }

}
