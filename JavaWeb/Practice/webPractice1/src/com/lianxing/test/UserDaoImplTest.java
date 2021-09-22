package com.lianxing.test;

import com.lianxing.dao.impl.UserDaoImpl;
import com.lianxing.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lianxing
 * @description
 * @create 2021-09-21 13:32
 */
public class UserDaoImplTest {
    public static UserDaoImpl userDaoImpl = new UserDaoImpl();
    @Test
    public void saveUser() {
         userDaoImpl.saveUser(new User(null,"zhijin","123456","123@123.com"));
    }

    @Test
    public void queryById() {
        System.out.println(userDaoImpl.queryById(3));
    }

    @Test
    public void queryByUsername() {
        System.out.println(userDaoImpl.queryByUsername("lianxing"));
    }

    @Test
    public void deleteUserByUsername() {
        System.out.println(userDaoImpl.deleteUserByUsername("zhijin"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userDaoImpl.queryUserByUsernameAndPassword("lianxing","lianxing"));
    }
}