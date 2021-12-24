package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author lianxing
 * @description
 * @create 2021-11-29 15:44
 */
@Controller
public class ParamController {


    @RequestMapping("/test_ServletAPI")
    public String param(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+" password:"+password);
        return "success";
    }


    @RequestMapping("/testParam")
    public String testParam(
            HttpServletRequest request,
            @RequestParam("user_name") String username,
            String password,
            String[] hobby,
            @RequestHeader(value="Host",defaultValue="localhost",required=true) String host,
            @CookieValue(value="JSESSIONID",defaultValue="haha") String JSESSIONID){
        HttpSession session = request.getSession();
        System.out.println("username:"+username+" password:"+password+" hobby"+ Arrays.toString(hobby));
        System.out.println("Hostname:"+host);
        System.out.println("JESSIONID:"+JSESSIONID);
        return "success";
    }

    @RequestMapping("/testpojo")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }



}
