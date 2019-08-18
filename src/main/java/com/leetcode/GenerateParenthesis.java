package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * generateParenthesis
 * n=3
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n==1){
            list.add("()");
            return list;
        }
        // 左括号必须》0，多一个右括号就和左括号抵消
        String sb= "(";
        revoke(1,0,n,sb,list);
        System.out.println(list);
        return list;
    }


    public static void revoke(int left,int right,int n,String sb,List<String> list){
        if(sb.length()==2*n){
            list.add(sb);
            return;
        }
        if(left>right){
            revoke(left,right+1,n,sb+")",list);
        }
        if(left<n){
            revoke(left+1,right,n,sb+"(",list);
        }

    }

    public static List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis2(c))
                    for (String right: generateParenthesis2(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }


    public static List<String> generateParenthesis3(int n) {
        List<List<String>> list = new LinkedList<>();
        if(n==0){
            return list.get(0);
        }

        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        list.add(list0);
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("()");
        list.add(list1);

        for(int i=1;i<=n;i++){
            // 输入n时，对应的所有括号排列组合
            LinkedList<String> temp = new LinkedList<String>();
            for(int k=0;k<=i;k++){
                int left = k;
                int right=i-left;
                List<String> leftList =  list.get(k);
                List<String> rightList = list.get(right);
                for (String s1 : leftList) {
                    for (String s2 : rightList) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }
            }
            list.add(temp);
        }
        return list.get(n);

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis3(5));
    }
}
