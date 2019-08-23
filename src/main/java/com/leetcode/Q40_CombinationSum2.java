package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 数组中的值可重复
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * @author dell
 * @date 2019/8/23
 * 公司：北京活力天汇<br>
 **/
public class Q40_CombinationSum2 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combine(candidates,candidates.length-1,target,new ArrayList<>());
        return lists;
    }


    public void combine(int[] candidates, int right, int target,    List<Integer> solution){
        int value = candidates[right];
        if(target==0){
            lists.add(new ArrayList<>(solution));
        }
        if(right==0){
            if(target==value){
                List<Integer> clone = new ArrayList<>(solution);
                clone.add(value);
                lists.add(clone);
            }
        }else {
            int i=0;
            while (i * value <= target && i<=1) {
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
        Q40_CombinationSum2 q = new Q40_CombinationSum2();
        q.combinationSum2(new int[]{10,1,2,7,6,1,5},8);

    }

}
