package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * 为了更好地评估这份计划，对于卡路里表中的每一天，你都需要计算他 「这一天以及之后的连续几天」 （共 k 天）内消耗的总卡路里 T：
 *
 * 如果 T < lower，那么这份计划相对糟糕，并失去 1 分； 
 * 如果 T > upper，那么这份计划相对优秀，并获得 1 分；
 * 否则，这份计划普普通通，分值不做变动。
 * 请返回统计完所有 calories.length 天后得到的总分作为评估结果。
 *
 * @author dell
 * @date 2019/9/5
 * 公司：北京活力天汇<br>
 **/
public class Q1176_dietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int n = calories.length;
        int score=0;

        int sum=0;
        for(int i=0;i<k;i++){
            sum += calories[i];
        }
        if(sum<lower){
            score--;
        } else if(sum>upper){
            score++;
        }


        for(int i=1;i<=n-k;i++){
            sum = sum - calories[i-1]+calories[i+k-1];
            if(sum<lower){
                score--;
            } else if(sum>upper){
                score++;
            }
        }
        System.out.println(score);
        return score;
    }

    public static void main(String[] args) {
        Q1176_dietPlanPerformance q = new Q1176_dietPlanPerformance();
        q.dietPlanPerformance(new int[]{6,5,0,0},2,1,5);
    }

}
