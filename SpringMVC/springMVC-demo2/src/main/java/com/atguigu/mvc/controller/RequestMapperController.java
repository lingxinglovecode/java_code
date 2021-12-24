package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lianxing
 * @description
 * @create 2021-11-23 14:54
 */
@Controller
@RequestMapping("/test")
public class RequestMapperController {

    @RequestMapping(value = {"/success","/win"},
                    method = {RequestMethod.GET}
                   )
    public String success(){
        return "success";
    }


    @RequestMapping(value = "/testPut",method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }

    @RequestMapping(value = "/testParamsAndHeaders",
                    params = {"username=admin"},
                    headers = {"Host=localhost:8081"})
    public String testParamsAndHeaders(){
        return "success";
    }


    @RequestMapping("/??/testAnt")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/testPath/{username}")
    public String testPath(@PathVariable("username")String username){
        System.out.println(username);
        return "success";
    }
}
