package com.lianxing.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lianxing
 * @description
 * @create 2021-09-18 14:09
 */
public class JdbcUtils {


    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns= new ThreadLocal<Connection>();

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//    /*
//     * @Description: 关闭数据库与连接池中的连接
//     * @param: connection
//     * @return void
//     * @author lianxing
//     * @date 2021/9/18 14:24
//    */
//    public static void close(Connection conn){
//
//        if ( conn!=null ) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }

    /**
     * @Description: 提交事务并关闭释放连接
     * @param: conn
     * @return void
     * @author lianxing
     * @date 2021/10/24 15:18
    */
    public static  void commitAndClose( ){
        Connection connection = conns.get();
        if ( connection!=null ){//如果不等于null，说明操作过数据库
            try {
                connection.commit();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要是执行remove操作，否则回出错
        conns.remove();



    }

    public static  void rollbackAndClose( ){
        Connection connection = conns.get();
        if ( connection!=null ){//如果不等于null，说明操作过数据库
            try {
                connection.rollback();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要是执行remove操作，否则回出错
        conns.remove();

    }



    /**
     * @Description:获取数据库连接池中的连接，返回null说明获取连接失败
     * @param:
     * @return java.sql.Connection
     * @author lianxing
     * @date 2021/9/18 14:18
    */
    public static Connection getConnection(){
        Connection conn = conns.get();
        if ( conn==null ){
            try {
                conn = dataSource.getConnection();
                conns.set(conn); //保存到ThreadLocal中
                conn.setAutoCommit(false); //设置为手动管理事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;

    }


}
