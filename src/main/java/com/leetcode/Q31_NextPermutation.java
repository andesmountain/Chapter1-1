package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * {1,2,3,4,8,7,5}  -> {1,2,3,8,4,5,7}
 * {5,7,8} -> {5,8,7} -> {7,5,8} ->{7,8,5} -> {8,5,7} -> {8,7,5}
 * @author dell
 * @date 2019/8/21
 * 公司：北京活力天汇<br>
 **/
public class Q31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // 问题核心是从右往左看，只要nums[i-1]<nums[i],则置换nums[i-1]和[i,n)间最小大于nums[i-1]的数，且重排序i-1后面的数值
        if(n==0 || n==1){
            return;
        }


        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                // [i,n) 是降序排列，在此区间找到比nums[i-1]大的最小数
                for(int j=n-1;n>=i;j--){
                    if(nums[i-1]<nums[j]){
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j]=temp;
                        // 升序排列[i,nums.length-1] 区间的数组，但注意到[i,n)是降序，所以直接左右对调就好了
                        sort(nums,i);
                        return;
                    }
                }
            }
        }

        // 如果已经是降序数组，则转换成升序数组
        sort(nums,0);
    }

    public void sort(int[] nums,int left){
        int i= left;
        int j = nums.length-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        System.out.println(nums);

    }


    public static void main(String[] args) {
        Q31_NextPermutation q = new Q31_NextPermutation();
        q.nextPermutation(new int[]{1,3,2});
    }

}
