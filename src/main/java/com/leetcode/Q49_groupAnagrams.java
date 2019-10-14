package com.leetcode;

import java.util.*;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * @author dell
 * @date 2019/9/16
 * 公司：北京活力天汇<br>
 **/
public class Q49_groupAnagrams {
    // 字母重排序
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>  rsMap = new HashMap<>();
        List<List<String>> rsList = new ArrayList<>();
        for(String str:strs){
            char[] arrc = str.toCharArray();
            Arrays.sort(arrc);
            // 重排序
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<arrc.length;i++){
                sb.append(arrc[i]);
            }
            if(rsMap.containsKey(sb.toString())){
                List<String> list = rsMap.get(sb.toString());
                list.add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                rsMap.put(sb.toString(),list);
            }
        }

        for(Map.Entry<String,List<String>> entry:rsMap.entrySet()){
            rsList.add(entry.getValue());
        }
        return rsList;
    }

    public static void main(String[] args) {
        Q49_groupAnagrams q = new Q49_groupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        q.groupAnagrams(strs);

    }

}
