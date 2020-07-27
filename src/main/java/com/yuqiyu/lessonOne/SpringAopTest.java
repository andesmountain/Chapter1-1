package com.yuqiyu.lessonOne;


import com.yuqiyu.cas.RwLock;
import com.yuqiyu.lessonOne.Service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopTest {

    public static void main(String[] args) {

        // 启动 Spring 的 IOC 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean-aop.xml");

        PersonService personService = context.getBean(PersonService.class);

        personService.queryPerson();

    }
}
