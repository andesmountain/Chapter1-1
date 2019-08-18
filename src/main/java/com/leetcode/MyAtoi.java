package com.leetcode;


/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/8/12
 * 公司：北京活力天汇<br>
 **/
public class MyAtoi {

    public static int myAtoi(String str) {
        boolean init = false;
        boolean pos = true;
        int rs = 0;
        for(int i=0;i<str.length();i++){
            String word = str.charAt(i)+"";
            if(!init){
                // 还未找到数字
                if(" ".equals(word)){
                    continue;
                }
                if("-".equals(word) || "+".equals(word)){
                    init =true;
                    pos = "-".equals(word)?false:true;
                    continue;
                }
                if(!Character.isDigit(str.charAt(i))){
                    // 首先遇到非数字字符串   返回0
                    return 0;
                }else{
                    // 遇到了数字
                    init=true;
                    int pop = Integer.parseInt(word);
                    // 超出了范围
                    if(rs>Integer.MAX_VALUE/10 ||  (rs==Integer.MAX_VALUE/10 && ((pop>7 && pos) || (pop>8 && !pos)))){
                        return pos?Integer.MAX_VALUE:Integer.MIN_VALUE;
                    }
                    rs = rs*10 + pop;
                }
            }else if(init && !Character.isDigit(str.charAt(i))){
                // 数字中断
                return pos?rs:-rs;
            }else{
                // 数字继续
                int pop = Integer.parseInt(word);
                // 超出了范围
                if(rs>Integer.MAX_VALUE/10 ||  (rs==Integer.MAX_VALUE/10 && ((pop>7 && pos) || (pop>8 && !pos)))){
                    return pos?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                rs = rs*10 + pop;
            }
        }
        return pos?rs:-rs;
    }

    public static void main(String[] args) {
        String abc = "   -42";
        System.out.println(myAtoi(abc));
    }
}
