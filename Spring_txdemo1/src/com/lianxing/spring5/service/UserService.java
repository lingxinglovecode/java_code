package com.lianxing.spring5.service;

import com.lianxing.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lianxing
 * @description
 * @create 2021-11-22 21:04
 */
@Service
@Transactional(timeout =10,propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
public class UserService {

    @Autowired
    private UserDao userDao;

    public void accountMoney(){


//        try {
//            //1.开启事务
//
//            //2.进行业务操作
//            userDao.reduceMoney(100,"1");
//            int a = 1/0; //模拟异常
//            userDao.addMoney(100,"2");
//
//            //3.没有异常，提交事务
//        } catch (Exception e) {
//            //4.出现异常，回滚事务
//
//        }

        userDao.reduceMoney(100,"1");
        int a = 1/0; //模拟异常
        userDao.addMoney(100,"2");

    }

}
