package com.lianxing.spring5;

/**
 * @author lianxing
 * @description
 * @create 2021-10-31 12:05
 */
public class UserDaoImpl implements UserDao{
    @Override
    public int add(int a, int b) {
        System.out.println("方法执行");
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
