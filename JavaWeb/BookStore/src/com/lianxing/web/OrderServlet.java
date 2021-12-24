package com.lianxing.web;

import com.lianxing.pojo.Cart;
import com.lianxing.pojo.User;
import com.lianxing.service.OrderService;
import com.lianxing.service.impl.OrderServiceImpl;
import com.lianxing.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 20:50
 */
public class OrderServlet extends BaseServlet {
    public OrderService orderService =  new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取cart对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        //获取userId
        User user = (User) req.getSession().getAttribute("user");
        if ( user==null ){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        Integer userId = user.getId();


        String orderId = null;

        orderId = orderService.createOrder(cart, userId);


//        req.setAttribute("orderId",orderId);
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);

        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
