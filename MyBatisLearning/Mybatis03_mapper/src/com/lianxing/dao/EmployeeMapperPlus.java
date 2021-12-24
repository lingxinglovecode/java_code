package com.lianxing.dao;

import com.lianxing.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lianxing
 * @description
 * @create 2021-12-15 10:50
 */
public interface EmployeeMapperPlus {

    public Employee getEmpById(Integer id);

    public Employee getEmpAndDept(Integer id);

    public Employee getEmpByIdStep(Integer id);

    public List<Employee> getEmpsByDept(Integer id);
}
