package com.lianxing.service;

import com.lianxing.bean.Employee;
import com.lianxing.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-12-19 12:34
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getEmps(){
        return employeeMapper.getEmps();
    };
}
