package com.yuqiyu.lessonOne;

import com.yuqiyu.lessonOne.config.PersonConfig;
import com.yuqiyu.lessonOne.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest1 {
    /**
     * checkout king
     * @param args
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cac = new ClassPathXmlApplicationContext("beans.xml");

        AnnotationConfigApplicationContext aac = new AnnotationConfigApplicationContext(PersonConfig.class);

        for(String a: aac.getBeanDefinitionNames()){
            System.out.println(a);
        }

        Person p =(Person) cac.getBean("person");
        Person p2 = (Person) aac.getBean("ppp");

        System.out.println(p.toString());

        System.out.println(p2.toString());

    }
}
