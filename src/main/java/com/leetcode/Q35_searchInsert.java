package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @author dell
 * @date 2019/8/21
 * 公司：北京活力天汇<br>
 **/
public class Q35_searchInsert {
    public static int searchInsert(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        int left =0;
        int right = nums.length;

        // 区间为 [left,right)
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>target){
                right = mid;
            }else if(nums[mid]<target){
                left  = mid+1;
            }else{
                left = mid;
                break;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        searchInsert(new int[]{1,3,5,6},5);
    }
}
