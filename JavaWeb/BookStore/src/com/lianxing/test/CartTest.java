package com.lianxing.test;

import com.lianxing.pojo.Cart;
import com.lianxing.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 14:40
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"测试用书",1,new BigDecimal(12),new BigDecimal(12)));
        cart.addItem(new CartItem(1,"测试用书",1,new BigDecimal(12),new BigDecimal(12)));
        cart.addItem(new CartItem(2,"从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"测试用书",1,new BigDecimal(12),new BigDecimal(12)));
        cart.addItem(new CartItem(1,"测试用书",1,new BigDecimal(12),new BigDecimal(12)));
        cart.addItem(new CartItem(2,"从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));

        System.out.println(cart);

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"测试用书",1,new BigDecimal(12),new BigDecimal(12)));
        cart.addItem(new CartItem(1,"测试用书",1,new BigDecimal(12),new BigDecimal(12)));
        cart.addItem(new CartItem(2,"从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));

        System.out.println(cart);

        cart.deleteItem(1);
        System.out.println(cart);

        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void updateCount() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"测试用书",1,new BigDecimal(12),new BigDecimal(12)));
        cart.addItem(new CartItem(1,"测试用书",1,new BigDecimal(12),new BigDecimal(12)));
        cart.addItem(new CartItem(2,"从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));

        System.out.println(cart);

        cart.deleteItem(1);
        System.out.println(cart);

        cart.clear();

        System.out.println(cart);

        cart.addItem(new CartItem(2,"从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        cart.updateCount(2,10);
        System.out.println(cart);
    }
}