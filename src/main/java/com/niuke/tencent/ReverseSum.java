package com.niuke.tencent;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。
 * 例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.
 * 而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.
 *
 * @author dell
 * @date 2019/11/6
 * 公司：北京活力天汇<br>
 **/
public class ReverseSum {

    // n=8 m=2  sum=8
    public long sum(int n,int m){
        // 计算一个2*m中的和
        int div = n/2/m;
        int sum0 = m*m;

        long sum = (long)div*(long)sum0;
        return sum;
    }

    public static void main(String[] args) {
        ReverseSum r= new ReverseSum();
        r.sum(323445962 ,371);
    }
}
