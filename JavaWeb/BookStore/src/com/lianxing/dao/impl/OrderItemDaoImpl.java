package com.lianxing.dao.impl;

import com.lianxing.dao.OrderItemDao;
import com.lianxing.pojo.OrderItem;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 20:20
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int savaOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
