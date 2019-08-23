package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别
 * @author dell
 * @date 2019/8/21
 * 公司：北京活力天汇<br>
 **/
public class Q34_SearchRange {
    public int[] searchRange(int[] nums, int target) {

        int leftBound = searchLeftBound(nums,target);

        int rightBound = searchRightBound(nums,target,leftBound);

        return new int[]{leftBound,rightBound};

    }

    // 找左边界，已知 nums[(left+right)/2] = target,且当nums[mid]>nums[0]时，一定有 nums[mid]>nums[mid-1]
    public int searchLeftBound(int[] nums, int target){
        int leftBound=-1;
        int left=0,right=nums.length-1;

        // target>nums[0]  找出 target = nums[leftBound]>nums[leftBound-1]
        while (left<=right) {
            if(nums[left]==target){
                leftBound = left;
                break;
            }
            int mid = (left+right)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                if (nums[mid - 1] == target) {
                    right = mid - 1;
                }else{
                    leftBound = mid;
                    break;
                }
            }
        }
        return leftBound;
    }


    // 找右边界
    public int searchRightBound(int[] nums, int target,int leftBound){
        int rightBound=-1;
        if(leftBound==-1){
            return -1;
        }
        int left=leftBound,right=nums.length-1;

        while (left<=right) {
            if(nums[right]==target){
                rightBound = right;
                break;
            }
            int mid = (left+right)/2;
            if (nums[mid] > target) {
                right = mid-1;
            }else if(nums[mid]==target){
                if(nums[mid+1]>target){
                    rightBound=mid;
                    break;
                }else{
                    left = mid+1;
                }
            }
        }
        return rightBound;
    }

    public static void main(String[] args) {
        Q34_SearchRange  q = new Q34_SearchRange();

        q.searchRange(new int[]{1,2,3},1);

    }
}
