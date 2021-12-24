package com.lianxing.dao;

import com.lianxing.pojo.Order;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 20:14
 */
public interface OrderDao {


    public int saveOrder(Order order);
}