package com.leetcode;

/**
 * @author zhuyinkui
 * @version 1.0.0
 * @Description TODO
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 给定 nums = [1,1,1,2,2,3], 返回5
 * @createTime 2020年05月22日 19:20:00
 */
public class Q80_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }

        int startIndex = 1;
        int i=1;
        int repeat = 1;
        while(i<nums.length){
            if(nums[i-1]==nums[i]) {
                repeat++;
            }else {
                repeat=1;
            }

            if(repeat<=2) {
                nums[startIndex++] = nums[i];
            }
            i++;
        }
        return startIndex;
    }


    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Q80_removeDuplicates q= new Q80_removeDuplicates();
        int[] nums = new int[]{0,1,2,2,2,2,2,3,4,4,4};
        int len = q.removeDuplicates2(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
