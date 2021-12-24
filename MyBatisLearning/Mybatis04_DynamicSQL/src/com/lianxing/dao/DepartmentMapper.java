package com.lianxing.dao;

import com.lianxing.bean.Department;
import com.lianxing.bean.Employee;

import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-12-17 14:38
 */
public interface DepartmentMapper {

    public Department getDeptById(Integer id);
    public  Department  getDeptByIdPlus(Integer id);
    public  Department  getDeptByIdPlusStep(Integer id);

}
