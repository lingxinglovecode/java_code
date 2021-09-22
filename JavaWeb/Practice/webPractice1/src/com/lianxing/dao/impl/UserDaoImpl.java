package com.lianxing.dao.impl;

import com.lianxing.dao.UserDao;
import com.lianxing.pojo.User;

/**
 * @author lianxing
 * @description
 * @create 2021-09-21 13:22
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryById(int id) {
        String sql = "select * from t_user where id=?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public User queryByUsername(String username) {
        String sql = "select * from t_user where username=?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public int deleteUserByUsername(String username) {
        String sql = "delete t_user from t_user where username=?";
        return update(sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }
}
