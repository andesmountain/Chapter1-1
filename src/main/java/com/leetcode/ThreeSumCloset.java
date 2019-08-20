package com.leetcode;

import java.util.Arrays;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 数组里取三个数，和最接近给定值
 * @author dell
 * @date 2019/8/15
 * 公司：北京活力天汇<br>
 **/
public class ThreeSumCloset {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length==3){
            return nums[0]+nums[1]+nums[2];
        }
        // 记录差值
        int abs = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            int l=i+1;
            int r = nums.length-1;
            while(l<r){
                int minus = target-nums[i]-nums[l]-nums[r];
                if(Math.abs(abs)>Math.abs(minus)){
                    abs = minus;
                }
                if(minus>0){
                    while(l<nums.length-1 && nums[l]==nums[l+1]){
                        l++;
                    }
                    l++;
                }else if(minus<0){
                    while(r>l+1 && nums[r]==nums[r-1]){
                        r--;
                    }
                    r--;
                }else{
                    return target;
                }
            }
        }

        return target-abs;


    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
    }

}
