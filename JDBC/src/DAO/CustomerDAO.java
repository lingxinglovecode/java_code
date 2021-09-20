package DAO;

import util.Customer;

import java.sql.Connection;

/**
 * @author lianxing
 * @description
 * @create 2021-09-12 21:49
 */
public interface  CustomerDAO {


    void insert(Connection conn, Customer cust);


    void deleteById(Connection conn,int id);

    void updateCustomer(Connection conn,Customer cust);

    Customer getCustomerById(Connection conn,int id);




}
