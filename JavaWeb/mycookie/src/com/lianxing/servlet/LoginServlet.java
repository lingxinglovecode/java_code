package com.lianxing.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lianxing
 * @description
 * @create 2021-10-22 16:04
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ( "lianxing".equals(username) && "123456".equals(password)){
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60*60*24*7); //一周内有效
            resp.addCookie(cookie);
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
