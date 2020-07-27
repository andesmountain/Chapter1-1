package com.yuqiyu.lessonOne;

import com.yuqiyu.lessonOne.config.PersonConfig;
import com.yuqiyu.lessonOne.entity.Animal;
import com.yuqiyu.lessonOne.entity.Dog;
import com.yuqiyu.lessonOne.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest1 {
    /**
     *  merge V1.0
     *  -- reking  rebase 合并
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

        // 获取的是属性 dog,Dog的作用域虽然是prototype，但是通过Setter方法注入的Dog返回的仍然是同一个对象
        Dog dog1 = ((Animal)cac.getBean("animal")).getDog();
        Dog dog2 = ((Animal)cac.getBean("animal")).getDog();

        System.out.println(dog1==dog2);

        // 获取createDog()方法返回的值,通过lookup-method注入的Dog，每次返回的都是不同的对象，符合prototype的概念。
        Dog dog3 = ((Animal)cac.getBean("animal")).createDog();
        Dog dog4 = ((Animal)cac.getBean("animal")).createDog();

        System.out.println(dog3==dog4);

        System.out.println(((Animal) cac.getBean("animal")).oldName("wwww"));

        cac.close();
        System.out.println("main 方法结束");



    }
}
