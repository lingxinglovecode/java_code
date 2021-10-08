package com.lianxing.service;

import com.lianxing.pojo.Book;
import com.lianxing.pojo.Page;

import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-09-26 11:00
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();


    Page<Book> page(int pageNo, int pageSize);
}
