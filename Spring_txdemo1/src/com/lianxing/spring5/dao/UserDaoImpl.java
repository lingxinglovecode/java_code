package com.lianxing.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author lianxing
 * @description
 * @create 2021-11-22 21:04
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public void addMoney(int money,String userId) {
        String sql = "update t_account set money=money-? where id=?";
        jdbcTemplate.update(sql,money,userId);
    }

    @Override
    public void reduceMoney(int money,String userId) {
        String sql = "update t_account set money=money+? where id=?";
        jdbcTemplate.update(sql,money,userId);

    }
}
