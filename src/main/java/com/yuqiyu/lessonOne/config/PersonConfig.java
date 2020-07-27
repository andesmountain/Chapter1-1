package com.yuqiyu.lessonOne.config;

import com.yuqiyu.lessonOne.entity.Person;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value = "com.yuqiyu.lessonOne",includeFilters = {
        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Component.class})
},useDefaultFilters = true)
public class PersonConfig {
    @Bean(value = "ppp",initMethod = "init")
    @Lazy
    public Person person(){
        return new Person("yinli",29);
    }

    @Bean
    public BeanPostProcessor myBeanPostProcessor(){
        return  new MyBeanPostProcessor();
    }

}
