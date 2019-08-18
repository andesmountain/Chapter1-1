package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/8/12
 * 公司：北京活力天汇<br>
 **/
public class MaxArea {
    public static int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int rs = 0;
        while(left<right){
            int area = Math.min(height[left],height[right])*(right-left);
            rs = Math.max(rs,area);
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] arr =new int[]{10,0,0,99,11};
        System.out.println(maxArea(arr));
    }

}
