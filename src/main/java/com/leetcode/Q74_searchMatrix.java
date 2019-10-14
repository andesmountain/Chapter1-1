package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * @author dell
 * @date 2019/9/24
 * 公司：北京活力天汇<br>
 **/
public class Q74_searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0) return false;

        int n = matrix[0].length;
        if(n==0) return false;
        int start=0,end=m,i=0,j=0;
        // 寻找行
        while(start+1<end){
            int head = matrix[i][0];
            if(head==target){
                return true;
            }else if(head>target){
                end = i;
                i = (start+end)/2;
            }else{
                start = i;
                i= (start+end)/2;
            }
        }
        start =0;
        end = n;
        // 寻找列
        while(matrix[i][j]!=target && start+1<end){
            if(matrix[i][j]>target){
                end = j;
                j = (start+end)/2;
            }else if(matrix[i][j]<target){
                start =j;
                j=(start+end)/2;
            }
        }

        return matrix[i][j]==target;
    }

    public static void main(String[] args) {
        Q74_searchMatrix q= new Q74_searchMatrix();

        q.searchMatrix(new int[][]{ {}},16);
    }

}
