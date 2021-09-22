package com.lianxing.dao;

import com.lianxing.pojo.User;

/**
 * @author lianxing
 * @description 针对User对象操作的规范
 * @create 2021-09-21 13:12
 */
public interface UserDao {


    /**
     * @Description: 注册用户，将用户数据存储到数据库
     * @param: user
     * @return int
     * @author lianxing
     * @date 2021/9/21 13:17
    */
    public int saveUser(User user);

    /**
     * @Description: 通过id查询用户信息
     * @param: id
     * @return com.lianxing.pojo.User
     * @author lianxing
     * @date 2021/9/21 13:18
    */
    public User queryById(int id);

    /**
     * @Description: 通过用户名查询用户信息
     * @param: username
     * @return com.lianxing.pojo.User
     * @author lianxing
     * @date 2021/9/21 13:19
    */
    public User queryByUsername(String username);

    /**
     * @Description: 通过用户名删除用户
     * @param: username
     * @return int 返回为0表示删除失败，1表示删除成功
     * @author lianxing
     * @date 2021/9/21 13:20
    */
    public int deleteUserByUsername(String username);

    /**
     * @Description: 通过用户名和密码查询用户
     * @param: username
     * @param: password
     * @return com.lianxing.pojo.User
     * @author lianxing
     * @date 2021/9/21 13:22
    */
    public User queryUserByUsernameAndPassword(String username,String password);

}
