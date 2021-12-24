package com.lianxing.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lianxing
 * @description
 * @create 2021-12-02 15:00
 */
@Controller
public class TestController {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }

    @RequestMapping("/testHello")
    public String testHello(){
        return "success";
    }
}
