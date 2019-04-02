package com.yuqiyu.lessonOne.config;

import com.yuqiyu.lessonOne.entity.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value = "com.yuqiyu.lessonOne",includeFilters = {
        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Service.class})
},useDefaultFilters = false)
public class PersonConfig {
    @Bean("ppp")
    @Lazy
    public Person person(){
        return new Person("yinli",29);
    }
}
