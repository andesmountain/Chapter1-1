package com.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * d个筛子，筛子有f面，对应数字1,2,3..,f
 * 摇出和为target的所有方法
 * d=2,f=6,target=7   共有6种方法
 * @author dell
 * @date 2019/8/16
 * 公司：北京活力天汇<br>
 **/
public class NumRollsToTarget {
    private static final int MOD = 1000000007;
    public static int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d+1][d*f+1];
        int min = Math.min(f, target);
        for (int i = 1; i <= min; i++) {
            dp[1][i] = 1;
        }
        int targetMax = d * f;
        // dp[i][j]  投掷i次，和为j的排列组合数
        // 若第i次投出了k (1<=k<=f)，则第i-1次应为dp[i-1][j-k]，
        // j-f + f  =j  第i次投出f， 可能数为dp[i-1][j-f]
        // j-k + k = j  可能数为dp[i-1][j-k]
        // j-1 + 1 = j  可能数为dp[i-1][j-1]
        // 所以
        // 即 dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j - 2] + ... + dp[i - 1][j - f]

        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= targetMax; j++) {
                for (int k = 1; j - k >= 0 && k <= f; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
        }
        return dp[d][target];
    }



    public static void main(String[] args) {

        System.out.println(numRollsToTarget(2,6,9));
    }

}
