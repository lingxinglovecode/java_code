package com.lianxing.test;

import com.lianxing.dao.UserDao;
import com.lianxing.dao.impl.UserDaoImpl;
import com.lianxing.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lianxing
 * @description
 * @create 2021-09-18 16:15
 */
public class UserDaoImplTest {
    UserDaoImpl dao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
//        UserDaoImpl dao = new UserDaoImpl();


        System.out.println(dao.queryUserByUsername("admin"));
    }

    @Test
    public void savaUser() {
        dao.savaUser(new User(null,"lianxing1","lianxing","dad"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(dao.queryUserByUsernameAndPassword("admin","admin"));
    }
}