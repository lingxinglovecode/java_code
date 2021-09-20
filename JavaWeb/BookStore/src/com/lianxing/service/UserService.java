package com.lianxing.service;

import com.lianxing.pojo.User;

/**
 * @author lianxing
 * @description
 * @create 2021-09-18 16:25
 */
public interface UserService {

    /*
     * @Description: 注册用户
     * @param: user
     * @return void
     * @author lianxing
     * @date 2021/9/18 16:30
    */
    public void registerUser(User user);

    /*
     * @Description: 登录
     * @param: user
     * @return com.lianxing.pojo.User
     * @author lianxing
     * @date 2021/9/18 16:31
    */
    public User login(User user);



    /*
     * @Description: 检查用户名是否可用
     * @param: username
     * @return boolean
     * @author lianxing
     * @date 2021/9/18 16:32
    */
    public boolean existsUsername(String username);


}
