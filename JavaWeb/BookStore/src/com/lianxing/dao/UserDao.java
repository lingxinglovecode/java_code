package com.lianxing.dao;

import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlShowColumnOutpuVisitor;
import com.lianxing.pojo.User;

/**
 * @author lianxing
 * @description
 * @create 2021-09-18 16:01
 */
public interface UserDao {


    /*
     * @Description: 根据用户名查询用户
     * @param: username
     * @return com.lianxing.pojo.User
     * @author lianxing
     * @date 2021/9/18 16:04
    */
    public User queryUserByUsername(String username);
    
    /*
     * @Description: 保存用户信息
     * @param: user 
     * @return int
     * @author lianxing
     * @date 2021/9/18 16:04 返回-1表示保存失败
    */
    public int savaUser(User user);

    /*
     * @Description: 根据用户名和密码查询用户
     * @param: username
     * @return com.lianxing.pojo.User 返回null说明用户名或者密码错误
     * @author lianxing
     * @date 2021/9/18 16:06
    */
    public User queryUserByUsernameAndPassword(String username,String password);





}
