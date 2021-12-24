package com.lianxing.web;

import com.google.gson.Gson;
import com.lianxing.pojo.Book;
import com.lianxing.pojo.Cart;
import com.lianxing.pojo.CartItem;
import com.lianxing.service.BookService;
import com.lianxing.service.impl.BookServiceImpl;
import com.lianxing.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 15:18
 */
public class CartServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();


    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService获取图书信息
        Book book = bookService.queryBookById(id);
        //创建cartItem对象
        CartItem cartItem = new CartItem(id,book.getName(),1,book.getPrice(),book.getPrice());
        //将对象添加到Cart中
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if ( cart==null ){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        //重定向回商品页面
        resp.sendRedirect(req.getHeader("Referer"));

        req.getSession().setAttribute("lastName",cartItem.getName());
    }


    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if ( cart!=null ){
            cart.deleteItem(id);
        }

        resp.sendRedirect(req.getHeader("Referer"));

    }


    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if ( cart!=null ){
            cart.clear();
        }

        resp.sendRedirect(req.getHeader("Referer"));

    }
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"),1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if ( cart!=null ){
            cart.updateCount(id,count);
        }

        resp.sendRedirect(req.getHeader("Referer"));

    }


    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService获取图书信息
        Book book = bookService.queryBookById(id);
        //创建cartItem对象
        CartItem cartItem = new CartItem(id,book.getName(),1,book.getPrice(),book.getPrice());
        //将对象添加到Cart中
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if ( cart==null ){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        Map<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("totalCount",cart.getTotalCount());
        hashMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String json = gson.toJson(hashMap);
        resp.getWriter().write(json);


    }
}
