package com.yuqiyu.lessonOne.entity;

import lombok.Data;

@Data
public class Person {
    String name;
    Integer age;


    Student stu;

    public Person(String name ,Integer age){
        this.name= name;
        this.age = age;
        System.out.println("Person 结构化");
    }

    public void init(){
        System.out.println("Person init");
    }
}
