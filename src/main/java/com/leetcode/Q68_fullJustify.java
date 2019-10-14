package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * <p>
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 *
 * @author dell
 * @date 2019/9/20
 * 公司：北京活力天汇<br>
 **/
public class Q68_fullJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        String sumWord = "";
        List<String> rsList = new ArrayList<>();
        while (i < words.length) {
            // sumWord+words[i]
            while (i < words.length && sumWord.length() + words[i].length() <= maxWidth) {
                sumWord += words[i] + " ";
                i++;
            }
            // 去除最后一个空格
            String row = sumWord.substring(0, sumWord.length() - 1);

            String[] arr = row.split(" ");

            // 将row左右两端对齐，最后一行左对齐
            StringBuilder sb = new StringBuilder();
            if (i == words.length || arr.length == 1) {
                // 左对齐   后面补齐空格
                sb.append(row);
                for (int j = row.length(); j < maxWidth; j++) {
                    sb.append(" ");
                }
            } else {


                // 左右两端对齐,n个空格需要划分
                int n = arr.length - 1;
                int abcLen = row.replaceAll(" ", "").length();
                // spaceLen 的空格  等分到n个区域，如果不能等分，左边区域要大些
                int spaceLen = maxWidth - abcLen;

                // 每个区域最少多少个空格
                int splitLen = spaceLen / n;
                int remain = spaceLen % n;
                // 拼接字符串   n == arr.length-1
                for (int j = 0; j < arr.length; j++) {
                    sb.append(arr[j]);
                    if (j < arr.length - 1) {
                        for (int k = 0; k < splitLen + ((j < remain) ? 1 : 0); k++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            rsList.add(sb.toString());
            sumWord = "";
        }

        return rsList;
    }


    public static void main(String[] args) {
        Q68_fullJustify q = new Q68_fullJustify();

        q.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
    }
}
