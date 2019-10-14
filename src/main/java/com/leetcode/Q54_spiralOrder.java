package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * @author dell
 * @date 2019/9/16
 * 公司：北京活力天汇<br>
 **/
public class Q54_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rsList = new ArrayList<>();

        // 一圈一圈的计数 (0,0)  (1,1) (2,2)为起点绕一圈
        int m = matrix.length;
        if(m==0){
            return new ArrayList<>();
        }
        int n = matrix[0].length;
        for(int k=0;k<=m-1-k && k<=n-1-k;k++){
            // 起点
            int start = matrix[k][k];
            // 上
            for(int i=k;i<=n-1-k;i++){
                rsList.add(matrix[k][i]);
            }
            // 右
            for(int i=k+1;i<=m-1-k;i++){
                rsList.add(matrix[i][n-1-k]);
            }
            // 下
            for(int i=n-2-k;i>=k && k<m-1-k;i--){
                rsList.add(matrix[m-1-k][i]);
            }
            // 左
            for(int i=m-2-k;i>k && k<n-1-k;i--){
                rsList.add(matrix[i][k]);
            }
        }
        return rsList;

    }


    public static void main(String[] args) {
        Q54_spiralOrder q = new Q54_spiralOrder();
        q.spiralOrder(new int[][]{{7},{9},{6}});
    }

}
