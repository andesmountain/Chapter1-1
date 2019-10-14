package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * 给你一个字符串 s，请你对 s 的子串进行检测。
 *
 * 每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。 
 *
 * 如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
 *
 * 返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
 *
 * 注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。（另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）
 *
 * @author dell
 * @date 2019/9/5
 * 公司：北京活力天汇<br>
 **/
public class Q1177_canMakePaliQueries {

    // 说白了就是动态规划，统计前n个字符   每个字符的数量
    public List<Boolean> canMakePaliQueries(String ss, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        char[] s = ss.toCharArray();
        int n = s.length;
        int[][] count = new int[n+1][26];
        for (int i = 0; i < n; i++) {
            char c = s[i];
            System.arraycopy(count[i], 0, count[i + 1], 0, 26);
            count[i+1][c-'a']++;
        }
        for (int[] q : queries) {
            int start = q[0], end = q[1], k = q[2], all = end - start + 1;
            int[] cnt = new int[26];
            for (int i = 0; i < 26; i++) {
                cnt[i] = count[end+1][i] - count[start][i];
            }
            int ji = 0;
            for (int x : cnt) {
                if (x % 2 == 1) ji++;
            }
            if (all % 2 == 1) ji--;
            if (ji > 2 * k) {
                res.add(Boolean.FALSE);
            } else {
                res.add(Boolean.TRUE);
            }
        }
        return res;
    }



    public static void main(String[] args) {
        String s ="hunu";
        int[][] arr = new int[][]{{0,3,1},{2,2,1}};
        Q1177_canMakePaliQueries q= new Q1177_canMakePaliQueries();
        q.canMakePaliQueries(s,arr);
    }
}
