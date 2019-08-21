package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1163_LastSubstring {
    public static String lastSubstring(String s) {
        int max = 0;
        List<Integer> list = new ArrayList<>();
        int sub= 1;
        for(int i=0;i<s.length();i++){
            int asc = (int)s.charAt(i);
            if(asc==max){
                if(list.size()>0){
                    int last = list.get(list.size()-1);
                    if(i-last==sub){
                        sub++;
                    }else{
                        list.add(i);
                        sub=1;
                    }
                }


            }
            if(asc>max){
                max = asc;
                list.clear();
                list.add(i);
            }
        }
        if(list.size()==1){
            return s.substring(list.get(0));
        }else{
            return revoke(list,1,s);

        }
    }

    public static String revoke(List<Integer> list,int n,String s){
        int sec = 0;
        List<Integer> rsIndex = new ArrayList<>();


        for(int i=0;i<list.size();i++){
            int index = list.get(i);
            int c= 0;
            if(index<s.length()-1){
                c = (int)s.charAt(index+1);
                if(sec<c){
                    sec = c;
                    rsIndex.clear();
                    rsIndex.add(index+1);
                }else if(sec==c){
                    rsIndex.add(index+1);
                }
            }
        }
        if(rsIndex.size()==1){
            return s.substring(rsIndex.get(0)-n);
        }else{
            n ++;
            return  revoke(rsIndex,n,s);
        }
    }

    public static void main(String[] args) {
        System.out.println(lastSubstring("aaaaaaaa"));

    }
}
