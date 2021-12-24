package com.lianxing.spring5.service;

import org.springframework.stereotype.Repository;

/**
 * @author lianxing
 * @description
 * @create 2021-10-31 9:39
 */
@Repository(value = "userDaoImp1")
public class UserDaoImp implements UserDao{

    @Override
    public void add() {
        System.out.println("UserDaoImp add...");
    }
}
