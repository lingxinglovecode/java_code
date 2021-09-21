package com.lianxing.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lianxing
 * @description
 * @create 2021-09-20 23:02
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;

    static {
        try {
            InputStream stream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(stream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 获取数据库连接池中的一个连接
     * @param:
     * @return java.sql.Connection
     * @author lianxing
     * @date 2021/9/20 23:18
    */
    public static Connection getConnection(){
        DruidPooledConnection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * @Description: 关闭数据库连接池中的一个连接
     * @param: conn
     * @return void
     * @author lianxing
     * @date 2021/9/20 23:20
    */
    public static void closeConnection(Connection conn){

        if ( conn!=null ) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }






}
