package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/9/19
 * 公司：北京活力天汇<br>
 **/
public class Q66_plusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        // 可能会增加1位数
        int[] rs = new int[n];
        if(n==0){
            return new int[]{1};
        }

        int add = 1;
        // 从尾部加起
        for(int i=n-1;i>=0;i--){
            int now = digits[i];
            rs[i] = (now+add)%10;
            add = (now+add)>9?1:0;
        }
        if(add==1){
            int[] rs2= new int[n+1];
            rs2[0] = 1;
            for(int i=0;i<n;i++){
                rs2[i+1] = rs[i];
            }
            return rs2;
        }
        return rs;
    }


    public static void main(String[] args) {
        Q66_plusOne q= new Q66_plusOne();

        q.plusOne(new int[]{9});

    }

}
