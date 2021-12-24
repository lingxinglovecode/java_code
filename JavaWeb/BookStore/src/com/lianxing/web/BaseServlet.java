package com.lianxing.web;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author lianxing
 * @description
 * @create 2021-09-24 16:47
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        //解决相应的中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        try {
            //获取action业务鉴别字符串，利用反射的方式调用方法
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);//异常抛给filter过滤器
        }

//        if ( "login".equals(action) ){
//           login(req,resp);
//
//        }else if("regist".equals(action)){
//            regist(req,resp);
//
//        }




    }

}
