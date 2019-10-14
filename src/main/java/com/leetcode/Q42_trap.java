package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author dell
 * @date 2019/9/10
 * 公司：北京活力天汇<br>
 **/
public class Q42_trap {
    public int trap(int[] height) {
        int size =0;
        if(height.length<=2){
            return 0;
        }
        List<Integer> topList = new ArrayList<>();
                // 找山峰
        for(int i=0;i<height.length;i++){
            if(i==0){
                if(height[i]>height[i+1])
                    topList.add(0);
            }else if(i==height.length-1){
                if(height[i]>height[i-1])
                    topList.add(i);
            }else {
                if((height[i]>=height[i+1] && height[i]>height[i-1]) || (height[i]>height[i+1] && height[i]>=height[i-1]) ){
                    topList.add(i);
                }
            }
        }

        // 找山峰间的积水,同时要排除掉夹在两座山峰间的小峰
        Set<Integer> realTop = new HashSet<>();
        realTop.add(topList.get(0));
        int barrier = height[topList.get(0)];
        // 从左到右
        for(int i=1;i<topList.size()-1;i++){
            int h = height[topList.get(i)];
            if(h>=barrier){
                barrier=h;
                // realTop
                realTop.add(topList.get(i));
            }
        }
        barrier = height[topList.get(topList.size()-1)];
        // 从右到左
        for(int i=topList.size()-2;i>=1;i--){
            int h = height[topList.get(i)];
            if(h>=barrier){
                barrier=h;
                // realTop
                realTop.add(topList.get(i));
            }
        }
        realTop.add(topList.get(topList.size()-1));

        // realTop 排序，
        Object[] rs = realTop.toArray();
        Arrays.sort(rs);

        for(int i=0;i<rs.length-1;i++){
            size += poolSize((int)rs[i],(int)rs[i+1],height);
        }
        return size;
    }


    // 找出[left,right]区间的积水
    public int poolSize(int left,int right,int[] height){
        int size = 0;
        if(height[left]<=height[right]){
            for(int i=left+1;i<right;i++){
                if(height[i]>=height[left]){
                    break;
                }
                size += height[left] - height[i];
            }
        }else{
            for(int i=right-1;i>left;i--){
                if(height[i]>=height[right]){
                    break;
                }
                size += height[right]-height[i];
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] height = new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};

        Q42_trap q = new Q42_trap();
        q.trap(height);

    }

}
