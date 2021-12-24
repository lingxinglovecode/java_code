package com.lianxing.spring5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author lianxing
 * @description
 * @create 2021-10-30 22:38
 */

@Service
public class UserService {

//    //不需要添加set方法
//    @Autowired  //根据类型进行注入
//    @Qualifier(value="userDaoImp1")
//    private UserDao userDao;

    @Resource(name = "userDaoImp1")
    private UserDao  userDao;

    @Value(value="abc")
    private String name;

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                ", name='" + name + '\'' +
                '}';
    }

    public void add(){

        System.out.println("service add.....");
        userDao.add();
    }
}
