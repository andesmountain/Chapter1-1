package com.yuqiyu.lessonOne.entity;

import lombok.Data;

@Data
public class Student {
    private String stuName;
    private String gender;
    public Student(String stuName,String gender){
        this.stuName=stuName;
        this.gender=gender;
    }
}
