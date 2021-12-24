package com.lianxing.test;

import com.lianxing.pojo.Cart;
import com.lianxing.pojo.CartItem;
import com.lianxing.service.OrderService;
import com.lianxing.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 20:46
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"测试用书",1,new BigDecimal(12),new BigDecimal(12)));
        cart.addItem(new CartItem(1,"测试用书",1,new BigDecimal(12),new BigDecimal(12)));
        cart.addItem(new CartItem(2,"从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        OrderService orderService = new OrderServiceImpl();

        System.out.println("订单号是:"+orderService.createOrder(cart,1));

    }
}