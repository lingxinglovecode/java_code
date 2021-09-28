package com.lianxing.service.impl;

import com.lianxing.dao.BookDao;
import com.lianxing.dao.impl.BookDaoImpl;
import com.lianxing.pojo.Book;
import com.lianxing.service.BookService;

import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-09-26 11:03
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deletBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
