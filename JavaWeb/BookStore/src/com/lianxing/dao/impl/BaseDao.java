package com.lianxing.dao.impl;

import com.lianxing.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.awt.color.ICC_Profile;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author lianxing
 * @description
 * @create 2021-09-18 15:06
 */
public abstract class BaseDao {


    private QueryRunner queryRunner = new QueryRunner();


    /*
     * @Description: 用来执行insert/update/delete语句
     * @param:
     * @return int 返回-1表示执行失败，其他表示影响的行数
     * @author lianxing
     * @date 2021/9/18 15:09
    */
    public int update(String sql,Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /*
     * @Description:返回一个javaBean的sql语句
     * @param: type
     * @param: sql
     * @param: args
     * @return T
     * @author lianxing
     * @date 2021/9/18 15:15
    */
    public <T> T queryForOne(Class<T> type,String sql,Object...args){

        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /*
     * @Description:返回多个javaBean的sql语句
     * @param: type
     * @param: sql
     * @param: args
     * @return T
     * @author lianxing
     * @date 2021/9/18 15:15
     */

    public <T> List<T> queryForList(Class<T> type, String sql, Object...args){

        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }


    /*
     * @Description:  返回一行一列的sql语句
     * @param: sql
     * @param: args
     * @return java.lang.Object
     * @author lianxing
     * @date 2021/9/18 15:34
    */
    public Object queryForValue( String sql, Object...args){

        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }



}
