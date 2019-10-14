package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * @author dell
 * @date 2019/9/16
 * 公司：北京活力天汇<br>
 **/
public class Q51_solveNQueens {
    List<List<String>> rsList = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] matrix = new String[n][n];
        // 每一行只有一个Q,每一列有且只有一个Q，斜方向也只有一个
        // 第一个点遍历第一行，第二个点遍历第二行，以此类推，若第j个点无法放入第j行，则回溯
        setQ(matrix,0);
        return rsList;
    }



    // 一个Q的上下左右斜方向，标记为.
    public void setQ(String[][] matrix,int k){
        String[] arr = matrix[k];
        for(int j=0;j<arr.length;j++){
            if("Q".equals(arr[j]) || ".".equals(arr[j])){
                continue;
            }
            // 可以放Q,同时标记 .
            matrix[k][j]="Q";
            List<int[]> addList= setDot(matrix,k,j);
            if(k+1<arr.length){
                setQ(matrix,k+1);
            }
            else{
                addList(matrix);
            }
            // 剪枝
            matrix[k][j]=null;
            for(int[] intArr:addList){
                matrix[intArr[0]][intArr[1]] = null;
            }
        }
    }

    public void addList(String[][] matrix){
        List<String> sol = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            String[] arr = matrix[i];
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<arr.length;j++){
                sb.append(arr[j]);
            }
            sol.add(sb.toString());
        }
        rsList.add(sol);
    }


    public List<int[]> setDot(String[][] matrix,int k,int j){
        String[] arr = matrix[k];
        List<int[]> addList = new ArrayList<>();
        // 所在列标记 .
        for(int i=k+1;i<arr.length;i++){
            if(matrix[i][j]==null){
                matrix[i][j]=".";
                addList.add(new int[]{i,j});
            }
        }
        // 所在行标记 .
        for(int i=0;i<arr.length;i++){
            if(matrix[k][i]==null){
                matrix[k][i]=".";
                addList.add(new int[]{k,i});
            }
        }
        // 所在斜方向  标记.
        for(int i=1;k+i<arr.length && j+i<arr.length;i++){
            if(matrix[k+i][j+i]==null){
                matrix[k+i][j+i]=".";
                addList.add(new int[]{k+i,j+i});
            }
        }
        for(int i=1;k+i<arr.length && j-i>=0;i++){
            if(matrix[k+i][j-i]==null){
                matrix[k+i][j-i]=".";
                addList.add(new int[]{k+i,j-i});
            }
        }
        return addList;
    }

    public static void main(String[] args) {
        Q51_solveNQueens q = new Q51_solveNQueens();

        q.solveNQueens(5);
    }

}
