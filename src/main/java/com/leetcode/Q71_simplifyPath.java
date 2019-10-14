package com.leetcode;

import java.util.Stack;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 *
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 *
 * @author dell
 * @date 2019/9/23
 * 公司：北京活力天汇<br>
 **/
public class Q71_simplifyPath {


    /**
     * 1. / 后面只能有一个/
     * 2. 结尾不能是 /
     * 3. 根目录无法再往上一级
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> absolute  = new Stack<>();

        String[] arr = path.split("/");
        int n = arr.length;
        int i=0;
        while(i<n){
            if(!arr[i].isEmpty()){
                String folder = arr[i];
                // .. , .   , abc
                if("..".equals(folder)){
                    if(!absolute.isEmpty())
                        absolute.pop();
                }else if(".".equals(folder)){
                    // do nothing;
                }else{
                    absolute.push(folder);
                }
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        if(absolute.isEmpty()){
            return "/";
        }
        for(int j=0;j<absolute.size();j++){
            sb.append("/"+absolute.get(j));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q71_simplifyPath q = new Q71_simplifyPath();

        q.simplifyPath("/../");
    }
}
