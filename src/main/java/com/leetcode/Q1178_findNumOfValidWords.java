package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 * @author dell
 * @date 2019/9/5
 * 公司：北京活力天汇<br>
 **/
public class Q1178_findNumOfValidWords {

    public int word2int(String word){
        char[] s=  word.toCharArray();
        int value = 0;
        for(int j=0;j<s.length;j++){
            value = value|1<<(s[j]-'a');
        }
        return value;
    }

    /**
     * 避免超时，得统计words中相同字母的项，如abc,abbcc,acbbb，存个map，key为二进制，表示包含的字母，方便或与计算
     * @param words
     * @param puzzles
     * @return
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> list = new ArrayList<>();

        Map<Integer,Integer> wordMap = new HashMap<>();



        // 1.统计words[]  有哪些字母的出现
        int wordCount = words.length;
        for(int i=0;i<wordCount;i++){
            String word = words[i];
            int value = word2int(word);
            if(wordMap.containsKey(value)){
                wordMap.put(value,wordMap.get(value)+1);
            }else{
                wordMap.put(value,1);
            }
        }

        // 2.分别统计谜面是否包含word中所有出现的字母
        for(int i=0;i<puzzles.length;i++){
            String puzzle = puzzles[i];
            int matchCount=0;
            // 计算谜面对应的二进制
            int puzzleValue = word2int(puzzle);
            int puzzleFirst = 1<<(puzzle.charAt(0)-'a');

            // 那么word应该是属于puzzleValue的有效值排列组合，如puzzleValue=10101  那么word的value可以为  10101,10100,10000,00101,00100,00001 等
            for(int j=puzzleValue;j>=1;j=puzzleValue&(j-1)){
                // word包含puzzle首字母，且word所有字母属于puzzle
                if(puzzleFirst==(j&puzzleFirst)  &&  wordMap.containsKey(j)){
                    matchCount +=wordMap.get(j);
                }
            }
            list.add(matchCount);
        }
        return list;
    }


    public static void main(String[] args) {

        Q1178_findNumOfValidWords q= new Q1178_findNumOfValidWords();
        q.findNumOfValidWords(new String[]{"apple","pleas","please"},new String[]{"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"});
    }

}
