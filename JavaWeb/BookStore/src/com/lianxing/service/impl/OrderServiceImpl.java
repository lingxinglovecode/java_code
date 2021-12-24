package com.lianxing.service.impl;

import com.lianxing.dao.BookDao;
import com.lianxing.dao.OrderDao;
import com.lianxing.dao.OrderItemDao;
import com.lianxing.dao.impl.BookDaoImpl;
import com.lianxing.dao.impl.OrderDaoImpl;
import com.lianxing.dao.impl.OrderItemDaoImpl;
import com.lianxing.pojo.*;
import com.lianxing.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 20:36
 */
public class OrderServiceImpl implements OrderService  {
    private static OrderDao orderDao = new OrderDaoImpl();
    private static OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private static BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + ""+userId;
        //创建一个订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);


        //遍历购物车中每一商品项转换为订单项
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.savaOrderItem(orderItem);

            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clear();
        return orderId;
    }
}
