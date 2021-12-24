package com.lianxing.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lianxing
 * @description
 * @create 2021-12-07 15:52
 */
@Controller
public class ViewController {


    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }



    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testHello";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testHello";
    }

}
