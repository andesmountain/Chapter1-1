package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 1~3999 转成罗马数字
 * I      6    1
 * V      5    5
 * X      4    10
 * L      3    50
 * C      2    100
 * D      1    500
 * M      0    1000
 * @author dell
 * @date 2019/8/14
 * 公司：北京活力天汇<br>
 **/
public class IntToRoman {
    public  static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int div =1000;
        int rs=0,remain=num,n=0;
        String[] arr = new String[]{"M","D","C","L","X","V","I"};
        while (div>0){
            rs = remain / div;
            if(rs==0){
                div = div/10;
                continue;
            }
            remain = remain % div;
            n = (int) Math.log10(div);
            if(rs==9){
                sb.append(arr[6-2*n]);
                sb.append(arr[4-2*n]);
            }else if(rs>=5 && rs<9){
                sb.append(arr[6-2*n-1]);
                for(int i=0;i<rs-5;i++){
                    sb.append(arr[6-2*n]);
                }
            }else if(rs==4){
                sb.append(arr[6-2*n]);
                sb.append(arr[5-2*n]);
            }else{
                for(int i=0;i<rs;i++){
                    sb.append(arr[6-2*n]);
                }
            }
            div = div/10;
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(intToRoman(58));
    }

}
