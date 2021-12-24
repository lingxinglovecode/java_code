package com.lianxing.spring5.testdemo;

import com.lianxing.spring5.Book;
import com.lianxing.spring5.Orders;
import com.lianxing.spring5.User;
import com.lianxing.spring5.bean.Dept;
import com.lianxing.spring5.bean.Emp;
import com.lianxing.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lianxing
 * @description
 * @create 2021-10-28 18:03
 */
public class testSpring5 {

    @Test
    public void testAdd(){
        //1 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2 获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();
    }

    @Test
    public void testBook(){
        //1 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2 获取配置创建的对象
        Book book = context.getBean("book", Book.class);

        System.out.println(book);

    }

    @Test
    public void testOrders(){
        //1 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2 获取配置创建的对象
        Orders orders = context.getBean("orders", Orders.class);

        System.out.println(orders);

    }

    @Test
    public void testBean(){
        //1 加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2 获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();


    }

    @Test
    public void testEmp(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);


    }

}
