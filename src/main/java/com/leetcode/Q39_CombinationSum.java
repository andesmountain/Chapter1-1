package com.leetcode;

import java.util.*;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * @author dell
 * @date 2019/8/23
 * 公司：北京活力天汇<br>
 **/
public class Q39_CombinationSum {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combine(candidates,candidates.length-1,target,new ArrayList<>());
        return lists;
    }


    public void combine(int[] candidates, int right, int target,    List<Integer> solution){
        int value = candidates[right];
        int i=0;
        if(right==0){
            if(target%value==0){
                List<Integer> clone = new ArrayList<>(solution);
                for (int k = 0; k < target/value; k++) {
                    clone.add(value);
                }
                lists.add(clone);
            }
        }else {
            while (i * value <= target) {
                int remain = target - i * value;
                List<Integer> clone = new ArrayList<>(solution);
                for (int k = 0; k < i; k++) {
                    clone.add(value);
                }
                if (remain == 0) {
                    lists.add(clone);
                } else {
                    combine(candidates, right - 1, remain, clone);
                }
                i++;
            }
        }

    }

    public static void main(String[] args) {
        Q39_CombinationSum q = new Q39_CombinationSum();
        q.combinationSum(new int[]{2,3,5},8);

    }

}
