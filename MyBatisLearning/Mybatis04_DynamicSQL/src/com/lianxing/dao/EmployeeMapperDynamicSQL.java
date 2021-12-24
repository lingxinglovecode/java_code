package com.lianxing.dao;

import com.lianxing.bean.Employee;

import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-12-15 10:50
 */
public interface EmployeeMapperDynamicSQL {

    public List<Employee> getEmpsByConditionIf(Employee employee);
}
