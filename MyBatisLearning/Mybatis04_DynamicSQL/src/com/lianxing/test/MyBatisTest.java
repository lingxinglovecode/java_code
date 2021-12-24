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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testMyBatis3() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapperAnnotation mapper = openSession.getMapper(EmployeeMapperAnnotation.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        }finally{
            openSession.close();
        }

    }

    @Test
    public void testMyBatisAdd() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象，不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee nainai = new Employee(null, "nainai", "qingyuan@samii.vc", "1");
            mapper.addEmp(nainai);
            openSession.commit();
            System.out.println(nainai.getId());
        }finally{
            openSession.close();
        }

    }

    @Test
    public void testMyBatisUpdate() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象，不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee nainai = new Employee(1, "nainai", "qingyuan@samii.vc", "1");
            mapper.updateEmp(nainai);
            openSession.commit();
        }finally{
            openSession.close();
        }

    }


    @Test
    public void testMyBatisDelete() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象，不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            mapper.deleteEmpById(1);
            openSession.commit();
        }finally{
            openSession.close();
        }

    }

    @Test
    public void testMyBatisParamAnno() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象，不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            HashMap<String, Object> map = new HashMap<>();
            Employee employee = mapper.getEmpByIdAndLastName(2,"nainai");
            System.out.println(employee);

        }finally{
            openSession.close();
        }

    }

    @Test
    public void testMyBatisParam() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象，不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",2);
            map.put("lastName","nainai");
            Employee employee = mapper.getEmpByMap(map);
            System.out.println(employee);

        }finally{
            openSession.close();
        }

    }


    @Test
    public void testMyBatisParamList() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象，不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = mapper.getEmpByNameLike("%nai%");
            System.out.println(employees);

        }finally{
            openSession.close();
        }

    }

    @Test
    public void testMyBatisParamMap() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象，不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Map<String, Object> empByIdReturnMap = mapper.getEmpByIdReturnMap(2);
            System.out.println(empByIdReturnMap);


        }finally{
            openSession.close();
        }

    }

    @Test
    public void testMyBatisParamReturnMap() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象，不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Map<Integer, Employee> empByIdLastNameReturnMap = mapper.getEmpByIdLastNameReturnMap("%nai%");

            System.out.println(empByIdLastNameReturnMap);


        }finally{
            openSession.close();
        }

    }



    @Test
    public void testMyBatisPlus() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象，不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
            Employee empById = mapper.getEmpById(2);
            System.out.println(empById);



        }finally{
            openSession.close();
        }

    }

    @Test
    public void testMyBatisPlusStep() throws IOException {
//        1.创建一个sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        2.获取sqlSession对象，不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3.为接口自动创建一个代理对象
            EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
            mapper.getEmpsByDept(2);
            Employee empById = mapper.getEmpById(2);
            System.out.println(empById);



        }finally{
            openSession.close();
        }

    }
}
