package com.lianxing.bean;

import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-12-17 10:18
 */
public class Department {
    private Integer id;
    private String departmentName;
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Department() {
    }
}
