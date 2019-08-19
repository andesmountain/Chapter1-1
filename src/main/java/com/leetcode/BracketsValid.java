package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *  '('，')'，'{'，'}'，'['，']'
 *  字符串只包含上述字符
 *  "([)]"  false
 *  "{[]}" true
 * @author dell
 * @date 2019/8/15
 * 公司：北京活力天汇<br>
 **/
public class BracketsValid {

    public static boolean isValid(String s) {
        if(s==null || "".equals(s)){
            return true;
        }
        int size =s.length();
        // 必须是奇数，否则无法闭合
        if(size%2==1){
            return false;
        }


        // 必须左括号开始，最右的括号必须先结束在对应反括号结束前，不能插入其他反括号
        // 说白了就是一个先进后出的栈
        Stack<Character> stack  = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(')');
            }else if(s.charAt(i)=='{'){
                stack.push('}');
            }else if(s.charAt(i)=='['){
                stack.push(']');
            }else{
                if(stack.size()==0 || stack.pop()!=s.charAt(i)){
                    return false;
                }
            }
        }

        if(stack.size()!=0){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}
