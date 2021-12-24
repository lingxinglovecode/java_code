package com.lianxing.service;

import com.lianxing.pojo.Cart;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 20:35
 */
public interface OrderService {


    public String createOrder(Cart cart, Integer userId);
}
