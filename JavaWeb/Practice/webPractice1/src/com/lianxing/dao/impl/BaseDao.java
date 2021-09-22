package com.lianxing.dao.impl;

/**
 * @author lianxing
 * @description
 * @create 2021-09-20 23:00
 */

import com.lianxing.utils.JdbcUtils;
import com.mysql.jdbc.integration.jboss.ExtendedMysqlExceptionSorter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/***
 * @Description: 抽象类，用于建立与数据库连接的对象规范
 * @param: null 
 * @return * @return null
 * @author lianxing
 * @date 2021/9/20 23:01
*/
public abstract class BaseDao {

     private QueryRunner queryRunner = new QueryRunner();
     
     /**
      * @Description: 用于增删改 
      * @param: sql sql语句用来执行增删改操作
      * @param: args  需要增删改对象的信息
      * @return int  影响的行数，如果返回-1表示修改失败
      * @author lianxing 
      * @date 2021/9/20 23:33
     */
    public int update(String sql,Object...args)  {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(connection);
        }
        return -1;
    }
    
    /**
     * @Description: 在数据库中查找一个符合条件的数据
     * @param: type 需要查找的类的class对象
     * @param: sql
     * @param: args
     * @return T
     * @author lianxing
     * @date 2021/9/21 0:01
    */
    public <T> T queryForOne(Class<T> type,String sql,Object...args)   {

        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;

    }

    /**
     * @Description: 返回多个javaBean对象组成的数组
     * @param: type
     * @param: sql
     * @param: args
     * @return java.util.List<T> 如果返回值为null说明没有查询到
     * @author lianxing
     * @date 2021/9/21 0:07
    */
    public <T> List<T> queryForList(Class<T> type,String sql,Object...args){

        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;

    }

    /**
     * @Description: 返回sql语句查询到的标量，例如数量
     * @param: sql
     * @param: args
     * @return java.lang.Object
     * @author lianxing
     * @date 2021/9/21 0:10
    */
    public Object queryForValue(String sql,Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }

        return null;

    }


}
