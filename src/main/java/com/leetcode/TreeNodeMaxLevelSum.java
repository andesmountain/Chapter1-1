package com.leetcode;

import com.yuqiyu.map.HashMapTest;

import java.util.HashMap;
import java.util.Map;

public class TreeNodeMaxLevelSum {
    public static int maxLevelSum(TreeNode root) {
        // key=行数，value为行数和
        Map<Integer,Integer> rs = new HashMap();
        rs.put(1,root.val);
        revoke(rs,1,root);

        int max=0;
        int k = 0;
        for(Integer i:rs.keySet()){
            if(rs.get(i)>max){
                max = rs.get(i);
                k = i;
            }
        }
        return k;
    }

    public static void revoke(Map<Integer,Integer> rs,int n,TreeNode root){
        int l=0,r=0;
        if(root.left!=null){
            l =root.left.val;
        }
        if(root.right!=null){
            r = root.right.val;
        }
        if(root.left==null && root.right==null){
            return;
        }

        if(rs.containsKey(n+1)){
            rs.put(n+1,rs.get(n+1)+l+r);
        }else{
            rs.put(n+1,l+r);
        }
        if(root.left!=null)
        revoke(rs,n+1,root.left);
        if(root.right!=null)
        revoke(rs,n+1,root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(989);
        root.left=new TreeNode(7);
        root.right=new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right=new TreeNode(-8);

        maxLevelSum(root);
    }
}


 class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }