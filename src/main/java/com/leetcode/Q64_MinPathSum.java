package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/8/20
 * 公司：北京活力天汇<br>
 **/
public class Q64_MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    if(j>0){
                        dp[i][j] = dp[i][j-1]+grid[i][j];
                    }else{
                        dp[i][j] = grid[i][j];
                    }
                }else{
                    if(j>0){
                        dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
                    }else{
                        dp[i][j] = dp[i-1][j]+grid[i][j];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Q64_MinPathSum q = new Q64_MinPathSum();
        q.minPathSum(new int[][]{ {1,2,3},{3,4,5},{6,7,8}});

    }
}
