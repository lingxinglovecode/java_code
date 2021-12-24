package com.lianxing.test;

import com.lianxing.bean.Employee;
import com.lianxing.dao.EmployeeMapper;
import com.lianxing.dao.EmployeeMapperAnnotation;
import com.lianxing.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lianxing
 * @description
 * @create 2021-12-14 14:34
 */







public class CacheTest {

    SqlSessionFactory getSqlSessionFactory() throws IOException {
        //1.根据xml配置文件创建一个sqlSessionFactory对象
        String resource = "mybatis-config";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory;
    }


    @Test
    public void testMyBatis() throws IOException {
        //1.根据xml配置文件创建一个sqlSessionFactory对象
        String resource = "mybatis-config";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession语句,能够执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        //第一个参数：sql的唯一标识，在xml文佳中进行配置
        //第二个参数：传递进行sql的参数
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(2);
            System.out.println(employee);

//            Employee employee3 = mapper.getEmpById(3);
//            System.out.println(employee3);

            Employee employee2 = mapper.getEmpById(2);
            System.out.println(employee2);

        }finally{
            openSession.close();
        }
    }



    @Test
    public void testSecondCache() throws IOException {
        //1.根据xml配置文件创建一个sqlSessionFactory对象
        String resource = "mybatis-config";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession语句,能够执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession2 = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(2);
            System.out.println(employee);
            openSession.close();
            Employee employee2 = mapper2.getEmpById(2);
            System.out.println(employee2);
            openSession2.close();

        }finally{
//            openSession.close();
        }
    }



}
