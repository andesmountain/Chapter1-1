package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 两有序数组  寻找中位数
 * @author dell
 * @date 2019/8/9
 * 公司：北京活力天汇<br>
 **/
public class FindMedianSortedArrays {
    // nums1 = [1, 3]    nums2 = [2]  两个都是有序数组
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n){
            // 这样就能保证如果有数组空了，一定是 len1
            return findMedianSortedArrays(nums2,nums1);
        }

        int iMin =0,iMax= m;

        while (true) {
            // 二分法
            int i = (iMax+iMin)/2;
            int j= (m+n+1)/2-i;
            if (i!=0 && j<n && nums1[i - 1] > nums2[j] ) {
                iMax= i-1;
            } else if (j!=0  && i<m  && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else { // 不用调整了
                int maxLeft=0,minRight=0;
                if(i==0) maxLeft=nums2[j-1];
                else if(j==0) maxLeft = nums1[i-1];
                else{
                    maxLeft=Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)%2==1){ // 奇数，取左边最大的
                    return maxLeft;
                }
                // 偶数，取（maxLeft+minRight)/2.0
                if(i==m) minRight=nums2[j];
                else if(j==n) minRight=nums1[i];
                else minRight = Math.min(nums1[i],nums2[j]);
                return (maxLeft+minRight)/2.0;
            }
        }
    }

    public static void main(String[] args) {
        double f= findMedianSortedArrays(new int[]{1,2},new int[]{3});
        System.out.println(f);
    }

}
