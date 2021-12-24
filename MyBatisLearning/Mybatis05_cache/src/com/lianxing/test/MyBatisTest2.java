package com.lianxing.test;

import com.lianxing.bean.Department;
import com.lianxing.bean.Employee;
import com.lianxing.dao.DepartmentMapper;
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







public class MyBatisTest2 {

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


//
//      两级缓存：
//      一级缓存：（本地缓存）：sqlSession级别的缓存。一级缓存是一直开启的；SqlSession级别的一个Map
//      		与数据库同一次会话期间查询到的数据会放在本地缓存中。
//      		以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库；
//
//      		一级缓存失效情况（没有使用到当前一级缓存的情况，效果就是，还需要再向数据库发出查询）：
//      		1、sqlSession不同。
//      		2、sqlSession相同，查询条件不同.(当前一级缓存中还没有这个数据)
//      		3、sqlSession相同，两次查询之间执行了增删改操作(这次增删改可能对当前数据有影响)
//      		4、sqlSession相同，手动清除了一级缓存（缓存清空）
//
//      二级缓存：（全局缓存）：基于namespace级别的缓存：一个namespace对应一个二级缓存：
//      		工作机制：
//      		1、一个会话，查询一条数据，这个数据就会被放在当前会话的一级缓存中；
//      		2、如果会话关闭；一级缓存中的数据会被保存到二级缓存中；新的会话查询信息，就可以参照二级缓存中的内容；
//      		3、sqlSession===EmployeeMapper==>Employee
//      						DepartmentMapper===>Department
//      			不同namespace查出的数据会放在自己对应的缓存中（map）
//    效果：数据会从二级缓存中获取
//      				查出的数据都会被默认先放在一级缓存中。
//      				只有会话提交或者关闭以后，一级缓存中的数据才会转移到二级缓存中
//      		使用：
//            1）、开启全局二级缓存配置：<setting name="cacheEnabled" value="true"/>
//      			2）、去mapper.xml中配置使用二级缓存：
//      				<cache></cache>
//     			3）、我们的POJO需要实现序列化接口

//      和缓存有关的设置/属性：
//      			1）、cacheEnabled=true：false：关闭缓存（二级缓存关闭）(一级缓存一直可用的)
//      			2）、每个select标签都有useCache="true"：
//      					false：不使用缓存（一级缓存依然使用，二级缓存不使用）
//      			3）、【每个增删改标签的：flushCache="true"：（一级二级都会清除）】
//      					增删改执行完成后就会清楚缓存；
//      					测试：flushCache="true"：一级缓存就清空了；二级也会被清除；
//      					查询标签：flushCache="false"：
//      						如果flushCache=true;每次查询之后都会清空缓存；缓存是没有被使用的；
//      			4）、sqlSession.clearCache();只是清楚当前session的一级缓存；
//      			5）、localCacheScope：本地缓存作用域：（一级缓存SESSION）；当前会话的所有数据保存在会话缓存中；
//      								STATEMENT：可以禁用一级缓存；

//     第三方缓存整合：
//     		1）、导入第三方缓存包即可；
//     		2）、导入与第三方缓存整合的适配包；官方有；
//     		3）、mapper.xml中使用自定义缓存
//     		<cache type="org.mybatis.caches.ehcache.EhcacheCache"></cache>


}
