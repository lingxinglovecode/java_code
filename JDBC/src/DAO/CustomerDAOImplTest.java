package DAO;

import util.Customer;
import util.JDBCUtils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lianxing
 * @description
 * @create 2021-09-12 22:07
 */
class CustomerDAOImplTest {
    public static CustomerDAOImpl dao = new CustomerDAOImpl();


    @org.junit.jupiter.api.Test
    void insert()  {
        Connection connection =null;
        try {
            connection = JDBCUtils.getConnectionFromPool();


            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse("2022-09-12");
            java.sql.Date date = new java.sql.Date(parse.getTime());

            Customer cust = new Customer(10,"kk","kun@163.com",date,null);
            dao.insert(connection,cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }


    }

    @org.junit.jupiter.api.Test
    void deleteById()  {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnectionFromPool();
            dao.deleteById(connection,3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }

    }

    @org.junit.jupiter.api.Test
    void update() throws Exception {
        Connection connection = null;
        try {
             connection = JDBCUtils.getConnectionFromPool();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse("2022-09-12");
            java.sql.Date date = new java.sql.Date(parse.getTime());

            Customer cust = new Customer(2,"玛卡巴卡","maka@163.com",date,null);
            dao.updateCustomer(connection,cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }


    }

    @org.junit.jupiter.api.Test
    void getCustomerById() {
        Connection connection = null;
        try {
             connection = JDBCUtils.getConnectionFromPool();

            Customer customer = dao.getCustomerById(connection, 2);
            System.out.println(customer);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,null);
        }


    }

    @org.junit.jupiter.api.Test
    void blobTest() throws Exception {

        FileInputStream fis = new FileInputStream("D:\\code\\JDBC\\src\\1.jpg");

        Connection connection = JDBCUtils.getConnectionFromPool();

        Customer customer = new Customer(3,"玛卡巴卡","maka@163.com",new java.sql.Date(341489814L),fis);

        dao.updateCustomer(connection,customer);





    }



}