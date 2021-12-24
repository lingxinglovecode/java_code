package com.lianxing.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lianxing
 * @description
 * @create 2021-10-22 16:55
 */
public class SessionServlet extends BaseServlet{

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建或者获取session对象
        HttpSession session = req.getSession();
        //判断当前session会话是否是新创建出来的
        boolean aNew = session.isNew();
        //获取session对象的唯一标识
        String id = session.getId();
        resp.getWriter().write("得到的session的id是"+id+"<br/>");
        resp.getWriter().write("这个session是否为新创建的:"+aNew);

    }

    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("已经往session中添加了数据");
    }
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("从session中获取到key1的数据是"+key1);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();

        resp.getWriter().write("Session的默认超时时长为"+maxInactiveInterval+"秒");

    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("Session的默认超时时长修改为3秒");

    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        session.invalidate();
        resp.getWriter().write("Session已经设置为超时");

    }




}
