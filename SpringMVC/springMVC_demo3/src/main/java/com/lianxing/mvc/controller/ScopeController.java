package com.lianxing.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author lianxing
 * @description
 * @create 2021-12-02 15:20
 */
@Controller
public class ScopeController {

//    使用servletAPI向request域对象中共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope","Hello,servlet API");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        //处理模型数据，向请求域共享数据
        mav.addObject("testRequestScope","hello,ModelAndView");
        //设置视图名称
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,Model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testModel(Map<String,Object> map){
        map.put("testRequestScope","hello,Map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testScope", "hello,ModelMap");
        return "success";
    }

    @RequestMapping("/testSession")
    public String testModelMap( HttpSession session){
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testModelMap( HttpServletRequest request){
        ServletContext application = request.getServletContext();
        application.setAttribute("testAppliacationScope", "hello,application");
        return "success";
    }



}
