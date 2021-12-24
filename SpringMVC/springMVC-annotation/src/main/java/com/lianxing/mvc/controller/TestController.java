package com.lianxing.mvc.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lianxing
 * @description
 * @create 2021-12-11 15:29
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public  String testController(){
        return "index";
    }
}
