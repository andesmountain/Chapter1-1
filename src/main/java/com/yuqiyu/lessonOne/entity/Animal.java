package com.yuqiyu.lessonOne.entity;

/**
 * @author zhuyinkui
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年06月02日 11:27:00
 */
public abstract class Animal {
    public abstract Dog createDog();

    private Dog dog;

    public Dog getDog(){
        return this.dog;
    }

    public String oldName(String name){
        System.out.println("old Name="+name);
        return name;
    }

    // 必须是无参数的方法，类比于afterPropertiesSet方法
    public final void init(){
        System.out.println("init method");
    }

    public final void destroy(){
        System.out.println("destroy method");
    }

    public void setDog(Dog dog){
        this.dog = dog;
    }
}
