package com.leetcode;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author dell
 * @date 2019/9/19
 * 公司：北京活力天汇<br>
 **/
public class Q67_addBinary {
    public String addBinary(String a, String b) {
        // 确保a比b长
        if(a.length()<b.length()){
            return addBinary(b,a);
        }

        // 1,1 变0，且加1    考虑位数不相同
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();


        // 有可能进一位
        int n = aa.length;
        char[] fixb= new char[n];
        for(int i=0;i<n;i++){
            if(i<aa.length-bb.length){
                fixb[i] = '0';
            }else{
                fixb[i] =  bb[i-(aa.length-bb.length)];
            }
        }


        char[] rs = new char[n];
        int add = 0;
        for(int i=n-1;i>=0;i--){
            int anum = aa[i]-48;
            int bnum = fixb[i]-48;
            int sum = anum+bnum+add;
            int remain = sum%2;
            if(sum>=2){
                add=1;
            }else{
                add=0;
            }

            rs[i] = (char) (remain+48);
        }

        if(add==1){
            return "1"+new String(rs);
        }

        return new String(rs);

    }

    public static void main(String[] args) {
        Q67_addBinary q = new Q67_addBinary();
        q.addBinary("11","1");
    }

}
