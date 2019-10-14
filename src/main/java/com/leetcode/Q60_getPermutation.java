package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 *
 * @author dell
 * @date 2019/9/18
 * 公司：北京活力天汇<br>
 **/
public class Q60_getPermutation {
    public String getPermutation(int n, int k) {
        int[] a = new int[n+1];
        int i=0;
        a[0] = 1;
        List<Integer> unUsed = new ArrayList<>();
        while(i<n){
            a[i+1] = a[i]*(i+1);
            unUsed.add(i+1);
            i++;
        }


        i = n-1;
        int remain = k-1;
        // 从右至左的结果
        int[] rs = new int[n];
        while(i>=0){
            int div = remain / a[i];
            remain = remain % a[i];
            // 去除用过的
            rs[i] = unUsed.remove(div);
            i--;
        }

        StringBuilder sb=  new StringBuilder();
        for(int j=n-1;j>=0;j--){
            sb.append(rs[j]);
        }
        return  sb.toString();

    }

    public static void main(String[] args) {
        Q60_getPermutation q= new Q60_getPermutation();
        q.getPermutation(4,6);
    }

}
