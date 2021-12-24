package com.lianxing.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lianxing
 * @description
 * @create 2021-12-08 23:05
 */
@Controller
public class JspController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
