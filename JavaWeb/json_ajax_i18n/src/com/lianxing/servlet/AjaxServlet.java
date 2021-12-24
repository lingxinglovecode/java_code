package com.lianxing.servlet;

import com.google.gson.Gson;
import com.lianxing.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lianxing
 * @description
 * @create 2021-10-26 9:54
 */
public class AjaxServlet extends BaseServlet{


    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到了请求");
        Person person = new Person(1, "ni");

        //json格式字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryAjax方法调用");
        Person person = new Person(1, "ni");

        //json格式字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryGet方法调用");
        Person person = new Person(1, "ni");

        //json格式字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryPost方法调用");
        Person person = new Person(1, "ni");

        //json格式字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }
    protected void getJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getJson方法调用");
        Person person = new Person(1, "ni");

        //json格式字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }
    protected void JquerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("JquerySerialize方法调用");
        System.out.println("用户名："+req.getParameter("name")+" 密码："+req.getParameter("password"));
        Person person = new Person(1, "ni");

        //json格式字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }



}
