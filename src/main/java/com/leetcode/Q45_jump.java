package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * @author dell
 * @date 2019/9/10
 * 公司：北京活力天汇<br>
 **/
public class Q45_jump {


    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int[] step = new int[nums.length];
        step[0] = 0;
        // 动态规划  nums[5] 最早可以从nums[0]跳跃到
        int last = 0,i=1;
        while(i<nums.length){
            for(int j=last;j<=i;j++){
                if(nums[j]+j>=i){
                    last = j;
                    break;
                }
            }
            step[i] = last;
            i++;
        }


        int minSum=reverse(step,nums.length-1);
        return minSum;
    }


    public int reverse(int[] step,int i){
        int sum=0;
        // 找到最小多少格，能跳到目标格
        while(i>0){
            i = step[i];
            sum++;
        }
        return sum;
    }



    public static void main(String[] args) {
        int[] a = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        Q45_jump q= new Q45_jump();
        q.jump(a);

    }

}
