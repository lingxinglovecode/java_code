package com.lianxing.controller;

import com.lianxing.bean.Employee;
import com.lianxing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author lianxing
 * @description
 * @create 2021-12-19 12:32
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/getemps")
    public String emps(Map<String,Object> map){
        List<Employee> emps = employeeService.getEmps();
        map.put("allEmps",emps);
        return "list";
    }
}
