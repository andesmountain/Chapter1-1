package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/8/12
 * 公司：北京活力天汇<br>
 **/
public class ReverseInteger {

    public static int reverse(int x) {
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN =Integer.MIN_VALUE;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > INT_MAX/10 || (rev == INT_MAX / 10 && pop > 7)) return 0;
            if (rev < INT_MIN/10 || (rev == INT_MIN / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;

    }

    public static int reverse2(int x){
        boolean pos = true;
        if(x<0){
            pos =false;
            x =-x;
        }
        String abc= String.valueOf(x);
        StringBuilder sb= new StringBuilder();
        int rs =0;
        try{
            for(int i=abc.length()-1;i>=0;i--){
                sb.append(abc.charAt(i));
            }
            rs = Integer.parseInt(sb.toString());
        }catch (Exception e){
            return 0;
        }

        return pos?rs:-rs;
    }

    public static void main(String[] args) {
        int x=1111111102;
        System.out.println( Integer.MAX_VALUE);
        System.out.println(reverse(x));

        System.out.println(Math.pow(10,2));

    }



}
