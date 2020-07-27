package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * @author dell
 * @date 2019/9/16
 * 公司：北京活力天汇<br>
 **/
public class Q51_solveNQueens2 {
    // 对角线 左低右高
    private boolean[] dia1;
    // 对角线 左高右低
    private boolean[] dia2;
    // 列
    private boolean[] col;

    public Q51_solveNQueens2(int n){
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];
        col = new boolean[n];
    }


    public int solveQueen(int i){
        int n = col.length;
        int res= 0;
        if(n==i) return 1;
        for(int j=0;j<n;j++){
            if(!col[j] && !dia1[i+j] && !dia2[n-1-i+j]){
                col[j]=true;
                dia1[i+j]=true;
                dia2[n-1-i+j]=true;

                res += solveQueen(i+1);
                col[j]=false;
                dia1[i+j]=false;
                dia2[n-1-i+j]=false;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Q51_solveNQueens2 q = new Q51_solveNQueens2(5);

        int n = q.solveQueen(0);
        System.out.println(n);
    }

}
