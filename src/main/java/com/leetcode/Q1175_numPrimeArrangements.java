package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 *
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 *
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 * @author dell
 * @date 2019/9/5
 * 公司：北京活力天汇<br>
 **/
public class Q1175_numPrimeArrangements {


    public int numPrimeArrangements(int n) {
        if(n<=2){
            return 1;
        }
        int mod = 1000000007;
        // 1.先获取1~n中所有质数
        int countPrime = CountPrimes(n);
        // 2.质数排列组合
        long arrange = 1;
        for(int i=countPrime;i>0;i--){
            arrange = (arrange*i)%mod;
        }
        // 3.非质数排列
        for(int i=n-countPrime;i>0;i--){
            arrange = (arrange*i)%mod;
        }


        return (int)arrange;

    }


    public int CountPrimes(int n)
    {
        n++;
        int count = 0;
        boolean[] signs = new boolean[n];
        for (int i = 2; i < n; i++)
        {
            if (!signs[i])
            {
                count++;
                for (int j = i*2; j < n; j += i)
                {
                    //排除不是质数的数
                    signs[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q1175_numPrimeArrangements q = new Q1175_numPrimeArrangements();
        q.numPrimeArrangements(100);
    }


}
