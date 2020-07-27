package com.yuqiyu.lessonOne.entity;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author zhuyinkui
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年06月18日 11:20:00
 */
public class ReplaceOldName implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("new name="+args[0]);
        return "new "+args[0];
    }
}
