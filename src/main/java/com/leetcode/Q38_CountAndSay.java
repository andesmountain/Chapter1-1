package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1
 * 11
 * 21
 * 1211
 * 111221
 * @author dell
 * @date 2019/8/23
 * 公司：北京活力天汇<br>
 **/
public class Q38_CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for(int i=1;i<n;i++){
           s=  say(s);
        }
        return s;
    }


    public String say(String s){
        StringBuilder sb=  new StringBuilder();
        char init = s.charAt(0);
        int repl = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==init){
                repl++;
            }else{
                sb.append(repl).append(init);
                init = s.charAt(i);
                repl=1;
            }
        }
        // 添加最后一个数
        sb.append(repl).append(init);

        return sb.toString();
    }

    public static void main(String[] args) {
        Q38_CountAndSay q=  new Q38_CountAndSay();
        q.countAndSay(5);
    }
}
