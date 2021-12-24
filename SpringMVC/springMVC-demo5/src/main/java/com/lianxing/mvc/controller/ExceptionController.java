package com.lianxing.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author lianxing
 * @description
 * @create 2021-12-11 14:29
 */
@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(value={ArithmeticException.class,NullPointerException.class})
    public String testException(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }

}
