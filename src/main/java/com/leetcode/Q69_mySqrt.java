package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 计算并返回 x 的平方根，其中 x 是非负整数。  0,1,2,
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @author dell
 * @date 2019/9/20
 * 公司：北京活力天汇<br>
 **/
public class Q69_mySqrt {
    public int mySqrt(int x) {
        if(x<2){
            return x;
        }

        long left =0,right =x;
        long sqrt=x/2;
        while(left+1!=right){
            if(sqrt*sqrt==x){
                left =sqrt;
                break;
            }else if(sqrt*sqrt<x){
                left = sqrt;
                sqrt = (sqrt+right)/2;
            }else{
                right=sqrt;
                sqrt =(sqrt+left)/2;
            }
        }
        return (int)left;

    }


    public static void main(String[] args) {
        Q69_mySqrt q=  new Q69_mySqrt();

        q.mySqrt(2147395599);
    }

}
