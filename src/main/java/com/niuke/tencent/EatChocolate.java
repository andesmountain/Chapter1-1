package com.niuke.tencent;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力
 * 每个测试用例的第一行包含两个正整数，表示父母出差的天数N(N<=50000)和巧克力的数量M(N<=M<=100000)。
 * @author dell
 * @date 2019/11/6
 * 公司：北京活力天汇<br>
 **/
public class EatChocolate {
    // n=3 m=7   返回 4,2,1
    // n=4 m=7   3,2,1,1
    // n=4 m=10  4,2,1,1,
    // n=2 m=10  6,3
    // n=3 m=9   4,2,1
    // n=3 m=3    1,1,1
    public int maxEatFirstday(int n,int m){
        // 极限情况  第一天吃最多  那么后面怎么少怎么来   大不了最后每天都吃一块
        // 假如第一天吃了 x 块 且天数足够长  那么他最多能吃多少块呢
        int rs= loop(n,m,1,m);
        System.out.println(rs);
        return rs;
    }


    public static void main(String[] args) {
        EatChocolate e = new EatChocolate();
        e.maxEatFirstday(4,10);
    }

    // [left,right)
    public int loop(int n,int m,int left,int right){
        int sum = 0;
        int day = 0;
        int first = (left+right)/2;
        int x = first;
        if(left==right-1){
            return first;
        }
        while(day<n){
            sum += x;
            x= x%2==0? x/2: x/2 +1 ;
            day++;
        }
        if(day<n){
            sum += n-day;
        }
        // 可行，继续让X增大
        if(sum<m){
            return loop(n,m,first,right);
        }else if(sum>m){
            // 不可行，让x减小
            return loop(n,m,left,first);
        }else{
            return first;
        }
    }

}
