package com.lianxing.test;

import com.lianxing.bean.Department;
import com.lianxing.bean.Employee;
import com.lianxing.dao.DepartmentMapper;
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
public class MyBatisPlus {
    SqlSessionFactory getSqlSessionFactory() throws IOException {
        //1.根据xml配置文件创建一个sqlSessionFactory对象
        String resource = "mybatis-config";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory;
    }

    @Test
    public void testMyBatisPlus1() throws IOException {
        //1.根据xml配置文件创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2.获取sqlsession语句,能够执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
            Employee empAndDept = mapper.getEmpAndDept(2);
            System.out.println(empAndDept);
        }finally{
            openSession.close();
        }
    }

    @Test
    public void testMyBatisByStep() throws IOException {
        //1.根据xml配置文件创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2.获取sqlsession语句,能够执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
            Employee empByIdStep = mapper.getEmpByIdStep(2);
            System.out.println(empByIdStep.getLastName());
        }finally{
            openSession.close();
        }
    }


    @Test
    public void testMyBatisDdpt() throws IOException {
        //1.根据xml配置文件创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2.获取sqlsession语句,能够执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
            Department deptByIdPlus = mapper.getDeptByIdPlusStep(2);
            System.out.println(deptByIdPlus);
        }finally{
            openSession.close();
        }
    }
}
