package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出 [[1,5],[6,9]]
 *
 * intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * [[1,2],[3,10],[12,16]]
 * @author dell
 * @date 2019/9/17
 * 公司：北京活力天汇<br>
 **/
public class Q57_insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int[][] abc=  new int[intervals.length+1][2];
        for(int k=0;k<intervals.length;k++){
            abc[k] = intervals[k];
        }
        abc[intervals.length] = newInterval;

        if (abc == null || abc.length == 0)
            return res.toArray(new int[0][]);

        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);// a[0] - b[0]大于0就交换顺序
        // 根据二维数组第一个数字大小按每一行整体排序
        Arrays.sort(abc, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < abc.length) {
            int left = abc[i][0];
            int right = abc[i][1];
            // i不能到最后一行,所以要小于(数组的长度 - 1)
            // 判断所在行的right和下一行的left大小,对right重新进行赋最大值,之后再不断进行while循环判断
            while (i < abc.length - 1 && right >= abc[i + 1][0]) {
                i++;
                right = Math.max(right, abc[i][1]);
            }
            res.add(new int[] { left, right });
            i++;
        }
        return res.toArray(new int[0][]);

    }

    public static void main(String[] args) {
        Q57_insert q= new Q57_insert();
        q.insert(new int[][]{{1,5}},new int[]{6,8});
    }

}
