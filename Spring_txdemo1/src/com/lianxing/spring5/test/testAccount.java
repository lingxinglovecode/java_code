package com.lianxing.spring5.test;

import com.lianxing.spring5.config.TxConfig;
import com.lianxing.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lianxing
 * @description
 * @create 2021-11-22 21:14
 */
public class testAccount {

    @Test
    public void testUser(){
         ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();


    }


    @Test
    public void testUser2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();


    }

    @Test
    public void testUser3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();


    }
}
