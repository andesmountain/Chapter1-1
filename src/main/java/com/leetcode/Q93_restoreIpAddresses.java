package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuyinkui
 * @version 1.0.0
 * @Description TODO
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * @createTime 2020年05月22日 15:22:00
 */
public class Q93_restoreIpAddresses {

    public List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s==null || s.length()<4 || s.length()>12){
            return new ArrayList<String>();
        }
        loop(s,0,new ArrayList<>());
        return result;
    }

    public void loop(String s,int startIndex,List<String> list){
        if(list.size()<4){
            int i=1;
            int endIndex;
            while(i<4 && (endIndex=startIndex+i)<=s.length()){
                String str = s.substring(startIndex,endIndex);
                if(verify(str)){
                    list.add(str);
                    loop(s,endIndex,list);
                    list.remove(list.size()-1);
                }
                i++;
            }
        }else if(list.size()==4 && startIndex==s.length()){
            result.add(String.join(".",list));
        }
    }


    public boolean verify(String s){
        if(s.startsWith("0") && s.length()>1){
            return false;
        }
        Integer i = Integer.parseInt(s);
        return i<=255 && i>=0;
    }

    public static void main(String[] args) {
        Q93_restoreIpAddresses q = new Q93_restoreIpAddresses();

        q.restoreIpAddresses("010010");

    }
}
