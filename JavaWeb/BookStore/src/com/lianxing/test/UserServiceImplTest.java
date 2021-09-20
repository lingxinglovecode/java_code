package com.lianxing.test;

import com.lianxing.pojo.User;
import com.lianxing.service.UserService;
import com.lianxing.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lianxing
 * @description
 * @create 2021-09-18 16:44
 */
public class UserServiceImplTest {
    UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"xinyu","qwertt","xinyu@163.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"dadw","dwad",null)));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("lianxing2"));
    }
}