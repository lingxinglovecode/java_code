package com.lianxing.spring5.dao;

import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlShowColumnOutpuVisitor;
import com.lianxing.spring5.entity.Book;

import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-11-20 21:53
 */
public interface BookDao {

    public void addBook(Book book);

    public void deleteBookById(int id);

    public void updateBook(Book book);


    public int selectCount();

    public Book findBookInfo(int id);

    public List<Book> findAllBook();

    public void batchAddBook(List<Object[]> book);

    void batchUpdateBook(List<Object[]> batchArgs);

    void batchDeleteBook(List<Object[]> bookIds);;
}
