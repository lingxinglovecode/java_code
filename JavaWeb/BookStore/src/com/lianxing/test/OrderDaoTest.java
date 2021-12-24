package com.lianxing.test;

import com.lianxing.dao.OrderDao;
import com.lianxing.dao.impl.OrderDaoImpl;
import com.lianxing.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 20:23
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("123431", new Date(),new BigDecimal(100),0,1));

    }
}