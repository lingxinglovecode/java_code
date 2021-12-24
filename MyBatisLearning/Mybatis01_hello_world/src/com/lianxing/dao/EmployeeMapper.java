package com.lianxing.dao;

import com.lianxing.bean.Employee;

/**
 * @author lianxing
 * @description
 * @create 2021-12-15 10:50
 */
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
}
