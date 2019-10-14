package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * @author dell
 * @date 2019/9/11
 * 公司：北京活力天汇<br>
 **/
public class Q46_permute {

    List<List<Integer>> rsList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 初始全为0   用到的标记1，没用到的标记为0
        int[] visited = new int[nums.length];

        revoke(nums,new ArrayList<>(),visited);
        return rsList;

    }

    public void revoke(int[] nums,List<Integer> rs,int[] visited){

        if(rs.size()==nums.length){
            rsList.add(new ArrayList<>(rs));
            return;
        }

        for(int i=0;i<nums.length;i++){
            // 已用过
            if(visited[i]==1){
                continue;
            }
            visited[i]=1;
            rs.add(nums[i]);
            revoke(nums,rs,visited);
            // 回溯，取消上一步增加的 nums[i]
            rs.remove(rs.size()-1);
            visited[i]=0;
        }
    }


    public static void main(String[] args) {
        Q46_permute q= new Q46_permute();

        q.permute(new int[]{1,2,3});
    }


}
