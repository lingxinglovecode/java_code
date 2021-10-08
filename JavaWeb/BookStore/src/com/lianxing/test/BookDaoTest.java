package com.lianxing.test;

import com.lianxing.dao.BookDao;
import com.lianxing.dao.impl.BookDaoImpl;
import com.lianxing.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lianxing
 * @description
 * @create 2021-09-26 10:39
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        Book newBook = new Book(null,"lingxing","xingxing",new BigDecimal(123),12332,0,null);
        bookDao.addBook(newBook);

    }

    @Test
    public void deletBookById() {
        bookDao.deletBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"大家都可以这么帅","xingxing",new BigDecimal(123),12332,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));

    }

    @Test
    public void queryBooks() {
        for(Book queryBook:bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {

        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(bookDao.queryForPageItems(4,8));


    }

}