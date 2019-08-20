package com.leetcode;

import java.util.*;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * [-1, 0, 1, 2, -1, -4]   三数相加和为0
 * @author dell
 * @date 2019/8/14
 * 公司：北京活力天汇<br>
 **/
public class ThreeSumZero {
    public static List<List<Integer>> threeSum(int[] nums) {

        // 排序后才方便使用双指针
        Arrays.sort(nums);

        // 从左至右变大
        if(nums.length<3 || nums[0]>0){
            return new ArrayList<>();
        }
        List<List<Integer>> rsList = new ArrayList<>();


        for(int i=0;i<nums.length;i++){
            int a1 = nums[i];
            int l = i+1;
            int r = nums.length-1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            while(l<r){
                if(l>i+1 && nums[l]==nums[l-1]){
                    l++;
                    continue;
                }

                if(r<nums.length-1  && nums[r]==nums[r+1]){
                    r--;
                    continue;
                }

                int sum = nums[i] + nums[l]+nums[r];
                // 右边界左移
                if(sum>0){
                    r--;
                }else if(sum<0){
                    l++;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    rsList.add(list);
                    l++;
                    r--;
                }
            }


        }

        return rsList;
    }


    public static void main(String[] args) {
        int[] i = new int[]{-1,0,1,2,-1,-4};


        System.out.println(threeSum(i));
    }


}
