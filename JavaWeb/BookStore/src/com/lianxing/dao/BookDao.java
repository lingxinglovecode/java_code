package com.lianxing.dao;

import com.lianxing.pojo.Book;

import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-09-26 10:11
 */
public interface BookDao {

    public int addBook(Book book);

    public int deletBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();



}
