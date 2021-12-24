package com.lianxing.spring5.testdemo;

import com.lianxing.spring5.Bean.Orders;
import com.lianxing.spring5.autowire.Emp;
import com.lianxing.spring5.collectiontype.Book;
import com.lianxing.spring5.collectiontype.Course;
import com.lianxing.spring5.collectiontype.Stu;
import com.lianxing.spring5.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lianxing
 * @description
 * @create 2021-10-30 16:40
 */
public class TestSpringDemo {

    @Test
    public void testCollection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);


    }

    @Test
    public void testBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);


    }

    @Test
    public void testMyBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        MyBean myBean = context.getBean("myBean", MyBean.class);
        System.out.println(myBean);


    }

    @Test
    public void testMyBean2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);


    }

    //多实例测试
    @Test
    public void testBook2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        System.out.println(book1);
        System.out.println(book2);


    }

    @Test
    public void testMyBean3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取bean对象");
//        System.out.println(orders);

        ((ClassPathXmlApplicationContext)context).close();


    }

    @Test
    public void testBean5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);


    }
}
