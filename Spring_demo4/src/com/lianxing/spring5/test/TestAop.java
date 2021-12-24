package com.lianxing.spring5.test;

import com.lianxing.spring5.aopannotation.User;
import com.lianxing.spring5.aopannotation.UserProxy;
import com.lianxing.spring5.aopxml.Book;
import com.lianxing.spring5.config.ConfigAop;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lianxing
 * @description
 * @create 2021-11-14 18:57
 */
public class TestAop {


    @Test
    public void testAopanno(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();


    }

    @Test
    public void testAopxml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }

    @Test
    public void testAopFullAnno(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigAop.class);
        User user = context.getBean("user", User.class);
        user.add();
    }
}
