package com.lianxing.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lianxing
 * @description
 * @create 2021-12-10 19:36
 */
@Controller
public class TestController {

    @RequestMapping("/**/testInterceptor")
    public String testInterceptor(){
        return "success";
    }

    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler(){
        System.out.println(1/0);
        return "success";
    }
}
