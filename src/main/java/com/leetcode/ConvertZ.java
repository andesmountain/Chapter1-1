package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 将字符串z字形排列后，分行读取
 *
 * @author dell
 * @date 2019/8/12
 * 公司：北京活力天汇<br>
 **/
public class ConvertZ {

    public static String convert(String s, int numRows) {
        if (s == null || "".equals(s) || numRows <= 0) {
            return "";
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        if (numRows >= len || numRows==1) {// 只有一竖排或者一横排,读的和原字符串相同
            return s;
        }

        for (int i = 0; i < numRows; i++) {
            // 当i=0或者i=numRows-1时,第一个是i，第二个是 2*numRows-2+i,第三个是4*numRows-4+i 。。。
            if (i == 0 || i == numRows - 1) {
                int n = (len-1 - i) / (2 * numRows - 2) + 1;
                for (int j = 0; j < n; j++) {
                    sb.append(s.charAt(j * (2 * numRows - 2) + i));
                }
            } else {
                // 当 0<i<numRows-1 时，第一个是i， 第二个是  2numRows-2-i,第三个是i+2numRows-2,第四个 4numRows-4-i,第五个4numRows-4+i
                int n2 = (len-1 + i) / (2 * numRows - 2);  // 第2,4,6...
                int n1 = (len-1 - i) / (2 * numRows - 2) + 1;   // 第 1,3,5...


                for (int j = 0; j < n2; j++) {
                    // 奇数项
                    sb.append(s.charAt(j * (2 * numRows - 2) + i));
                    // 偶数项
                    sb.append(s.charAt((j + 1) * (2 * numRows - 2) - i));
                }
                // 有奇数个字符
                if (n1 == (n2 + 1)) {
                    sb.append(s.charAt(n2 * (2 * numRows - 2) + i));
                }

            }
        }

        return sb.toString();
    }


    public static String convert2(String s, int numRows){
        if (s == null || "".equals(s) || numRows <= 0) {
            return "";
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        if (numRows >= len || numRows==1) {// 只有一竖排或者一横排,读的和原字符串相同
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new StringBuilder());
        }

        int k=0;
        boolean reverse = true;
        for(int i=0;i<len;i++){
            list.get(k).append(s.charAt(i));
            if(k==0|| k==numRows-1){
                reverse =! reverse;
            }
            k = reverse?(k-1):(k+1);
        }

        StringBuilder res = new StringBuilder();
        for(int i=0;i<numRows;i++){
            res.append(list.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(convert2(s,4));
    }
}
