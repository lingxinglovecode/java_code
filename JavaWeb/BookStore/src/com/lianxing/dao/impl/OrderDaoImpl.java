package com.lianxing.dao.impl;

import com.lianxing.dao.OrderDao;
import com.lianxing.pojo.Order;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 20:16
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderID(),order.getCreateDate(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
