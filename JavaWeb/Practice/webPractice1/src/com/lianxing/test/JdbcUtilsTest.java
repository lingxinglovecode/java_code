package com.lianxing.test;

import com.lianxing.utils.JdbcUtils;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author lianxing
 * @description 测试数据库来连接与关闭
 * @create 2021-09-20 23:23
 */
public class JdbcUtilsTest {


    @org.junit.Test
    public void getConnection() {
        System.out.println(JdbcUtils.getConnection());

    }

    @org.junit.Test
    public void closeConnection() {
        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.closeConnection(conn);
        }

    }
}