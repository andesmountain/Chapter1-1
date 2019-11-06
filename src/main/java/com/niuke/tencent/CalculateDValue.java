package com.niuke.tencent;

import java.util.Arrays;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/11/6
 * 公司：北京活力天汇<br>
 **/
public class CalculateDValue {
    public static void main(String[] args) {
        CalculateDValue  c = new CalculateDValue();
        c.cal(3,new int[]{2,7,4});
    }

    public int cal(int n,int[] cards){
        Arrays.sort(cards);
        int i = n-1;
        int sumNiu = 0;
        int sumYang = 0;
        while(i>=0){
            sumNiu += cards[i];
            i--;
            if(i>=0){
                sumYang += cards[i];
                i--;
            }
        }
        return sumNiu-sumYang;

    }

}
