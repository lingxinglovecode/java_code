package com.lianxing.web;

import com.lianxing.pojo.User;
import com.lianxing.service.UserService;
import com.lianxing.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;

/**
 * @author lianxing
 * @description
 * @create 2021-09-18 17:00
 */
public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if ("abcde".equalsIgnoreCase(code) ){
            if ( userService.existsUsername(username) ){
                System.out.println("用户名"+username+"已存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);


            }else {
                userService.registerUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }



        }else {
            //回显信息保存到requset域之中
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);


            System.out.println("验证码"+code+"错误！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }


    }
}
