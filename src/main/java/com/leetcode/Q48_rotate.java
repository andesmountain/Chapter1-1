package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * @author dell
 * @date 2019/9/11
 * 公司：北京活力天汇<br>
 **/
public class Q48_rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i=0;i< (n+1)/2;i++){
            for(int j=i;j<n-1-i;j++){
                int temp1 = matrix[i][j];
                int temp2 = matrix[j][n-1-i];
                int temp3 = matrix[n-1-i][n-1-j];
                int temp4 = matrix[n-1-j][i];

                matrix[i][j] =temp4;
                matrix[j][n-1-i] = temp1;
                matrix[n-1-i][n-1-j] = temp2;
                matrix[n-1-j][i] = temp3;
            }
        }

        System.out.println(matrix);

    }

    public static void main(String[] args) {
        Q48_rotate q = new Q48_rotate();
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        q.rotate(matrix);
    }

}
