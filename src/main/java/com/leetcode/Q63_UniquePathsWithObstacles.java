package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/8/20
 * 公司：北京活力天汇<br>
 **/
public class Q63_UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else if(i==0){
                    if(j>0){
                        dp[i][j]=dp[i][j-1];
                    }else{
                        dp[i][j]=1;
                    }
                }else if(j==0) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Q63_UniquePathsWithObstacles q= new Q63_UniquePathsWithObstacles();
        q.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0} });
    }



}
