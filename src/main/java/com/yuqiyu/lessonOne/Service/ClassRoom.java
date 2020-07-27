package com.yuqiyu.lessonOne.Service;

import com.yuqiyu.lessonOne.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author zhuyinkui
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年07月08日 10:08:00
 */
@Component
public class ClassRoom {

    @Autowired
    public ClassRoom(Student student){
        System.out.println(student.getStuName());
    }
}
