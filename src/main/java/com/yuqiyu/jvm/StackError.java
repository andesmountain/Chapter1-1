package com.yuqiyu.jvm;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * 报错：java.lang.StackOverflowError
 * @author dell
 * @date 2019/6/11
 * 公司：北京活力天汇<br>
 **/
public class StackError {

    // 死循环，方法不断往栈里插，栈被撑满报 StackOverflowError错误
    public void loop(){
        loop();
    }

    public static void main(String[] args) {
        StackError stack = new StackError();
        stack.loop();
    }
}
