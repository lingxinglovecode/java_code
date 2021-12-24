package com.lianxing.servlet;

import com.lianxing.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lianxing
 * @description
 * @create 2021-10-21 17:20
 */
public class CookieServlet extends BaseServlet{

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1","path1");

        cookie.setPath(req.getContextPath()+"/abc"); //  /工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有路径的Cookie");

    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //返回cookie的名称
            resp.getWriter().write("Cookie["+cookie.getName()+"]="+cookie.getValue()+"<br/>");
        }
        Cookie iWantCookie = null;
        iWantCookie = CookieUtils.findCookie("key1",cookies);
        if ( iWantCookie!=null ){
            resp.getWriter().write("找到了我要的Cookie");
        }



    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        // 1、先创建一个要修改的同名（指的就是 key）的 Cookie 对象
//        // 2、在构造器，同时赋于新的 Cookie 值。
//        Cookie cookie = new Cookie("key1","newValue1");
//        // 3、调用 response.addCookie( Cookie )
//        resp.addCookie(cookie);

//        1. 先查找到需要修改的Cookie对象，然后
            Cookie cookie= CookieUtils.findCookie("key2",req.getCookies());
//        2. 调用setValue()方法赋予新的值
            if ( cookie != null ) {
                cookie.setValue("newValue2");
            }

//        3. 调用 response.addCookie( Cookie )
            resp.addCookie(cookie);

    }


    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建cookie
        Cookie cookie = new Cookie("key1","value1");
        Cookie cookie2 = new Cookie("key2","value2");
        //2.通知客户端保存cookie
        resp.addCookie(cookie);
        resp.addCookie(cookie2);

        resp.getWriter().write("Cookie创建成功");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);

    }


    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先找到要删除的Cookie的对象
        Cookie cookie = CookieUtils.findCookie("key2",req.getCookies());
        //setMaxAge
        if ( cookie != null){
            cookie.setMaxAge(0);
        }
        resp.addCookie(cookie);
        resp.getWriter().write("key2的Cookie删除成功");
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先找到要删除的Cookie的对象
        Cookie cookie = new Cookie("life1600","life3600");
        //setMaxAge

        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的cookie");
    }
}
