package com.lianxing.dao.impl;

import com.lianxing.dao.BookDao;
import com.lianxing.pojo.Book;

import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-09-26 10:26
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book( `name` , `author` , `price` , `sales` , `stock` , `img_path`) " +
                "VALUES(?,?,?,?,?,?);";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deletBookById(Integer id) {
        String sql = "delete  from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=? , `author`=? , `price`=? , `sales`=? , `stock`=? , `img_path`=? where id=?" ;
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Long number = (Long) queryForValue(sql);
//        Number number = (Number) queryForValue(sql);
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";

        return queryForList(Book.class,sql, begin, pageSize);
    }
}
