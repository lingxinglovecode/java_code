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
public interface EmployeeMapper {
    //将哪个属性作为map的主键
    @MapKey("id")
    public Map<Integer,Employee> getEmpByIdLastNameReturnMap(String name);
    public Map<String,Object> getEmpByIdReturnMap(Integer id);
    public List<Employee> getEmpByNameLike(String name);
    public Employee getEmpById(Integer id);
    public Employee getEmpByIdAndLastName(@Param("id") Integer id,@Param("lastName") String lastName);
    public Employee getEmpByMap(Map<String,Object> map);
    public void addEmp(Employee employee);
    public void updateEmp(Employee employee);
    public void deleteEmpById(Integer id);

//    public

}
