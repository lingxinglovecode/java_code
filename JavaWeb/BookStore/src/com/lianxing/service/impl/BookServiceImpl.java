package com.lianxing.service.impl;

import com.lianxing.dao.BookDao;
import com.lianxing.dao.impl.BookDaoImpl;
import com.lianxing.pojo.Book;
import com.lianxing.pojo.Page;
import com.lianxing.service.BookService;

import javax.persistence.criteria.CriteriaBuilder;
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

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();


        page.setPageSize(pageSize);

        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //求总页数
        Integer pageTotal = pageTotalCount / pageSize;




        if ( pageTotalCount % pageSize >0 ){
            pageTotal ++;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);
        //设置当前页数据
        int begin = (page.getPageNo()-1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);

        return page;
    }
}
