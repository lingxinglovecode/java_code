package com.lianxing.test;

import com.lianxing.bean.Employee;
import com.lianxing.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lianxing
 * @description
 * @create 2021-12-14 14:34
 */







public class MyBatisTest {

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
            Employee employee = openSession.selectOne("com.lianxing.EmployeeMapper.selectEmp",1);
            System.out.println(employee);
        }finally{
            openSession.close();
        }
    }


    @Test
    public void testMyBatis2() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        }finally{
            openSession.close();
        }

    }

}
