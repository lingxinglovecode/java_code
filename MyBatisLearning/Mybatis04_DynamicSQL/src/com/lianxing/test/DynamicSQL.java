package com.lianxing.test;

import com.lianxing.bean.Department;
import com.lianxing.bean.Employee;
import com.lianxing.dao.DepartmentMapper;
import com.lianxing.dao.EmployeeMapperDynamicSQL;
import com.lianxing.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-12-17 14:02
 */
public class DynamicSQL {
    SqlSessionFactory getSqlSessionFactory() throws IOException {
        //1.根据xml配置文件创建一个sqlSessionFactory对象
        String resource = "mybatis-config";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory;
    }

    @Test
    public void testMyBatis1() throws IOException {
        //1.根据xml配置文件创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2.获取sqlsession语句,能够执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(2,null,null,null);
            List<Employee> empsByConditionIf = mapper.getEmpsByConditionIf(employee);
            System.out.println(empsByConditionIf);
        }finally{
            openSession.close();
        }
    }


}
