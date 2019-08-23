package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * target =4 返回 0
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * @author dell
 * @date 2019/8/21
 * 公司：北京活力天汇<br>
 **/
public class Q33_SearchRotate {


    public int search(int[] nums, int target) {
        if(nums.length==0 ){
            return -1;
        }

        if(nums.length==1){
            if(target==nums[0]) return 0;
            else return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;

    }

    /**
     * 升序数组  二分法找target
     * @param nums
     * @param target
     * @return
     */
    public int findTargetIndex(int[] nums, int target,int left,int right){
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid;
            }else{
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Q33_SearchRotate q=  new Q33_SearchRotate();

        q.search(new int[]{7,3,4,5,6},3);
    }

}
