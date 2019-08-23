package com.leetcode;

import java.util.Arrays;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @author dell
 * @date 2019/8/21
 * 公司：北京活力天汇<br>
 **/
public class Q26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        // 慢指针
        int j=0;
        // 因为是已经排序了的，所以重复的数字肯定是挨着的
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                // 替换重复项
                nums[++j] = nums[i];
            }
        }
        return j+1;

    }

    public static void main(String[] args) {
        Q26_removeDuplicates q = new Q26_removeDuplicates();
        q.removeDuplicates(new int[]{1,1,2,2,3,4,5,5});
    }

}
