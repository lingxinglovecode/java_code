package com.lianxing.spring5.service;

import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlShowColumnOutpuVisitor;
import com.lianxing.spring5.dao.BookDao;
import com.lianxing.spring5.dao.BookDaoImpl;
import com.lianxing.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-11-20 21:54
 */
@Service
public class BookService {

//    注入dao
    @Autowired
    private BookDao bookDao;


    public void addBook(Book book){
        bookDao.addBook(book);
    }
    public void updateBook(Book book){
        bookDao.updateBook(book);
    }
    public void deleteBookById(int id){
        bookDao.deleteBookById(id);
    }

    public int countBook(){
        return bookDao.selectCount();
    }

    public Book findBookInfo(int id){
        return bookDao.findBookInfo(id);
    }


    public List<Book> findAll(){
        return bookDao.findAllBook();
    }

    public void batchAdd(List<Object[]> batchArgs){
        bookDao.batchAddBook(batchArgs);
    }

    public void batchUpadate(List<Object[]> batchArgs){
        bookDao.batchUpdateBook(batchArgs);
    }

    public void batchDelete(List<Object[]> batchArgs){
        bookDao.batchDeleteBook(batchArgs);
    }

}
