package com.niuke.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * 小Q的公司最近接到m个任务, 第i个任务需要xi的时间去完成, 难度等级为yi。
 * 小Q拥有n台机器, 每台机器最长工作时间zi, 机器等级wi。
 * 对于一个任务,它只能交由一台机器来完成, 如果安排给它的机器的最长工作时间小于任务需要的时间, 则不能完成,如果完成这个任务将获得200 * xi + 3 * yi收益。
 *
 * 对于一台机器,它一天只能完成一个任务, 如果它的机器等级小于安排给它的任务难度等级, 则不能完成。
 *
 * 小Q想在今天尽可能的去完成任务, 即完成的任务数量最大。如果有多种安排方案,小Q还想找到收益最大的那个方案。小Q需要你来帮助他计算一下。
 *
 *
 * @author dell
 * @date 2019/11/6
 * 公司：北京活力天汇<br>
 **/
public class ScheduleMachine {
    public int benefit(int n, int m, List<int[]> zwList,List<int[]> xyList){
        // 不管是哪台机器完成了某任务，那么这个任务收益是固定的，所以一定要选刚好能满足任务的机器
        // 在保证完成更多任务的情况下，同时，要挑选任务，选那种收益更高的任务做

        int sumTask = 0;
        int bf = 0;
        // if m>n  则最多只能做n个任务 ；  if m<=n  最多能做m个任务

        for(int[] xy:xyList){
            int xi = xy[0];
            int yi = xy[1];

            bf += 200*xi+3*yi;

        }
        return 0;
    }

    public int loop(List<int[]> zwList,List<int[]> xyList,List<int[]> rsList){
        for(int[] xy:xyList){
            int xi = xy[0];
            int yi = xy[1];
            for(int[] zw:zwList){
                int zi = zw[0];
                int wi = zw[1];
                // 表示机器可以运行这个任务，当然我也可以不运行啊
                if(zi>=xi && wi>=yi){
                    List<int[]> zwCopy = new ArrayList<>(zwList);
                    zwCopy.remove(zw);
                    List<int[]> xyCopy = new ArrayList<>(xyList);
                    xyCopy.remove(xy);
                    rsList.add(new int[]{xi,yi,zi,wi});
                    loop(zwCopy,xyCopy,rsList);
                }
            }
        }
        return 0;

    }


    public static void main(String[] args) {

    }

}
