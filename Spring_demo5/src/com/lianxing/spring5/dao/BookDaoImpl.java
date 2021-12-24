package com.lianxing.spring5.dao;

import com.lianxing.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-11-20 21:54
 */
@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addBook(Book book) {
//        创建sql语句
        String sql = "insert into t_book values(?,?,?)";
        Object[] args = {book.getUserId(), book.getUserName(),book.getUstatus()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void deleteBookById(int id) {
        String sql = "DELETE FROM t_book WHERE user_id=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);

    }

    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set username=?,ustatus=? where user_id=?";
        Object[] args = {book.getUserName(),book.getUstatus(),book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }





    public int selectCount(){
        String sql = "select count(*) from t_book";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);

        return integer;
    }

    @Override
    public Book findBookInfo(int id) {

        String sql = "select * from t_book where user_id=?";

        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_book ";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into t_book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));

    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update t_book set username=?,ustatus=? where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDeleteBook(List<Object[]> bookIds) {
        String sql = "DELETE FROM t_book WHERE user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, bookIds);
        System.out.println(Arrays.toString(ints));
    }


}
