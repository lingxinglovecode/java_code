package com.lianxing.spring5.service;

import com.lianxing.spring5.dao.UserDao;
import com.lianxing.spring5.dao.UserDaoImpl;

/**
 * @author lianxing
 * @description
 * @create 2021-10-30 15:07
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                '}';
    }

    public void add(){
        System.out.println("service add.....");
        userDao.update();
//        //原始方式
//        UserDao userDao = new UserDaoImpl();
//        userDao.update();




    }
}
