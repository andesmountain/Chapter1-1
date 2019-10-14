package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @author dell
 * @date 2019/9/11
 * 公司：北京活力天汇<br>
 **/
public class Q47_permuteUnique {

    List<List<Integer>> rsList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
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

        Set<Integer> used = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            // 已用过
            if(visited[i]==1){
                continue;
            }

            if(used.contains(nums[i])){
                continue;
            }else{
                used.add(nums[i]);
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

        Q47_permuteUnique q= new Q47_permuteUnique();

        q.permuteUnique(new int[]{1,1,2,3});
    }

}
