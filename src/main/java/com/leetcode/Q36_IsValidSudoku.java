package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * @author dell
 * @date 2019/8/23
 * 公司：北京活力天汇<br>
 **/
public class Q36_IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // 三个规则，指定三个数组 rows[]  cols[]   boxes[]
        // 遍历一遍，将数字填充到三个数组中，判断是否有效

        Map[] rows = new Map[9];
        Map[] cols = new Map[9];
        Map[] boxes = new Map[9];

        // 初始化
        for(int i=0;i<9;i++){
            rows[i] = new HashMap();
            cols[i] = new HashMap();
            boxes[i] = new HashMap();
        }


        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if(c=='.'){
                    continue;
                }
                int value = (int)c;

                if(!rows[i].containsKey(value)){
                    rows[i].put(value,1);
                }else{
                    return false;
                }

                if(!cols[j].containsKey(value)){
                    cols[j].put(value,1);
                }else{
                    return false;
                }

                if(!boxes[3*(i/3)+j/3].containsKey(value)){
                    boxes[3*(i/3)+j/3].put(value,1);
                }else{
                    return false;
                }
            }
        }

        return true;


    }

    public static void main(String[] args) {
        char[][] c = new char[][]{{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        Q36_IsValidSudoku q = new Q36_IsValidSudoku();
        q.isValidSudoku(c);

    }

}
