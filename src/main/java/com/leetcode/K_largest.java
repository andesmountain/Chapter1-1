package com.leetcode;

import java.util.PriorityQueue;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/10/14
 * 公司：北京活力天汇<br>
 **/
public class K_largest {
    public static void main(String[] args) {
        K_largest k = new K_largest();

        k.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4);

    }

    public int findKthLargest2(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }




    public int findKthLargest(int[] nums, int k) {
        return sort(nums, 0, nums.length-1, k);
    }

    private int sort(int[] nums, int left, int right, int k){
        int base = nums[left];
        int leftt = left;
        int rightt = right;
        while(leftt < rightt){
            while(leftt < rightt && nums[rightt] > base){
                rightt--;
            }
            if(leftt < rightt){
                int temp = nums[rightt];
                nums[rightt] = nums[leftt];
                nums[leftt] = temp;
                leftt++;
            }
            while(leftt < rightt && nums[leftt] < base){
                leftt++;
            }
            if(leftt < rightt){
                int temp = nums[rightt];
                nums[rightt] = nums[leftt];
                nums[leftt] = temp;
                rightt--;
            }
        }
        int rank = nums.length - leftt;
        if(rank == k){
            return nums[leftt];
        }else if(rank<k){
            return sort(nums, left, leftt-1, k);
        }else{
            return sort(nums, leftt+1, right, k);
        }
    }

}
