package DAO;

import util.Customer;

import java.sql.Connection;

/**
 * @author lianxing
 * @description
 * @create 2021-09-12 21:52
 */
public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO{


    @Override
    public void insert(Connection conn, Customer cust) {
        String sql = "Insert into customers(name,email,birth) values(?,?,?)";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth());

    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        update(conn,sql,id);
    }

    @Override
    public void updateCustomer(Connection conn, Customer cust) {
        String sql="update customers set name =? ,email=?,birth=?,photo=? where id=?";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getPhoto(),cust.getId());


    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select name,email,birth from customers where id = ?";
        Customer instance = getInstance(conn, sql, id);
        return instance;
    }
}
