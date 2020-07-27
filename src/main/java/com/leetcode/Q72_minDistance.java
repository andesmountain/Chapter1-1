package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 输入: word1 = "h   e", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * @author dell
 * @date 2019/9/24
 * 公司：北京活力天汇<br>
 **/
public class Q72_minDistance {
    public int minDistance(String word1, String word2) {
        // dp[i][j] = min[dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+word.charAt(i)==word.charAt(j)?0:1];
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                int left = dp[i-1][j]+1;
                int right = dp[i][j-1]+1;
                int mid = dp[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1);
                dp[i][j] = Math.min(Math.min(left,right),mid);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Q72_minDistance q = new Q72_minDistance();
        q.minDistance("horse","ors");
    }

}
