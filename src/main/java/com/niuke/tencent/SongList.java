package com.niuke.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/11/6
 * 公司：北京活力天汇<br>
 **/
public class SongList {
    public static final int ASD = 1000000007;
    public static int[][] dp = new int[101][101];
    public static void main(String[] args) {
        SongList  s=  new SongList();
        dp = s.getDelta();
        s.getAllMethods(205,1,92,4,92);
    }

    // x个a，y个b，怎么排列组合变成k，不计前后顺序
    public long getAllMethods(int k,int a,int x ,int b, int y){
        int anum=0;
        int bnum=0;
        long total = 0;
        List<int[]> rsList = new ArrayList<>();
        while(anum<=x){
            if(k<anum*a){
                break;
            }
            if((k-anum*a)%b==0){
                bnum = (k-anum*a)/b;
                if(bnum<=y) {
                    total += (long)dp[x][anum]*(long)dp[y][bnum];
                    total = total%ASD;
                }
            }
            anum++;
        }
        System.out.println(total);
        return total;
    }


    // n个球里取m个   有多少种取法   这个是绝对核心方法！！！
    public int[][] getDelta(){
        int[][] dp = new int[101][101];
        dp[0][0] = 1;
        for(int i=1;i<=100;i++){
            // 核心步骤
            dp[i][0]=1;
            for(int j=1;j<=100;j++){
                dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%ASD;
            }
        }
        return dp;

    }
}
