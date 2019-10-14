package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author dell
 * @date 2019/9/16
 * 公司：北京活力天汇<br>
 **/
public class Q53_maxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        if(nums.length==1){
            return nums[0];
        }
        dp[0]=nums[0];
        int max = dp[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]<0){
                dp[i]=nums[i];
            }else{
                dp[i] =  dp[i-1]+nums[i];
            }

            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Q53_maxSubArray q= new Q53_maxSubArray();
        q.maxSubArray(nums);
    }

}
