package com.lianxing.spring5.test;

import com.lianxing.spring5.entity.Book;
import com.lianxing.spring5.service.BookService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-11-21 11:25
 */
public class TestBook {


    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book(5678,"hisbook","in");
        bookService.addBook(book);


    }

    @Test
    public void testDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.deleteBookById(1234);
    }

    @Test
    public void testUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book(1234,"dddd","dont_know");
        bookService.updateBook(book);
    }


    @Test
    public void query(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        int i = bookService.countBook();
        System.out.println(i);
    }

    @Test
    public void queryBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book bookInfo = bookService.findBookInfo(1234);
        System.out.println(bookInfo);
    }

    @Test
    public void queryBooks(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Book> all = bookService.findAll();
        System.out.println(all);
    }


    @Test
    public void batchAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {34,"大大","not"};
        Object[] o2= {21,"小小","n"};
        Object[] o3 = {90,"种太阳","y"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchAdd(batchArgs);
    }

    @Test
    public void batchUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"net","not",34};
        Object[] o2= {"java","n",21};
        batchArgs.add(o1);
        batchArgs.add(o2);
        bookService.batchUpadate(batchArgs);
    }

    @Test
    public void batchDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {34};
        Object[] o2= {21};
        batchArgs.add(o1);
        batchArgs.add(o2);
        bookService.batchDelete(batchArgs);
    }

}
