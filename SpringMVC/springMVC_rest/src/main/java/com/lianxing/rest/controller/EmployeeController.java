package com.lianxing.rest.controller;

import com.lianxing.rest.bean.Employee;
import com.lianxing.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * @author lianxing
 * @description
 * @create 2021-12-09 16:05
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value="/employee", method= RequestMethod.GET)
    public String getAllEmployees(Model model) {
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList",employeeList);
        return "employee_list";

    }

    @RequestMapping(value="/employee/{id}", method= RequestMethod.DELETE)
    public String getAllEmployees(@PathVariable("id") Integer id) {
        employeeDao.delete(id);

        //下面默认为get请求
        return "redirect:/employee";
    }

    @RequestMapping(value="/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";

    }
    @RequestMapping(value="/employee/{id}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id")Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);

        return "employee_update";
    }

    @RequestMapping(value="/employee",method = RequestMethod.PUT)
    public String updateEmployeeById(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }



}
