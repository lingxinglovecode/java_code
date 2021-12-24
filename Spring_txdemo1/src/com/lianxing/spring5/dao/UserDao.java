package com.lianxing.spring5.dao;

/**
 * @author lianxing
 * @description
 * @create 2021-11-22 21:04
 */
public interface UserDao {


    public void addMoney(int money,String userId);

    public void reduceMoney(int money,String userId);


}
