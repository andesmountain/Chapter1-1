package com.leetcode;

/**
 * @author zhuyinkui
 * @version 1.0.0
 * @Description
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * @createTime 2020年05月20日 16:52:00
 */
public class Q50_myPow {

    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        // n在int边界时，-n会出问题
        long N = n;
        if(N<0){
            return 1/positivePow(x,-N);
        }
        return positivePow(x,N);
    }

    private double positivePow(double x,long n){
        if(n==1){
            return x;
        }
        double y = positivePow(x,n/2);
        if(n%2==1){
            return y*y*x;
        }else{
            return y*y;
        }
    }

    public static void main(String[] args) {
        Q50_myPow q = new Q50_myPow();
        double c = q.myPow(1,-2147483648);
        System.out.println(c);
    }
}
