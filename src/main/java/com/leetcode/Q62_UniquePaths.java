package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/8/20
 * 公司：北京活力天汇<br>
 **/
public class Q62_UniquePaths {

    public int uniquePaths(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Q62_UniquePaths q=  new Q62_UniquePaths();
        System.out.println(q.uniquePaths(7,3));
    }
}
