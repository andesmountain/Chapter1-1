package com.yuqiyu.lessonOne.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author zhuyinkui
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年12月26日 15:25:00
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD})
public @interface Jack {
    String name();
}
