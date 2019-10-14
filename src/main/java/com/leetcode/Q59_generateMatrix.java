package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @author dell
 * @date 2019/9/18
 * 公司：北京活力天汇<br>
 **/
public class Q59_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        // 由外至内  4*(n-1) , 4*(n-3) ...
        int i=0;
        int begin=1;
        while(n-1-2*i>=0){
            int d = n -1 -2*i;
            // 绕一圈  [i][i]-> [i][n-1-i] -> [n-1-i][n-1-i] -> [n-1-i][i]
            if(d==0){
                matrix[i][i] = begin;
                break;
            }
            // 上
            for(int j=i;j<=n-2-i;j++){
                matrix[i][j] = begin;
                begin++;
            }
            // 右
            for(int j=i;j<=n-2-i;j++){
                matrix[j][n-1-i] = begin;
                begin++;
            }
            // 下
            for(int j=n-1-i;j>i;j--){
                matrix[n-1-i][j] = begin;
                begin++;
            }
            // 左
            for(int j=n-1-i;j>i;j--){
                matrix[j][i] = begin;
                begin++;
            }
            i++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        Q59_generateMatrix q=  new Q59_generateMatrix();
        q.generateMatrix(5);
    }

}
