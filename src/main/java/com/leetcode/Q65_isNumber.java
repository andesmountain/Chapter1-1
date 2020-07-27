package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 *
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 *
 * @author dell
 * @date 2019/9/19
 * 公司：北京活力天汇<br>
 **/
public class Q65_isNumber {
    public boolean isNumber2(String s) {
        if(s==null||s.length()==0) return false;
        boolean numSeen=false;
        boolean dotSeen=false;
        boolean eSeen=false;
        char arr[]=s.trim().toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]>='0'&&arr[i]<='9'){
                numSeen=true;
            }else if(arr[i]=='.'){
                if(dotSeen||eSeen){
                    return false;
                }
                dotSeen=true;
            }else if(arr[i]=='E'||arr[i]=='e'){
                if(eSeen||!numSeen){
                    return false;
                }
                eSeen=true;
                numSeen=false;
            }else if(arr[i]=='+'||arr[i]=='-'){
                if(i!=0&&arr[i-1]!='e'&&arr[i-1]!='E'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return numSeen;
    }

    /**
     * 1.e 后面可以是正数或者负数，但不能是小数或为空，e前面可以是任意数字
     * 2.正负号只能在最前面或者e的后面
     * 3.
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        char[] arr =s.toCharArray();
        int i=0;
        while(i<arr.length){
            // 空格直接略过
            if(arr[i]==' '){
                i++;
                continue;
            }
            // 数字0后面只能是0或者e，前面只能是数字或者小数点
            if(arr[i]=='0'){
                if(i==0){
                    return false;
                }else if(arr[i-1]!='.' && (arr[i-1]<'0' || arr[i-1]>'9')){
                    return false;
                }else if(i<arr.length-1 && arr[i+1]!='0' && arr[i+1]!='e'){
                    return false;
                }
                i++;
                continue;
            }

            // 不能出现abc等字符
            if(arr[i]<'0' && arr[i]>'9' && arr[i]!='e' && arr[i]!='.' && arr[i]!='+' && arr[i]!='-'){
                return false;
            }
            // 正负号
            if(arr[i]=='+' || arr[i]=='-'){
                if(i!=0 && arr[i-1]!='e' && arr[i-1]!='E'){
                    return false;
                }
            }
            // e出现的位置
            if(arr[i]=='e'){
                if(i==0 || i==arr.length-1){
                    return false;
                }else if(arr[i-1]<'0' && arr[i-1]>'9'){
                    return false;
                }
            }

        }
        return true;
    }

    private boolean isNum(char c){
        return c>='0' && c<='9';
    }


    public static void main(String[] args) {
        Q65_isNumber q = new Q65_isNumber();
        boolean b= q.isNumber2("012");
    }

}
