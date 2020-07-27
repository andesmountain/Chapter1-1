package com.yuqiyu.lessonOne.config;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Node;

/**
 * @author zhuyinkui
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年12月26日 15:21:00
 */
public class JackNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("redis", new JackAdviceParser());
    }

    @Override
    public BeanDefinitionHolder decorate(Node node, BeanDefinitionHolder definition, ParserContext parserContext) {
        return super.decorate(node, definition, parserContext);
    }
}
