package com.lianxing.test;

import com.lianxing.pojo.Book;
import com.lianxing.service.BookService;
import com.lianxing.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author lianxing
 * @description
 * @create 2021-09-26 11:05
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"国歌","你好",new BigDecimal(1213),12,0,null));

    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"国歌","我不好",new BigDecimal(1213),12,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        System.out.println(bookService.queryBooks());
        for (Book book: bookService.queryBooks()){
            System.out.println(book);
        }
    }
}