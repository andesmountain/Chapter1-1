package com.yuqiyu.lessonOne.Service;

import com.yuqiyu.lessonOne.entity.Person;

public class PersonServiceImp implements PersonService {
    @Override
    public Person queryPerson() {
        return new Person("abc",12);
    }
}
