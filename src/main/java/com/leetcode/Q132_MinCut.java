package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数。
 *
 * 动态规划
 * @author dell
 * @date 2019/8/19
 * 公司：北京活力天汇<br>
 **/
public class Q132_MinCut {

    public int minCut(String s) {
        // 记录s前i位的字符串，能分割成各回文子串的最小次数，记录下来放在rs[i]中，方便以后使用
        int[] rs = new int[s.length()+1];
        rs[0]=-1;
        rs[1]=0;
        if(s==null || "".equals(s) || s.length()==1){
            return 0;
        }
        for(int i=2;i<=s.length();i++){
            // 动态规划，字符串慢慢变长
            // 最多切i次，将si分隔成 i+1个单字符串，必定是回文子串
            rs[i] = i;
            // 将si分隔成两部分，保证后半部分是一个回文子串，前半部分sj已知可分为回文子串所需最小次数为rs[j]
            // 这样si分成回文子串次数为rs[j]+1,遍历右半部分所有回文子串，找出rs[j]最小次数那个
            for(int j=i-1;j>=0;j--){
                // 右半部分 字符串为  s.substring(j+1,i)
                if(ifPalindrome(s.substring(j,i))){
                    rs[i] = Math.min(rs[j]+1,rs[i]);
                }
            }
        }
        return rs[s.length()];
    }




    public int minCount=Integer.MAX_VALUE;

    /**
     * 判断字符串是不是回文字符串
     * @param s
     * @return
     */
    public boolean ifPalindrome(String s){
        int left =0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }



    /**
     * 这种方法很慢，相当于要遍历所有回文子串的切法
     * 记录之前切的刀数,获取以最左字符开头的所有回文子串可能
     * @param s
     * @param c
     * @return
     */
    @Deprecated
    public int revoke(String s,int c){
        int left =0 ;
        int right= s.length()-1;
        while(right>=left){
            int l=0,r=right;
            // 首尾字符不相等
            if(s.charAt(0)!=s.charAt(r)){
                right--;
                continue;
            }
            // 首尾字符相等
            else {
                while (s.charAt(l) == s.charAt(r) && l < r-1) {
                    l++;
                    r--;
                }
                // 说明left,right之间是回文数
                if (s.charAt(l) == s.charAt(r) && (l == r || l + 1 == r)) {
                    // 已分离出来了一个回文子串
                    if(right<s.length()-1){
                        revoke(s.substring(right+1),c+1);
                    }else{// 已经把所有子串都分隔成了回文串
                        if(c<minCount){
                            minCount=c;
                        }
                        return c;
                    }
                }
                right--;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Q132_MinCut q = new Q132_MinCut();
        System.out.println(q.minCut("aaabaa"));
    }

}
