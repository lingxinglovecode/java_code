package com.lianxing.service.impl;

import com.lianxing.dao.UserDao;
import com.lianxing.dao.impl.UserDaoImpl;
import com.lianxing.pojo.User;
import com.lianxing.service.UserService;

import javax.xml.crypto.dsig.keyinfo.X509IssuerSerial;

/**
 * @author lianxing
 * @description
 * @create 2021-09-18 16:42
 */
public class UserServiceImpl implements UserService {

    private static  UserDao userDao = new UserDaoImpl();


    @Override
    public void registerUser(User user) {
        userDao.savaUser(user);

    }

    /**
     * @Description: 登录
     * @param: user
     * @return com.lianxing.pojo.User 如果返回null，说明登录失败
     * @author lianxing
     * @date 2021/9/18 16:48
    */
    @Override
    public User login(User user) {
       return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }


    @Override
    public boolean existsUsername(String username) {

        if ( userDao.queryUserByUsername(username) == null ){
            return false;
        }

        return true;
    }
}
