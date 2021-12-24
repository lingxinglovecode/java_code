package com.lianxing.dao;

import com.lianxing.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author lianxing
 * @description
 * @create 2021-12-15 10:50
 */
public interface EmployeeMapperAnnotation {

    @Select("select * from tbl_employee where id=#{id}")
    public Employee getEmpById(Integer id);
}
