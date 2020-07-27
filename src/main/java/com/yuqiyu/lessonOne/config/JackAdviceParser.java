package com.yuqiyu.lessonOne.config;

import com.yuqiyu.lessonOne.entity.Person;
import com.yuqiyu.lessonOne.entity.Student;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author zhuyinkui
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年12月26日 15:23:00
 */
public class JackAdviceParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return Student.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("stuName");
        String gender = element.getAttribute("gender");
        System.out.println("stuName:"+name);
        System.out.println("gender:"+gender);
        builder.addConstructorArgValue(name);
        builder.addConstructorArgValue(gender);
    }
}
