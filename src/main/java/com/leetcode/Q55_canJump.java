package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * [3,2,1,0,4]   false
 * @author dell
 * @date 2019/9/16
 * 公司：北京活力天汇<br>
 **/
public class Q55_canJump {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }

        int[] step = new int[nums.length];
        step[0] = 0;
        // 动态规划  nums[5] 最早可以从nums[0]跳跃到
        int last = 0,i=1;
        while(i<nums.length){
            boolean jump = false;
            for(int j=last;j<i;j++){
                if(nums[j]+j>=i){
                    last = j;
                    jump=true;
                    break;
                }
            }
            if(!jump){
                return false;
            }
            step[i] = last;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Q55_canJump q = new Q55_canJump();

        q.canJump(new int[]{3,2,1,0,4});
    }

}
