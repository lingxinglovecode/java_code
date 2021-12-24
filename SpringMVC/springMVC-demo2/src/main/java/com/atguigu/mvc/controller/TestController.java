package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lianxing
 * @description
 * @create 2021-11-23 14:47
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/param")
    public String param(){
        return "test_param";
    }


}
