package com.lianxing.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lianxing
 * @description
 * @create 2021-11-23 10:52
 */
@Controller
public class HelloContoller {

    // "/" --> /WEB-INF/templates/index.html
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/target")
    public String toTarget() {
        return "target";
    }
}
