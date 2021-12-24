package com.lianxing.test;

import com.lianxing.dao.OrderDao;
import com.lianxing.dao.OrderItemDao;
import com.lianxing.dao.impl.OrderDaoImpl;
import com.lianxing.dao.impl.OrderItemDaoImpl;
import com.lianxing.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 20:31
 */
public class OrderItemDaoTest {

    @Test
    public void savaOrderItem() {
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        orderItemDao.savaOrderItem(new OrderItem(null,"java入门",1,new BigDecimal(100),new BigDecimal(100),"123431"));
        orderItemDao.savaOrderItem(new OrderItem(null,"javascript入门",2,new BigDecimal(200),new BigDecimal(100),"123431"));
        orderItemDao.savaOrderItem(new OrderItem(null,"python入门",2,new BigDecimal(200),new BigDecimal(100),"123431"));
    }
}