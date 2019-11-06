package com.niuke.huawei;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 3个空瓶换一个满瓶，可以找老板借一瓶
 * @author dell
 * @date 2019/11/6
 * 公司：北京活力天汇<br>
 **/
public class ReplaceBottle {

    // 1<=n<=100  全是空瓶
    public int maxDrinkedBottles(int total){
        int drinked= 0;
        int remain = total;
        while(remain>=3){
            drinked += remain/3;
            remain = remain%3+remain/3;
        }
        if(remain==2){
            drinked++;
        }
        System.out.println(drinked);
        return  drinked;
    }

    public static void main(String[] args) {

        ReplaceBottle rb = new ReplaceBottle();
        rb.maxDrinkedBottles(10);
    }

}
